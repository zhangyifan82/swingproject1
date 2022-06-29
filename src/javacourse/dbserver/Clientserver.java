package javacourse.dbserver;

import java.io.IOException;
import java.net.Socket;

public class Clientserver {
    public static  Socket socket;
    static {
        try {
            socket = new Socket("127.0.0.1",8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Socket Getsocket()throws IOException{
        return socket;
    }
}
