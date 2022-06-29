package javacourse.dbserver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFileName {
    public static List<File> getFile(File file){
        // 获得该文件夹内的所有文件
        File[] array = file.listFiles();
        List<File> fileList = new ArrayList<>();
        for(int i=0;i<array.length;i++)
        {
            if(array[i].isFile())//如果是文件
            {
                System.out.println( array[i].getName()); //文件名
                fileList.add(array[i]);
            }
            else if(array[i].isDirectory())//如果是文件夹
            {
                List<File> file1 = getFile(array[i]);
                for (File file2:file1){
                    fileList.add(file2);
                    System.out.println(file2.getName());
                }
            }
        }
            return fileList;
    }

//    public static void main(String[] args) {
//        List<File> file = getFile(new File("E:\\workpace\\swingproject\\image1"));
//    }

}
