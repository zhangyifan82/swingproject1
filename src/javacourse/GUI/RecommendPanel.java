package javacourse.GUI;

import javacourse.entity.HotGoods;
import javacourse.entity.Users;
import javacourse.listener.PictureListener;

import javax.swing.*;
import java.awt.*;


public class RecommendPanel extends Panel {
    public JButton button;//图片
    public JLabel label1;//名称
    public JLabel label2;//销量
    public HotGoods hotGoods;
    public Users users;
    public RecommendPanel(HotGoods hotGoods, Users users) {
        this.hotGoods = hotGoods;
        this.users = users;
    }
    public JPanel init(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(250,90);
        button = new JButton();
        button.setIcon(new ImageIcon(hotGoods.getPath()));
        button.setText(hotGoods.getName());
        button.setBounds(0,0,100,100);
        button.addActionListener(new PictureListener(users));
        label1 = new JLabel("名称："+hotGoods.getName());
        label1.setBounds(130,0,100,45);
        label1.setOpaque(false);
        label2 = new JLabel("销量："+hotGoods.getNumber());
        label2.setBounds(130,50,100,45);
        label2.setOpaque(false);
        panel.add(button);
        panel.add(label1);
        panel.add(label2);
        return panel;
    }
}
