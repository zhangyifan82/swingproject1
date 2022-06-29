package javacourse.listener;

import javacourse.dbserver.Query;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartAddListener implements ActionListener {
    public Users users;
    public String name;//商品名
    public  JTextField jTextField;
    public ShoppingCartAddListener(Users users) {
        this.users = users;
    }

    public ShoppingCartAddListener(Users users, String name, JTextField jTextField) {
        this.users = users;
        this.name = name;
        this.jTextField = jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name;
        if(this.name==null){
            name = e.getActionCommand();
            System.out.println(name);
        }else{
            name = this.name;
        }
        if (jTextField!=null){
            String number = jTextField.getText();
            String is="true";
            new Query(users).addshopping(String.valueOf(users.getUsername()),name,is,number);
        }else {
            String number ="1";
            String is =" ";
            new Query(users).addshopping(String.valueOf(users.getUsername()),name,is,number);
        }
//        try {
//            ResultSet query1 = new GoodsImp().query(name);
//            if(jTextField!=null){
//                if(query1.next()){
//                    ShoppingCart shoppingCart = new ShoppingCart();
//                    shoppingCart.setUsername(users.getUsername());
//                    int number = Integer.parseInt(jTextField.getText());
//                    System.out.println(jTextField.getText());
//                    shoppingCart.setNumber(number==0?1:number);
//                    shoppingCart.setName(query1.getString(2));
//                    new ShoppingCartImp().add(shoppingCart);
//                }
//                JOptionPane.showMessageDialog(null, "加入购物车成功!");
//            }else {
//                if(query1.next()){
//                    ShoppingCart shoppingCart = new ShoppingCart();
//                    shoppingCart.setUsername(users.getUsername());
//                    shoppingCart.setNumber(1);
//                    shoppingCart.setName(query1.getString(2));
//                    new ShoppingCartImp().add(shoppingCart);
//                }
//                JOptionPane.showMessageDialog(null, "加入购物车成功!");
//            }
//
//        }catch (SQLException eq){
//            eq.printStackTrace();
//        }
    }
}
