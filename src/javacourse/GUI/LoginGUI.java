package javacourse.GUI;

import javacourse.dbserver.RecivePicture;
import javacourse.init.MusicThead;
import javacourse.listener.LoginListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginGUI extends JFrame{
    public  MusicThead musicThead=null;
    public JFrame frame;
    public JTextField username;
    public JTextField password;
    public LoginGUI() {
        init();
    }

    //登录界面初始化
    public void init() {
        frame = new JFrame("登录");
        frame.setLayout(null);
        frame.setBounds(550, 150, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("src/image/LoginIcon/购物袋.jpeg").getImage());
        //音乐
        JButton button = new JButton();
        button.setContentAreaFilled(true);
        button.setBounds(10, 10, 50, 51);
        button.setToolTipText("播放");
        button.setIcon(new ImageIcon("src/image/OtherIcon/播放.png"));
        button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jButton = (JButton) e.getSource();
                    if (jButton.getToolTipText().equals("播放")) {
                        musicThead = new MusicThead();
                        jButton.setToolTipText("暂停");
                        jButton.setIcon(new ImageIcon("src/image/OtherIcon/暂停.png"));
                        musicThead.start();
                    } else {
                        jButton.setToolTipText("播放");
                        jButton.setIcon(new ImageIcon("src/image/OtherIcon/播放.png"));
                        musicThead.setIsplay(false);
                        musicThead = null;
                    }
                }
            });
        //背景板
        BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
        backgroundJPanel.setLayout(null);
        backgroundJPanel.setSize(800,600);
        frame.setContentPane(backgroundJPanel);
        backgroundJPanel.add(button);
        JLabel label = new JLabel("哈哈商城");
        label.setBounds(170,30,500,150);
        label.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,100));
        backgroundJPanel.add(label);
        //账户
        JLabel nameStr = new JLabel(new ImageIcon("src/image/LoginIcon/account.jpeg"));
        nameStr.setBounds(250, 200, 50, 25);
        backgroundJPanel.add(nameStr);
        //密码
        JLabel passwordStr = new JLabel(new ImageIcon("src/image/LoginIcon/passwd.jpeg"));
        passwordStr.setBounds(250, 250, 50, 25);
        backgroundJPanel.add(passwordStr);

        username = new JTextField();
        username.setBounds(300, 200, 150, 25);
        backgroundJPanel.add(username);
        username.setOpaque(false);
        password = new JTextField();
        password.setBounds(300, 250, 150, 25);
        password.setOpaque(false);
        backgroundJPanel.add(password);

        ImageIcon icon = new ImageIcon("src/image/LoginIcon/登录.jpeg");
        JButton buttonLogin = new JButton();
        buttonLogin.setIcon(icon);
        buttonLogin.setToolTipText("登录");
        buttonLogin.setText("登录");
        buttonLogin.setVerticalTextPosition(JButton.BOTTOM);
        buttonLogin.setHorizontalTextPosition(JButton.CENTER);
        buttonLogin.setContentAreaFilled(false);
        buttonLogin.setBounds(300, 300, 60, 50);
        backgroundJPanel.add(buttonLogin);

        JButton buttonRegister = new JButton();
        buttonRegister.setBounds(390, 300, 60, 50);
        buttonRegister.setIcon(new ImageIcon("src/image/LoginIcon/注册.jpeg"));
        buttonRegister.setToolTipText("注册");
        buttonRegister.setText("注册");
        buttonRegister.setVerticalTextPosition(JButton.BOTTOM);
        buttonRegister.setHorizontalTextPosition(JButton.CENTER);
        buttonRegister.setContentAreaFilled(false);
        backgroundJPanel.add(buttonRegister);
        frame.setVisible(true);

        //为登录按钮添加监听器
        buttonLogin.addActionListener(new LoginListener(this));

        //为注册按钮添加监听器
        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //注册页面
                RegisterGUI ar = new RegisterGUI();
            }
        });
    }

    public static void main(String []args) {
        //主程序
        //登录窗口
        System.out.println("haha")
       new Thread(new Runnable() {
           @Override
           public void run() {
               RecivePicture.recivepicture();
               }
       }).start();
        new LoginGUI();

    }
}


