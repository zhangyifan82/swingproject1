package javacourse.GUI;

import javacourse.entity.Goods;
import javacourse.entity.Users;
import javacourse.listener.PictureListener;
import javacourse.listener.ResearchListener;
import javacourse.listener.ShoppingCartAddListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResearchGUI extends JFrame {
    public Users users;
    public List<Goods> goodsList ;
    public int page;
    public ResearchGUI(List<Goods> goodsList,Users users) throws HeadlessException {
        this.goodsList = goodsList;
        this.users = users;
    }

    public ResearchGUI(List<Goods> goodsList, Users users,int page) throws HeadlessException {
        this.goodsList = goodsList;
        this.users = users;
        this.page = page;
    }

    public void init(){
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

        JButton button1 = new JButton("价格升序");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(goodsList, new Comparator<Goods>() {
                    @Override
                    public int compare(Goods o1, Goods o2) {
                        return (int)(o1.getPrice()-o2.getPrice());
                    }
                });
                frame.dispose();
                new ResearchGUI(goodsList,users,page).init();
            }
        });
        button1.setBounds(10,10,100,50);
        JButton button2 = new JButton("价格降序");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(goodsList, new Comparator<Goods>() {
                    @Override
                    public int compare(Goods o1, Goods o2) {
                        return (int)(o2.getPrice()-o1.getPrice());
                    }
                });
                frame.dispose();
                new ResearchGUI(goodsList,users,page).init();
            }
        });
        button2.setBounds(160,10,100,50);
        backgroundJPanel.add(button1);
        backgroundJPanel.add(button2);
        JPanel panel4 = new JPanel();
        panel4.setBounds(0,100,1000,600);
        panel4.setLayout(new GridLayout(2,3,0,1));
        panel4.setOpaque(false);
        for(int i = 0;i<((goodsList.size()-page*6)<6?(goodsList.size()-page*6):6);i++){
            JPanel panel2 = new JPanel();
            panel2.setLayout(null);
            Goods goods =goodsList.get(i+page*6);
            JButton button3 = new JButton();
            button3.setText(goods.getName());
            button3.setIcon(new ImageIcon(goods.getPath()));
            button3.setBounds(0,0,200,300);
            button3.addActionListener(new PictureListener(users));

            JTextArea textArea = new JTextArea();
            textArea.setText(goods.getName()+"\n"+"价格:"+"\n"+String.valueOf(goods.getPrice()));
            textArea.setBounds(200,0,100,100);
            textArea.setOpaque(false);
//            textArea.setEnabled(false);
            textArea.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
            JLabel label8 = new JLabel();
            label8.setOpaque(false);
            label8.setText("分类:");
            label8.setBounds(210,100,60,50);
            label8.setVerticalTextPosition(JLabel.BOTTOM);
            JLabel label9 = new JLabel();
            label9.setOpaque(false);
            label9.setText(goods.getKind());
            label9.setBounds(210,150,60,50);
            JButton add = new JButton();
            add.setIcon(new ImageIcon("src/image/OtherIcon/购物车.jpeg"));
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
        backgroundJPanel.add(panel4);
        for(int i = 0;i<=(goodsList.size()/6);i++){
            JButton button = new JButton("" + (i+1));
            button.setHorizontalTextPosition(JButton.LEFT);
            button.setBounds(10+60*i,705,50,40);
            button.addActionListener(new ResearchListener(users,i,goodsList.get(0).getKind(),frame));
            button.setOpaque(false);
            backgroundJPanel.add(button);
        }
        frame.setVisible(true);
    }
}
