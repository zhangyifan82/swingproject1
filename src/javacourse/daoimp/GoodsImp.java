package javacourse.daoimp;

import javacourse.dbdao.GoodsDao;
import javacourse.entity.Goods;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsImp implements GoodsDao {

    @Override
    public ResultSet query(String kind) {
        String sql="select * from Goods where kind=? OR name=?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kind);
            ps.setString(2,kind);
            ResultSet  rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Goods goods) {
        String sql="INSERT into Goods(name,kind,path,price,information) values (?,?,?,?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, goods.getName());
            ps.setString(2, goods.getKind());
            ps.setString(3,goods.getPath());
            ps.setDouble(4,goods.getPrice());
            ps.setString(5,goods.getInformation());
            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "增加商品失败!");
        }
    }
}
