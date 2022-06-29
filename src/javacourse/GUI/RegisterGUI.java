package javacourse.GUI;

import javacourse.listener.RegisterListener;

import javax.swing.*;
import java.awt.*;

//注册界面
public class RegisterGUI extends JFrame{
    public  JTextField username;
    public  JPasswordField password;
    public  JPasswordField confrimPassword;
    public   JFrame frame;
    public RegisterGUI() {
        init();
    }
    public void init() {
        frame = new JFrame("注册账号");
        frame.setLayout(null);
        frame.setBounds(550, 150, 800, 600);
        //背景
        BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
        backgroundJPanel.setLayout(null);
        backgroundJPanel.setSize(800,600);
        frame.setContentPane(backgroundJPanel);
        //账户
        JLabel nameStr = new JLabel(new ImageIcon("src/image/LoginIcon/account.jpeg"));
        nameStr.setBounds(250, 200, 50, 25);
        backgroundJPanel.add(nameStr);
        //密码
        JLabel passwordStr = new JLabel(new ImageIcon("src/image/LoginIcon/passwd.jpeg"));
        passwordStr.setBounds(250, 250, 50, 25);
        backgroundJPanel.add(passwordStr);
        JLabel confrimStr = new JLabel(new ImageIcon("src/image/LoginIcon/passwd.jpeg"));
        confrimStr.setBounds(250, 300, 50, 25);
        backgroundJPanel.add(confrimStr);
        JLabel label = new JLabel("  欢迎新用户注册！");
        label.setBounds(0,0,800,200);
        label.setFont(new Font("微软雅黑", Font.BOLD,90));
       backgroundJPanel.add(label);
        username = new JTextField();
        username.setBounds(320, 200, 150, 25);
        backgroundJPanel.add(username);

        password = new JPasswordField();
        password.setBounds(320, 250, 150, 25);
        backgroundJPanel.add(password);

        confrimPassword = new JPasswordField();
        confrimPassword.setBounds(320, 300, 150, 25);
        backgroundJPanel.add(confrimPassword);

        JButton buttonregister = new JButton("注册");
        buttonregister.setOpaque(false);
        buttonregister.setBounds(350, 350, 70, 25);
        backgroundJPanel.add(buttonregister);

        buttonregister.addActionListener(new RegisterListener(this));


        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

//    public static void main(String[] args) {
//        new RegisterGUI();
//    }
}



