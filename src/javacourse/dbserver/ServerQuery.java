package javacourse.dbserver;

import javacourse.daoimp.BuysImp;
import javacourse.daoimp.GoodsImp;
import javacourse.daoimp.ShoppingCartImp;
import javacourse.daoimp.UsersImp;
import javacourse.entity.Buys;
import javacourse.entity.Goods;
import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerQuery {
    public String info ;
    public ServerQuery(String info) {
        this.info = info;
    }
    //已购买商品
    public List<Buys> queryBuys(){
        List<Buys> buysList = new ArrayList<>();
        Users users = new Users();
        users.setUsername(Integer.parseInt(info));
        try {
            ResultSet query1 = new BuysImp().query(users);
            while (query1.next()) {
                Buys buys = new Buys();
                buys.setUsername(query1.getInt(1));
                buys.setNumber(query1.getInt(2));
                buys.setPrice(query1.getDouble(3));
                buys.setName(query1.getString(4));
                buys.setPath(query1.getString(5));
                buysList.add(buys);
            }
        }catch (SQLException e){
            System.out.println("查询已购买失败！");
        }
        return buysList;
    }
    public List<ShoppingCart> shoppingCartList(){
        Users users = new Users();
        users.setUsername(Integer.parseInt(info));
        List<ShoppingCart> list = new ArrayList<>();
        try {
            ResultSet query = new ShoppingCartImp().query(users);
            while(query.next()){
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setId(query.getInt(1));
                shoppingCart.setUsername(query.getInt(2));
                shoppingCart.setNumber(query.getInt(3));
                shoppingCart.setName(query.getString(4));
                shoppingCart.setPath(query.getString(5));
                shoppingCart.setInformation(query.getString(6));
                shoppingCart.setPrice(query.getDouble(7));
                list.add(shoppingCart);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }
    public void  addShopping(String[] strings){
        Users users = new Users();
        users.setUsername(Integer.parseInt(info));
        try {
                ResultSet query1 = new GoodsImp().query(strings[1]);
                if(strings[2].equals("true")){
                    if(query1.next()){
                        ShoppingCart shoppingCart = new ShoppingCart();
                        shoppingCart.setUsername(users.getUsername());
                        int number = Integer.parseInt(strings[3]);
                        System.out.println(strings[3]);
                        shoppingCart.setNumber(number==0?1:number);
                        shoppingCart.setName(query1.getString(2));
                        new ShoppingCartImp().add(shoppingCart);
                    }
                    JOptionPane.showMessageDialog(null, "加入购物车成功!");
                }else {
                    if(query1.next()){
                        ShoppingCart shoppingCart = new ShoppingCart();
                        shoppingCart.setUsername(users.getUsername());
                        shoppingCart.setNumber(1);
                        shoppingCart.setName(query1.getString(2));
                        new ShoppingCartImp().add(shoppingCart);
                    }
                    JOptionPane.showMessageDialog(null, "加入购物车成功!");
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public  void updateShopping(String[] strings){
        Users users = new Users();
        users.setUsername(Integer.parseInt(info));
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUsername(users.getUsername());
        shoppingCart.setNumber(Integer.parseInt(strings[1]));
        shoppingCart.setName(strings[2]);
        new ShoppingCartImp().update(shoppingCart);
    }
    //查询所有商品
    public List<Goods> allGoodsList(){
            List<Goods> allGoods = new ArrayList<>();
            String[]kinds = {"服装","零食","电器","食材","水果"};
            try {
                for(String kind:kinds){
                    ResultSet rs = new GoodsImp().query(kind);
                    while (rs.next()){
                        Goods goods = new Goods();
                        goods.setId(rs.getInt(1));
                        goods.setName(rs.getString(2));
                        goods.setKind(rs.getString(3));
                        goods.setPath(rs.getString(4));
                        goods.setPrice(rs.getDouble(5));
                        goods.setInformation(rs.getString(6));
                        allGoods.add(goods);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return allGoods;
    }
    //查询商品信息
    public List<Goods> goodsList(String name){
        List<Goods> goodslist = new ArrayList<>();
        try {
            ResultSet resultSet = new GoodsImp().query(name);
            while (resultSet.next()){
                Goods goods = new Goods();
                goods.setName(resultSet.getString(2));
                goods.setKind(resultSet.getString(3));
                goods.setPath(resultSet.getString(4));
                goods.setPrice(resultSet.getDouble(5));
                goods.setInformation(resultSet.getString(6));
                goodslist.add(goods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return goodslist;
    }
    //删除购物车的商品
    public void deleteCart(String[] info){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUsername(Integer.parseInt(info[0]));
        shoppingCart.setName(info[1]);
        new ShoppingCartImp().delete(shoppingCart);
    }
    //返回true or false判断用户名和密码是否正确
    public boolean login(String[] strings) throws SQLException {
        Users users = new Users();
        users.setUsername(Integer.parseInt(strings[0]));
        users.setUserpasswd(strings[1]);
        ResultSet rs =new UsersImp().query1(users);
        if(rs.next()) {
            rs.close();
            return true;
        }
        rs.close();
         return false;
    }
    //用户是否重复
    public boolean isreapt(String strings) throws SQLException {
        Users users = new Users();
        users.setUsername(Integer.parseInt(strings));
        ResultSet rs =new UsersImp().query(users);
        if(rs.next()) {
            rs.close();
            return false;
        }
        rs.close();
        return true;
    }
    //添加用户
    public void addUser(String[] strings){
        Users users = new Users();
        users.setUsername(Integer.parseInt(strings[0]));
        users.setUserpasswd(strings[1]);
        new UsersImp().add(users);
    }
    public void addBuys(String[] strings){
    Buys buys = new Buys();
    buys.setUsername(Integer.parseInt(strings[0]));
    buys.setNumber(Integer.parseInt(strings[1]));
    buys.setPrice(Double.parseDouble(strings[2]));
    buys.setName(strings[3]);
    new BuysImp().add(buys);
}
   //修改密码
    public void modifyUser(String[] strings){
    Users users = new Users();
    users.setUsername(Integer.parseInt(strings[0]));
    new UsersImp().modify(users,strings[1]);
}
   //vip等级
    public int vip(String[] strings) throws SQLException{
        Users users = new Users();
        users.setUsername(Integer.parseInt(strings[0]));
        users.setUserpasswd(strings[1]);
        ResultSet rs =new UsersImp().query1(users);
        System.out.println("...........");
        while (rs.next()){
            System.out.println("...........");
            System.out.println(rs.getInt(4));
            return rs.getInt(4);
        }
        return 0;
    }
    //更改vip
    public void updateVIP(String[] strings){
        Users users = new Users();
        users.setUsername(Integer.parseInt(strings[0]));
        new UsersImp().modifyVip(users, Integer.parseInt(strings[1]));
    }
}
