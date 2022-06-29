package javacourse.listener;

import javacourse.GUI.ShoppingcartGUI;
import javacourse.dbserver.Query;
import javacourse.daoimp.ShoppingCartImp;
import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShoppingCartDeleteListener implements ActionListener {
    public ShoppingCart shoppingCart;
    public JFrame frame;
    public int page;
    public Users users;

    public ShoppingCartDeleteListener(ShoppingCart shoppingCart, JFrame frame, int page, Users users) {
        this.shoppingCart = shoppingCart;
        this.frame = frame;
        this.page = page;
        this.users = users;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(null, "是否删除！", "删除提示框！", JOptionPane.OK_CANCEL_OPTION);
        if(i==JOptionPane.YES_OPTION){
            new ShoppingCartImp().delete(shoppingCart);
            frame.dispose();
            List<ShoppingCart> list = new Query(users).queryCartlist();
            new ShoppingcartGUI(0,list,users);
        }

    }
}
