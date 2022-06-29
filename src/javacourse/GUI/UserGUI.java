package javacourse.GUI;

import javacourse.dbserver.Query;
import javacourse.entity.Users;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JFrame {
    public Users users;

    public UserGUI(Users users) throws HeadlessException {
        this.users = users;
    }
    public void init(){
        JFrame frame = new JFrame("用户管理");
        frame.setLayout(null);
        frame.setBounds(400, 100, 1000,800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setIconImage(new ImageIcon("src/image/LoginIcon/购物袋.jpeg").getImage());
        //背景板
        BackgroundJPanel backgroundJPanel = new BackgroundJPanel(new ImageIcon("src/image/OtherIcon/卡通风格背景.jpeg").getImage());
        backgroundJPanel.setLayout(null);
        backgroundJPanel.setSize(1000,800);
        frame.setContentPane(backgroundJPanel);
        JLabel label4 = new JLabel ();
        label4.setBounds(450,200,100,100);
        label4.setIcon(new ImageIcon("src/image/LoginIcon/头像.png"));
        backgroundJPanel.add(label4);
        //账户密码
        JLabel nameStr = new JLabel("旧密码");
        nameStr.setOpaque(false);
        nameStr.setBounds(300, 350, 100, 25);
        nameStr.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        backgroundJPanel.add(nameStr);
        //密码
        JLabel passwordStr = new JLabel("新密码");
        passwordStr.setBounds(300, 400, 100, 25);
        passwordStr.setOpaque(false);
        passwordStr.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        backgroundJPanel.add(passwordStr);
        JLabel confrimStr = new JLabel("确认密码");
        confrimStr.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,20));
        confrimStr.setOpaque(false);
        confrimStr.setBounds(300, 450, 100, 25);
        backgroundJPanel.add(confrimStr);
        JLabel label = new JLabel("  用户密码修改！");
        label.setOpaque(false);
        label.setBounds(150,0,850,200);
        label.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,80));
        backgroundJPanel.add(label);
        //文本框
        JLabel label1 = new JLabel();
        label1.setBounds(580, 350, 25, 25);
        label1.setOpaque(false);
        backgroundJPanel.add(label1);
        JTextField userpasswd = new JTextField();
        userpasswd.setBounds(420, 350, 150, 25);
        userpasswd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String trim = userpasswd.getText().trim();
                if (confirm(users,trim)){
                    label1.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label1.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String trim = userpasswd.getText().trim();
                if (confirm(users,trim)){
                    label1.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label1.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String trim = userpasswd.getText().trim();
                if (confirm(users,trim)){
                    label1.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label1.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }
            private boolean confirm(Users users,String s){
                if(users.getUserpasswd().equals(s)){
                    return true;
                }
                return false;
            }
        });
        backgroundJPanel.add(userpasswd);

        JLabel label2 = new JLabel();
        label2.setBounds(580, 400, 25, 25);
        label2.setOpaque(false);
        backgroundJPanel.add(label2);
        JPasswordField password = new JPasswordField();
        password.setBounds(420, 400, 150, 25);
        password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = password.getText().trim();
                if(!text.equals("")){
                    label2.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label2.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = password.getText().trim();
                if(!text.equals("")){
                    label2.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label2.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String text = password.getText().trim();
                if(!text.equals("")){
                    label2.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label2.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }
        });
        backgroundJPanel.add(password);

        JLabel label3 = new JLabel();
        label3.setBounds(580, 450, 25, 25);
        label3.setOpaque(false);
        backgroundJPanel.add(label3);
        JPasswordField confrimPassword = new JPasswordField();
        confrimPassword.setBounds(420, 450, 150, 30);
        confrimPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = password.getText().trim();
                String trim = confrimPassword.getText().trim();
                if(text.equals(trim)){
                    label3.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label3.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = password.getText().trim();
                String trim = confrimPassword.getText().trim();
                if(text.equals(trim)){
                    label3.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label3.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String text = password.getText().trim();
                String trim = confrimPassword.getText().trim();
                if(text.equals(trim)){
                    label3.setIcon(new ImageIcon("src/image/OtherIcon/对.jpeg"));
                    return;
                }
                label3.setIcon(new ImageIcon("src/image/OtherIcon/错.jpeg"));
            }
        });
        backgroundJPanel.add(confrimPassword);

        JButton buttonregister = new JButton("修改");
        buttonregister.setBounds(430, 550, 100, 40);
        buttonregister.setFont(new Font("仿宋",Font.BOLD|Font.ITALIC,30));
        backgroundJPanel.add(buttonregister);

        buttonregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Query(users).modifyUser(password.getText().trim());
                frame.dispose();
                new LoginGUI();
            }
        });
        frame.setVisible(true);
    }
}
