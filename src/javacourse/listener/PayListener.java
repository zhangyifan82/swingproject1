package javacourse.listener;

import javacourse.constant.UserVip;
import javacourse.constant.VIP;
import javacourse.dbserver.Query;
import javacourse.entity.Goods;
import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PayListener implements ActionListener {
public Users users;
public List<ShoppingCart> shoppingCartList;
public List<JCheckBox> checkBoxes;
public int page;
public JFrame frame;
public  JTextField jTextField;
public Goods goods;
    public PayListener(Users users, List<ShoppingCart> shoppingCartList, List<JCheckBox> checkBoxes,int page,JFrame frame) {
        this.users = users;
        this.shoppingCartList = shoppingCartList;
        this.checkBoxes = checkBoxes;
        this.page = page;
        this.frame = frame;
    }

    public PayListener(Users users, JTextField jTextField, Goods goods) {
        this.users = users;
        this.jTextField = jTextField;
        this.goods = goods;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(null, "是否购买！", "购买提示框！", JOptionPane.OK_CANCEL_OPTION);
        if(shoppingCartList!=null){
           //得到被选中的商品
           List<ShoppingCart> cartList1 = new ArrayList<>() ;
           for(int j = 0;j<((shoppingCartList.size()-page*4)<=4?(shoppingCartList.size()-page*4):4);j++){
               if(checkBoxes.get(j).isSelected()){
                   cartList1.add(shoppingCartList.get(j+page*4));
//                   System.out.println("you");
               }
           }
           double money = 0;
           for(ShoppingCart shoppingCart:cartList1){
               money+=shoppingCart.getPrice()*shoppingCart.getNumber();
           }
            JOptionPane.showMessageDialog(null, "总计："+(int)(money* VIP.map.get(UserVip.vip))+"元");
           if(i==JOptionPane. YES_OPTION){
               for(ShoppingCart shoppingCartList1:cartList1){
                  new Query(users).addBuys(shoppingCartList1);
                  new Query(users).deleteRequst(shoppingCartList1);
                   frame.dispose();
                   JOptionPane.showMessageDialog(null, "购买成功!");
               }
           }
       }else {
            if(i==JOptionPane. YES_OPTION){
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setUsername(users.getUsername());
                shoppingCart.setNumber(Integer.parseInt(jTextField.getText()));
                shoppingCart.setPrice(goods.getPrice());
                shoppingCart.setName(goods.getName());
                new Query(users).addBuys(shoppingCart);
                JOptionPane.showMessageDialog(null, "购买成功!");
            }
       }

    }
}
