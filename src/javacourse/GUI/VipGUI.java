package javacourse.GUI;

import javacourse.constant.UserVip;
import javacourse.constant.VIP;
import javacourse.dbserver.Query;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VipGUI extends JFrame{
    public Users users;
    public JFrame frame1;

    public VipGUI(Users users, JFrame frame) throws HeadlessException {
        this.users = users;
        this.frame1 = frame;
    }

    public void init(){
        JFrame frame = new JFrame("vip");
        frame.setLayout(null);
        frame.setBounds(400, 100, 1000,800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setIconImage(new ImageIcon("src/image/LoginIcon/购物袋.jpeg").getImage());
        //背景板
        BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
        backgroundJPanel.setLayout(new GridLayout(8,1));
        backgroundJPanel.setSize(1000,800);
        frame.setContentPane(backgroundJPanel);
        //vip
       for(int i = 1;i<8;i++){
           JPanel panel = new JPanel();
           panel.setOpaque(false);
           panel.setLayout(null);
           BackgroundJPanel backgroundJPanel1 = new BackgroundJPanel(new ImageIcon(VIP.vip.get(i)).getImage());
           backgroundJPanel1.setBounds(20,5,125,100);
           JLabel label = new JLabel("价格：" + (100 * i));
           label.setBounds(200,10,200,50);
           label.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
           JLabel label1 = new JLabel("你将享受" + (int)(100 * VIP.map.get(i)) + "折");
           label1.setBounds(450,10,300,50);
           label1.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
           panel.add(backgroundJPanel1);
           panel.add(label);
           panel.add(label1);
           backgroundJPanel.add(panel);
       }
        JPanel panel = new JPanel();
       panel.setOpaque(false);
        panel.setLayout(null);
        JLabel label = new JLabel("购买VIP");
        label.setBounds(200,10,180,80);
        label.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        label.setOpaque(false);
        panel.add(label);
        backgroundJPanel.add(panel);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(UserVip.vip==7){
                   JOptionPane.showMessageDialog(null, "你vip等级已达到最高！");
                   return;
               }
               int i = JOptionPane.showConfirmDialog(null, "是否购买vip"+( UserVip.vip+1), "购买提示框！", JOptionPane.OK_CANCEL_OPTION);
               if(i==JOptionPane.YES_OPTION && UserVip.vip<7){
                   new Query(users).updateVIP(UserVip.vip+1);
                   //更新vip等级
                   UserVip.vip= UserVip.vip+1;
                   frame1.dispose();
                   frame.dispose();
                   new FirstGUI(users);
               }
            }
        });
        frame.setVisible(true);
    }
}
