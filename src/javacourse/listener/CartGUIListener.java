package javacourse.listener;

import javacourse.GUI.ShoppingcartGUI;
import javacourse.dbserver.Query;
import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CartGUIListener implements ActionListener {
    public Users users;
    public Integer page;
    public JFrame frame;

    public CartGUIListener(Users users, Integer page, JFrame frame) {
        this.users = users;
        this.page = page;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<ShoppingCart> list = new Query(users).queryCartlist();
            if(page!=null){
                if(!frame.getTitle().equals("首页")){
                    frame.dispose();
                }
                new ShoppingcartGUI(page,list,users).init();
            }else{
                if(!frame.getTitle().equals("首页")){
                    frame.dispose();
                }
                new ShoppingcartGUI(0,list,users).init();
            }
    }
}
