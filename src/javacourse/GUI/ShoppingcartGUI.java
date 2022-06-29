package javacourse.GUI;

import javacourse.dbserver.Query;
import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;
import javacourse.listener.CartGUIListener;
import javacourse.listener.PayListener;
import javacourse.listener.ShoppingCartDeleteListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingcartGUI extends JFrame {
    public  int page;
    public List<ShoppingCart> cartList ;
    public Users users;
    public List<JCheckBox> checkBoxes;

    public ShoppingcartGUI(int page, List<ShoppingCart> cartList, Users users) throws HeadlessException {
        this.page = page;
        this.cartList = cartList;
        this.users = users;
    }

    public void init(){
    JFrame frame = new JFrame("购物车");
    frame.setLayout(null);
    frame.setBounds(400, 100, 1000,800);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.setIconImage(new ImageIcon("src/image/LoginIcon/购物袋.jpeg").getImage());
    //背景板
    BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
    backgroundJPanel.setLayout(null);
    backgroundJPanel.setSize(1000,800);
    frame.setContentPane(backgroundJPanel);
    checkBoxes = new ArrayList<>();
    JLabel lable = new JLabel();
    lable.setBounds(10,10,120,70);
    lable.setText("购物车:");
    lable.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,25));
    backgroundJPanel.add(lable);
    JCheckBox checkBox = new JCheckBox("全选");
    checkBox.setBounds(120,10,100,70);
    checkBox.setOpaque(false);
    checkBox.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            boolean selected = e.getStateChange()==ItemEvent.SELECTED?true:false;
            if (selected){
                for(JCheckBox checkBox1:checkBoxes){
                    checkBox1.setSelected(true);
                }
            }else{
                for(JCheckBox checkBox1:checkBoxes){
                    checkBox1.setSelected(false);
                }
            }
        }
    });
     backgroundJPanel.add(checkBox);

    JPanel panel = new JPanel();
    panel.setBounds(0,80,1000,600);
    panel.setOpaque(false);
    panel.setLayout(new GridLayout(4,1,1,1));
    backgroundJPanel.add(panel);
    for(int i = 0;i<((cartList.size()-page*4)<=4?(cartList.size()-page*4):4);i++){
        ShoppingCart shoppingCart = cartList.get(i+page*4);
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setOpaque(false);

        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setSelected(false);
        jCheckBox.setBounds(10,50,20,20);
        jCheckBox.setOpaque(false);
        checkBoxes.add(jCheckBox);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(shoppingCart.getPath()));
        label.setBounds(50,0,140,140);
        JLabel label1 = new JLabel("商品名称："+shoppingCart.getName());
        label1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        label1.setBounds(250,0,200,50);
        JLabel label2 = new JLabel();
        label2.setBounds(250,60,150,50);
        label2.setText("¥"+shoppingCart.getPrice());
        label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
        JTextField jTextField = new JTextField(String.valueOf(shoppingCart.getNumber()));
        jTextField.setBounds(590,50,100,50);
        jTextField.setFont( new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        JButton button = new JButton("增加");
        button.setBounds(500,50,80,50);
        button.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   shoppingCart.setNumber(shoppingCart.getNumber()+1);
                    jTextField.setText(""+shoppingCart.getNumber());
//                    new ShoppingCartImp().update(shoppingCart);
                new Query(users).updateShopping(shoppingCart);
            }
        });
        JButton button1 = new JButton("减少");
        button1.setBounds(700,50,80,50);
        button1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shoppingCart.getNumber()<=1){
                    return;
                }else {
                    shoppingCart.setNumber(shoppingCart.getNumber()-1);
                    jTextField.setText(""+shoppingCart.getNumber());
                    new Query(users).updateShopping(shoppingCart);
                }
            }
        });
        JButton button2 = new JButton("删除");
        button2.setBounds(800,50,100,50);
        button2.addActionListener(new ShoppingCartDeleteListener(shoppingCart,frame,page,users));
        button2.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        panel1.add(jCheckBox);
        panel1.add(label);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(button);
        panel1.add(button1);
        panel1.add(jTextField);
        panel1.add(button2);
        panel.add(panel1);
    }
        JButton button3 = new JButton("结算");
        button3.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));

        button3.addActionListener(new PayListener(users,cartList,checkBoxes,page,frame));
        button3.setBounds(890,10,100,70);
        backgroundJPanel.add(button3);
        for(int i = 0;i<=(cartList.size()/4);i++){
            JButton button = new JButton("" + (i+1));
            button.setHorizontalTextPosition(JButton.LEFT);
            button.setBounds(10+60*i,680,50,50);
            button.setOpaque(false);
            button.addActionListener(new CartGUIListener(users,i,frame));
            button.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,10));
            backgroundJPanel.add(button);
        }
    frame.setVisible(true);
}

}
