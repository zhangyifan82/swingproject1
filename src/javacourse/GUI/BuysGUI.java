package javacourse.GUI;

import javacourse.entity.Buys;
import javacourse.entity.Users;
import javacourse.listener.BuysListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BuysGUI extends JFrame {
    public Users users;
    public int page;
    public List<Buys> buysList;

    public BuysGUI(Users users, int page, List<Buys> buysList) throws HeadlessException {
        this.users = users;
        this.page = page;
        this.buysList = buysList;
    }
    public void init(){
        JFrame frame = new JFrame("已购买");
        frame.setLayout(null);
        frame.setBounds(400, 100, 1000,800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setIconImage(new ImageIcon("src/image/LoginIcon/购物袋.jpeg").getImage());
        //背景板
        BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
        backgroundJPanel.setLayout(null);
        backgroundJPanel.setSize(1000,800);
        frame.setContentPane(backgroundJPanel);
        JLabel label = new JLabel("已购买");
        label.setBounds(10,5,200,50);
        label.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        label.setOpaque(false);
        backgroundJPanel.add(label);
        JPanel panel = new JPanel();
        panel.setBounds(0,80,1000,600);
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(4,1,1,1));
        backgroundJPanel.add(panel);
        for(int i = 0;i<((buysList.size()-page*4)<=4?(buysList.size()-page*4):4);i++){
            Buys buys = buysList.get(i+page*4);
            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setOpaque(false);
            JLabel label3 = new JLabel();
            label3.setIcon(new ImageIcon(buys.getPath()));
            label3.setBounds(20,0,200,140);
            JLabel label1 = new JLabel("商品名称："+buys.getName());
            label1.setBounds(250,0,200,50);
            label1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
            label1.setOpaque(false);
            JLabel label2 = new JLabel();
            label2.setBounds(250,60,150,50);
            label2.setText("¥"+buys.getPrice());
            label2.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,20));
            label2.setOpaque(false);
            JLabel label4 = new JLabel("购买数量："+buys.getNumber());
            label4.setBounds(500,50,200,50);
            label4.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
            label4.setOpaque(false);
            panel1.add(label1);
            panel1.add(label2);
            panel1.add(label3);
            panel1.add(label4);
            panel.add(panel1);
        }
        for(int i = 0;i<=(buysList.size()/4);i++){
            JButton button = new JButton("" + (i+1));
            button.setHorizontalTextPosition(JButton.LEFT);
            button.setBounds(10+60*i,680,50,50);
            button.addActionListener(new BuysListener(users,i,frame));
            button.setOpaque(false);
            button.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,10));
            backgroundJPanel.add(button);
        }
        frame.setVisible(true);
    }
}
