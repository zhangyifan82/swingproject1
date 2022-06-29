package javacourse.daoimp;

import javacourse.dbdao.BuysDao;
import javacourse.entity.Buys;
import javacourse.entity.Users;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuysImp implements BuysDao {

    @Override
    public ResultSet query(Users users) {
        String sql="select b.username,b.number,b.price,b.name,g.path from Buys b INNER JOIN Goods g ON b.name=g.name where username=? ";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,users.getUsername());
            ResultSet  rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet query1() {
        String sql="SELECT SUM( b.number),b.name,g.path FROM Buys b INNER JOIN Goods g ON b.name=g.name GROUP BY b.name  ORDER BY SUM(b.number) DESC LIMIT 0,3 ";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet  rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Buys buys) {
        String sql="INSERT into Buys(username,number,price,name) values (?,?,?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, buys.getUsername());
            ps.setInt(2,buys.getNumber());
            ps.setDouble(3,buys.getPrice());
            ps.setString(4,buys.getName());
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "购买失败!");
        }
    }
}
