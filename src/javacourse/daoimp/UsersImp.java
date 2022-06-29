package javacourse.daoimp;

import javacourse.dbdao.UsersDao;
import javacourse.entity.Users;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersImp implements UsersDao{

    @Override
    public void add(Users user) {
        String sql="INSERT into users(username,userpasswd) values (?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUsername());
            ps.setString(2, user.getUserpasswd());
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "注册失败!");
        }

    }

    @Override
    public ResultSet query(Users user) {
        String sql="select * from users where username=? ";
        try {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, user.getUsername());
//        ps.setString(2, user.getUserpasswd());
        ResultSet  rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public ResultSet query1(Users user) {
        String sql="select * from users where username=? AND userpasswd=?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUsername());
        ps.setString(2, user.getUserpasswd());
            ResultSet  rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //修改用户密码
    @Override
    public void modify(Users users,String passwd){
        String sql="UPDATE users SET userpasswd=? WHERE username=? ";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, passwd);
            ps.setInt(2, users.getUsername());
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "更改数量失败!");
        }
    }
    @Override
    //更改vip
    public void modifyVip(Users users,int vip){
        String sql="UPDATE users SET vip=? WHERE username=? ";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vip);
            ps.setInt(2, users.getUsername());
            ps.executeUpdate();
            ps.close();
            conn.close();
        }catch(SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "更改vip失败!");
        }
    }


}
