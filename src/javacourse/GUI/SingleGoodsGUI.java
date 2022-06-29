package javacourse.GUI;

import javacourse.entity.Goods;
import javacourse.entity.Users;
import javacourse.listener.PayListener;
import javacourse.listener.ShoppingCartAddListener;
import javacourse.listener.SingleListener;

import javax.swing.*;
import java.awt.*;

public class SingleGoodsGUI extends JFrame {
    public Goods goods;
//    public int number ;
    public Users users;

    public SingleGoodsGUI(Goods goods, Users users) throws HeadlessException {
        this.goods = goods;
        this.users = users;
    }

    public void init(){
        System.out.println("单个商品");
        JFrame frame = new JFrame("商品");
        frame.setLayout(null);
        frame.setBounds(400, 100, 1000,800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setIconImage(new ImageIcon("src/image/LoginIcon/购物袋.jpeg").getImage());
        //背景板
        BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
        backgroundJPanel.setLayout(null);
        backgroundJPanel.setSize(1000,800);
        frame.setContentPane(backgroundJPanel);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(goods.getPath()));
        label.setBounds(20,50,400,600);
        JLabel label1 = new JLabel(goods.getInformation());
        label1.setBounds(10,50,980,50);
        label1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        label1.setOpaque(false);
        JLabel label2 = new JLabel("¥"+String.valueOf(goods.getPrice()));
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,50));
        label2.setBounds(450,150,500,100);
        label2.setOpaque(false);
        JLabel label3 = new JLabel("名称:"+goods.getName());
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        label3.setBounds(450,300,500,80);
        label3.setOpaque(false);

        JTextField jTextField = new JTextField(""+1);
        jTextField.setBounds(590,500,100,50);

        JButton button = new JButton("增加");
        button.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        button.setBounds(450,500,130,50);
        button.setOpaque(false);
        SingleListener singleListener = new SingleListener(jTextField);
        button.addActionListener(singleListener);
        JButton button1 = new JButton("减少");
        button1.setOpaque(false);
        button1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        button1.setBounds(700,500,130,50);
        button1.setOpaque(false);
        button1.addActionListener(singleListener);
        JButton button2 = new JButton("加入购物车");
        button2.setOpaque(false);
        button2.setBounds(480,600,150,50);
        button2.addActionListener(new ShoppingCartAddListener(users,goods.getName(),jTextField));
        button2.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
//        System.out.println(singleListener.getNumber());
        button2.setOpaque(false);
        JButton button3 = new JButton("立即购买");
        button3.setOpaque(false);
        button3.setBounds(640,600,150,50);
        button3.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        button3.setOpaque(false);
        button3.addActionListener(new PayListener(users,jTextField,goods));
        backgroundJPanel.add(label);
        backgroundJPanel.add(label1);
        backgroundJPanel.add(label2);
        backgroundJPanel.add(label3);
        backgroundJPanel.add(button);
        backgroundJPanel.add(jTextField);
        backgroundJPanel.add(button1);
        backgroundJPanel.add(button2);
        backgroundJPanel.add(button3);
        frame.setVisible(true);
    }
}
