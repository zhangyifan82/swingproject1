package javacourse.listener;

import javacourse.GUI.FirstGUI;
import javacourse.GUI.LoginGUI;
import javacourse.constant.UserVip;
import javacourse.dbserver.Query;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener{
   LoginGUI loginGUI;
public Users user;
    public LoginListener(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(loginGUI.username.getText().equals("")){return;}
        int ID = Integer.parseInt(loginGUI.username.getText());
        String passwd1 = new String (loginGUI.password.getText());

         user = new Users();
        user.setUsername(ID);
        user.setUserpasswd(passwd1);
        //登录
        String i = new Query(user).loginJudge(user);

        if(i.equals("0")) {
            //弹出账号或密码错误的窗口
            JOptionPane.showMessageDialog(null, "账号或密码错误", "账号或密码错误", JOptionPane.WARNING_MESSAGE);
            loginGUI.password.setText("");
            loginGUI.username.setText("");
        } else {
            //弹出登录成功的窗口
            JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.NO_OPTION);
            //点击确定后会跳转到主窗口
            loginGUI.frame.dispose();

            UserVip.vip= Integer.parseInt(new Query(user).vip(user));

//            System.out.println(vip);
            FirstGUI firstGUI = new FirstGUI(user);
            firstGUI.label2.setText("Hi!"+user.getUsername());

        }
    }
}
