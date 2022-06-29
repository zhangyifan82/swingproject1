package javacourse.service;

import javacourse.dbserver.Query;
import javacourse.entity.Users;

import javax.swing.*;
import java.sql.SQLException;

public class Register {
    Integer username;
    String password;
    String confirmpassword;
    public void setUsername(int username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   public void setconfirmpasswd(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    //判断注册的账号是否符合规则
   public boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        if(this.username.equals("")) {
            JOptionPane.showMessageDialog(null, "账号不能为空！", "账号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "密码不能为空！", "密码为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(!this.password.equals(this.confirmpassword)) {
            JOptionPane.showMessageDialog(null, "两次输入的密码不一致!", "密码不一致", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //符合规则，弹出注册成功的窗口，并将账号添加数据库
       Users users = new Users();
       users.setUsername(this.username);
       users.setUserpasswd(this.password);
       String register = new Query(users).register(users);
       if(register.equals("1")){
           return false;
       }
      new Query(users).addUser(users);
       JOptionPane.showMessageDialog(null, "注册成功!");
       return true;
    }

}


