package javacourse.dbserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPicture {
        //定义要读取的图片的路径
        public static final String IMAGE_PATH = "E:" + File.separator+ "workpace" + File.separator+"swingproject" + File.separator+"image1" + File.separator;
        //图片备份的文件夹路径
        public static final String TEMP_IMAGE_PATH = "E:" + File.separator+ "workpace" + File.separator+"swingproject" + File.separator+"temp" + File.separator;


        public static void serverpicture() {
            try {
                ServerSocket server = new ServerSocket(9999);
                Socket client = server.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
                System.out.println("start server...");
                String line = reader.readLine();
                System.out.println("line -- > " + line);
                out = readImagesFromCard(out);
                out.flush();
                out.close();
                client.close();
                server.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        //读取图片，并存放在socket下的outputStream输出流中
        public static DataOutputStream readImagesFromCard(DataOutputStream dos) {
            File[] files = null;
            try {
                InputStream inputStream = null;
                int size = 2 * 1024;
                byte[] buffer = new byte[size];
                byte[] b = null;
                int len;
                String path = IMAGE_PATH;
                File file = new File(path);
                if(file.isDirectory()) {
                    files = file.listFiles();
                    for(int i = 0 ; i < files.length ; i ++) {
                        len = -1;
                        if(files[i].isFile()) {
                            inputStream = readImage(files[i]);
                            dos.writeUTF(files[i].getName());
                            dos.writeLong(files[i].length());
                            while((len = inputStream.read(buffer)) != -1) {
                                dos.write(buffer, 0, len);
                                if(len != size) {//如果该图片的字节数不是size的倍数，则填满size个字节
                                    b = new byte[size - len];
                                    dos.write(b,0,b.length);
                                }
                            }
                            //先关闭该文件的输入流，否则无法删除
                            inputStream.close();
                        }
                    }
                    dos.writeUTF("end");
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            return dos;
        }

        //如果该图片没有备份，则先备份，最后返回该文件的InputStream输入流
        public static InputStream readImage(File file) {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                File tempFile = new File(TEMP_IMAGE_PATH + file.getName());
                if(!tempFile.exists()) {
                    tempFile.createNewFile();
                    FileOutputStream outputStream = new FileOutputStream(tempFile);
                    byte[] buffer = new byte[2 * 1024];
                    int len = -1;
                    while((len = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer,0,len);
                    }
                    outputStream.close();
                    inputStream.close();
                    inputStream = null;
                    inputStream = new FileInputStream(file);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            return inputStream;
        }
    }

