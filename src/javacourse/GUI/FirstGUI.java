package javacourse.GUI;

import javacourse.constant.UserVip;
import javacourse.constant.VIP;
import javacourse.daoimp.BuysImp;
import javacourse.dbserver.Query;
import javacourse.entity.Goods;
import javacourse.entity.HotGoods;
import javacourse.entity.Users;
import javacourse.listener.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//商城首页
public class FirstGUI extends JFrame {
   public JLabel label2 ;
   public  JTextField jTextField;
   public Users users;
    public FirstGUI(Users users){
      this.users = users;
        this.init();
    }
    public void init(){
        JFrame frame = new JFrame("首页");
        frame.setLayout(null);
        frame.setBounds(400, 100, 1000,800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setIconImage(new ImageIcon("src/image/LoginIcon/购物袋.jpeg").getImage());
        //背景板
        BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
        backgroundJPanel.setLayout(null);
        backgroundJPanel.setSize(1000,800);
        frame.setContentPane(backgroundJPanel);
        //标签
        JLabel label = new JLabel("商城");
        label.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,80));
        label.setBounds(50,10,200,100);
        backgroundJPanel.add(label);
        JLabel label1 = new JLabel("haha");
        label1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,50));
        label1.setBounds(70,100,200,50);
        backgroundJPanel.add(label1);
        //vip图标
        BackgroundJPanel backgroundJPanel1 = new BackgroundJPanel(new ImageIcon(VIP.vip.get(UserVip.vip)).getImage());
        backgroundJPanel1.setBounds(725,10,150,120);
        backgroundJPanel.add(backgroundJPanel1);
        backgroundJPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new VipGUI(users,frame).init();
            }
        });
        //显示用户名
        label2 = new JLabel();
        label2.setBounds(750,260,200,30);
        label2.setFont(new Font("仿宋",Font.ITALIC,20));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundJPanel.add(label2);
        JButton label3 = new JButton ();
        label3.setBounds(800,150,100,100);
        label3.setIcon(new ImageIcon("src/image/LoginIcon/头像.png"));
        label3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserGUI(users).init();
            }
        });
        backgroundJPanel.add(label3);
        //文本框
        jTextField = new ComboText();
        jTextField.setBounds(300,50,400,50);
        backgroundJPanel.add(jTextField);
        //按钮
        JButton button = new JButton();
        button.setBounds(450,101,100,50);
        button.setIcon(new ImageIcon("src/image/LoginIcon/搜索.png"));
        button.setToolTipText("搜索");
        button.addActionListener(new ResearchListener(jTextField,users));
        backgroundJPanel.add(button);
        JButton button5 = new JButton();
        button5.setBounds(900,10,50,50);
        button5.setIcon(new ImageIcon("src/image/OtherIcon/注销 .png"));
        button5.setToolTipText("注销");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginGUI();
            }
        });
        backgroundJPanel.add(button5);
        JButton button1 = new JButton();
        button1.setBounds(775,300,75,70);
        button1.setIcon(new ImageIcon("src/image/LoginIcon/购物车.jpeg"));
        button1.setToolTipText("购物车");
        button1.setText("购物车");
        button1.setContentAreaFilled(false);
        button1.setVerticalTextPosition(JButton.BOTTOM);
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.addActionListener(new CartGUIListener(users,0,frame));
        backgroundJPanel.add(button1);
        JButton button2 = new JButton();
        button2.setBounds(870,300,75,70);
        button2.setIcon(new ImageIcon("src/image/LoginIcon/已购买.png"));
        button2.setText("已购买");
        button2.setContentAreaFilled(false);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setToolTipText("已购买");
        button2.addActionListener(new BuysListener(users,0,frame));
        backgroundJPanel.add(button2);
        //分类面板
        JPanel panel = new JPanel();
        panel.setBounds(0,180,200,550);
        panel.setOpaque(false);
        panel.setLayout(null);
        JLabel label4 = new JLabel("分类:");
        label4.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        label4.setBounds(0,0,100,50);
        panel.add(label4);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(5,1,10,10));
        panel3.setOpaque(false);
        panel3.setBounds(0,100,200,400);
        JButton jButton1 = new JButton("服装");
        jButton1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new ResearchListener(users,"服装"));
        JButton jButton2= new JButton("零食");
        jButton2.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new ResearchListener(users,"零食"));
        JButton jButton3 = new JButton("电器");
        jButton3.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new ResearchListener(users,"电器"));
        JButton jButton4 = new JButton("食材");
        jButton4.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new ResearchListener(users,"食材"));
        JButton jButton5 = new JButton("水果");
        jButton5.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new ResearchListener(users,"水果"));
        panel3.add(jButton1);
        panel3.add(jButton2);
        panel3.add(jButton3);
        panel3.add(jButton4);
        panel3.add(jButton5);
        panel.add(panel3);
        backgroundJPanel.add(panel);
        //推荐商品板
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(210,180,550,550);
        panel1.setOpaque(false);
        JLabel label5 = new JLabel();
        label5.setIcon(new ImageIcon("src/image/OtherIcon/推荐.png"));
        label5.setBounds(0,10,100,30);
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2,2,1,1));
        panel4.setBounds(0,40,549,510);
        panel4.setOpaque(false);
        for (int i = 0;i<4;i++){
            JPanel panel2 = new JPanel();
            panel2.setLayout(null);
            JButton button3 = new JButton();
            button3.setLayout(null);
            Goods goods = new Query(users).queryAllGoods().get(i+(int)(Math.random()*10));
            button3.setIcon(new ImageIcon(goods.getPath()));
            button3.setBounds(0,0,210,240);
            button3.setText(goods.getName());
            button3.addActionListener(new PictureListener(users));
           JTextArea textArea = new JTextArea();
            textArea.setText(goods.getName()+"\n"+"价格:"+"\n"+String.valueOf(goods.getPrice()));
            textArea.setBounds(210,0,60,100);
            textArea.setOpaque(false);
//            textArea.setEnabled(false);
            textArea.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,10));
            JLabel label8 = new JLabel();
            label8.setOpaque(false);
            label8.setText("分类:");
            label8.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
            label8.setBounds(210,100,60,50);
            label8.setVerticalTextPosition(JLabel.BOTTOM);
            JLabel label9 = new JLabel();
            label9.setOpaque(false);
            label9.setText(goods.getKind());
            label9.setBounds(210,150,60,50);
            JButton add = new JButton();
            add.setIcon(new ImageIcon("src/image/OtherIcon/购物车.jpeg"));
            add.setText(goods.getName());
            add.setBounds(220,200,50,50);
            add.addActionListener(new ShoppingCartAddListener(users));
            panel2.add(button3);
            panel2.add(textArea);
            panel2.add(label8);
            panel2.add(label9);
            panel2.add(add);
            panel2.setOpaque(false);
            panel4.add(panel2);
        }
        panel1.add(panel4);
        panel1.add(label5);
        backgroundJPanel.add(panel1);
        //热榜排行前三
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(750,350,250,430);
        JLabel label6 = new JLabel();
        label6.setIcon(new ImageIcon("src/image/OtherIcon/Hot.png"));
        label6.setBounds(0,20,50,40);
        panel2.add(label6);
        panel2.setOpaque(false);
        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(3,1));
        panel5.setBounds(0,60,250,320);
        ResultSet set = new BuysImp().query1();
       List <HotGoods> hotGoodsList = new ArrayList<>();
        try {
            while (set.next()){
                HotGoods hotGoods = new HotGoods();
                hotGoods.setNumber(set.getInt(1));
                hotGoods.setName(set.getString(2));
                hotGoods.setPath(set.getString(3));
                hotGoodsList.add(hotGoods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for(HotGoods hotGoods:hotGoodsList){
            JPanel init = new RecommendPanel(hotGoods,users).init();
            init.setOpaque(false);
            panel5.add(init);
        }
        panel5.setOpaque(false);
        panel2.add(panel5);
        backgroundJPanel.add(panel2);
        frame.setVisible(true);
    }

//    public static void main(String[] args) {
//        new FirstGUI();
//    }
}
