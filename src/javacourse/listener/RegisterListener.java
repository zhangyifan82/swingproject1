package javacourse.listener;

import javacourse.GUI.RegisterGUI;
import javacourse.service.Register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterListener implements ActionListener {
    RegisterGUI registerGUI ;

    public RegisterListener(RegisterGUI registerGUI) {
        this.registerGUI = registerGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int username1 = Integer.parseInt(registerGUI.username.getText());
        String passwd = new String (registerGUI.password.getPassword());
        String confrimpasswd = new String (registerGUI.confrimPassword.getPassword());

        //创建Register类
        Register register = new Register();
        register.setUsername(username1);
        register.setPassword(passwd);
        register.setconfirmpasswd(confrimpasswd);

        //如果注册成功，返回登录界面
        try {
            if(register.JudgeRegister()) {
                registerGUI.frame.setVisible(false);
//                new LoginGUI();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
