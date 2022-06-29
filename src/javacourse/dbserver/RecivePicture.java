package javacourse.dbserver;

import java.io.*;
import java.net.Socket;
//E:\workpace\swingproject - 副本\src\image2 E:\workpace\swingproject - 副本\src\image2\服装1.jpg image/LoginIcon/登录背景.jpeg
public class RecivePicture {
        private static final String PATH =  "E:" + File.separator+ "workpace" + File.separator+"swingproject - 副本" + File.separator+"src" +File.separator+"image2" + File.separator;;
        public static  Socket socket;

    static {
        try {
            socket = new Socket("127.0.0.1",9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//接收图片
    public static void recivepicture() {
            try {
                PrintWriter out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
                DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                System.out.println("start client....");
                out.println("sendImage");
                out.flush();
                System.out.println("sendImage....");
                byte[] buffer = new byte[2 * 1024];
                int len = -1;
                String imageName = null;
                FileOutputStream fos = null;
                File file = null;
                long fileLength = -1;
                while(true) {
                    imageName = inputStream.readUTF();
                    if(imageName != null && imageName.trim().equals("end")) {
                        break;
                    }
                    file = new File(PATH + imageName);
                    if(!file.exists()) {
                        file.createNewFile();
                    } else if(file.isFile()) {
                        file.delete();
                        file.createNewFile();
                    } else if(file.isDirectory()) {
                        continue;
                    }
                    fileLength = inputStream.readLong();
                    len = -1;
                    fos = new FileOutputStream(file);
                    while(fileLength > 0) {
                        len = inputStream.read(buffer);
                        fos.write(buffer, 0, len);
                        if(len != -1) {
                            fileLength -= len;
                        }
                    }
                    fos.flush();
                    fos.close();
                    fos = null;
                    imageName = null;
                    file = null;
                }
                out.close();
                socket.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

