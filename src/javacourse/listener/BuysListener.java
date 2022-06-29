package javacourse.listener;

import javacourse.GUI.BuysGUI;
import javacourse.dbserver.Clientserver;
import javacourse.entity.Buys;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class BuysListener implements ActionListener {
    public Users users;
    public Integer page;
    public JFrame frame;

    public BuysListener(Users users, Integer page, JFrame frame) {
        this.users = users;
        this.page = page;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("请求服务器！");
            String info = "已购买:"+String.valueOf(users.getUsername());
            outputStream.write(info.getBytes());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            List<Buys> buysList = (List<Buys>) objectInputStream.readObject();
                if(page!=null){
                    if(!frame.getTitle().equals("首页")){
                        frame.dispose();
                    }
                    new BuysGUI(users,page,buysList).init();
                }else{
                    if(!frame.getTitle().equals("首页")){
                        frame.dispose();
                    }
                    new BuysGUI(users,0,buysList).init();
                }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

//        }catch (SQLException eq){
//            eq.printStackTrace();
//        }
    }
}
