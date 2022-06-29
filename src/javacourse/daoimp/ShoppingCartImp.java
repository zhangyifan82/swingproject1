package javacourse.daoimp;

import javacourse.dbdao.ShoppingCartDao;
import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartImp implements ShoppingCartDao {
    @Override
    public void add(ShoppingCart shoppingCart) {
        try {
            String sql1="select * from ShoppingCart where username=? and name=?";
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1,shoppingCart.getUsername());
            ps1.setString(2,shoppingCart.getName());
            ResultSet set = ps1.executeQuery();
            if(set.next()){
                update(shoppingCart);
                return;
            }
            String sql="INSERT INTO ShoppingCart(username,number,NAME) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, shoppingCart.getUsername());
            ps.setInt(2, shoppingCart.getNumber());
            ps.setString(3,shoppingCart.getName());
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "加入购物车失败!");
        }

    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        String sql = "DELETE FROM ShoppingCart WHERE username=? AND `name`=?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, shoppingCart.getUsername());
            ps.setString(2,shoppingCart.getName());
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "删除成功！");
        }
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        String sql="UPDATE ShoppingCart SET number=? WHERE username=? AND name=?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, shoppingCart.getNumber());
            ps.setInt(2, shoppingCart.getUsername());
            ps.setString(3,shoppingCart.getName());
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "更改数量失败!");
        }
    }

    @Override
    public ResultSet query(Users users) {
        String sql="select s.id,s.username,s.number,s.name,g.path,g.information,g.price from ShoppingCart s INNER JOIN Goods g ON s.name=g.name where username=?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, users.getUsername());
            ResultSet  rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
