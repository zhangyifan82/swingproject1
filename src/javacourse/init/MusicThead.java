package javacourse.init;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicThead extends Thread {
    public boolean isplay;
    public  SourceDataLine auline ;
    public MusicThead() {
    }

    public void setIsplay(boolean isplay) {
        this.isplay = isplay;
    }

    public void run() {
        isplay=true;
        File soundFile = new File("src/image/OtherIcon/IN-K&王忻辰-落差(DJ版).wav");

        // 获取音频输入流
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e1) {
            e1.printStackTrace();
            return;
        }
        // 获取音频编码对象
        AudioFormat format = audioInputStream.getFormat();
        // 设置数据输入
         auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            if (auline==null){
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        if(auline.isActive()){
            auline.stop();
        }else {
            auline.start();
        }

        /*
         * 从输入流中读取数据发送到混音器
         */
        int nBytesRead = 0;
        byte[] abData = new byte[512];

        try {
            while (isplay&&nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auline.write(abData, 0, nBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            // 清空数据缓冲,并关闭输入
            auline.drain();
            auline.close();
        }
    }
}
