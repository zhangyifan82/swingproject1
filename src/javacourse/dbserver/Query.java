package javacourse.dbserver;

import javacourse.entity.Goods;
import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;

import java.io.*;
import java.net.Socket;
import java.util.List;

//客户端
public class Query {
    public Users users;
    public Query(Users users) {
        this.users = users;
    }

    public Query() {
    }
    //查询用户购物车商品
    public List<ShoppingCart> queryCartlist(){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("购物车请求服务器！");
            String info = "购物车:"+String.valueOf(users.getUsername());
            outputStream.write(info.getBytes());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            List<ShoppingCart> list = (List<ShoppingCart>) objectInputStream.readObject();
            return list;
        } catch (Exception e1){
            e1.printStackTrace();
        }

        return  null;
    }
    //传入商品名
    public void addshopping(String username,String name,String is,String number){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("增加购物车商品！");
            String info = "增加购物车商品:"+username+" "+name+" "+is+" "+number;
            outputStream.write(info.getBytes());
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void updateShopping(ShoppingCart shoppingCart ){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("更新购物车商品！");
            String info = "更新购物车商品:"+shoppingCart.getUsername()+" "+shoppingCart.getNumber()+" "+shoppingCart.getName();
            outputStream.write(info.getBytes());
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public List<Goods> queryAllGoods(){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("所有商品！");
            String info = "商品:"+String.valueOf(users.getUsername());
            outputStream.write(info.getBytes());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            List<Goods> list = (List<Goods>) objectInputStream.readObject();
            return list;
        } catch (Exception e1){
            e1.printStackTrace();
        }

        return  null;
    }
    public List<Goods> queryGoods(String name){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("搜索请求服务器！");
            String info = "搜索商品:"+name;
            outputStream.write(info.getBytes());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            List<Goods> list = (List<Goods>) objectInputStream.readObject();
            return list;
        } catch (Exception e1){
            e1.printStackTrace();
        }

        return  null;
    }
    public void deleteRequst(ShoppingCart shoppingCart){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("删除请求服务器！");
            String info = "删除购物车商品:"+String.valueOf(shoppingCart.getUsername())+" "+shoppingCart.getName();
            outputStream.write(info.getBytes());
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public String loginJudge(Users users){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("登录请求服务器！");
            String info = "登录:"+String.valueOf(users.getUsername())+" "+users.getUserpasswd();
            outputStream.write(info.getBytes());
            InputStream inputStream = socket.getInputStream();
            int len = inputStream.read();
            return String.valueOf(len);
        } catch (Exception e1){
            e1.printStackTrace();
        }
        return null;
    }
    //返回vip等级
    public String vip(Users users){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("请求vip");
            String info = "vip:"+String.valueOf(users.getUsername())+" "+users.getUserpasswd();
            outputStream.write(info.getBytes());
            InputStream inputStream = socket.getInputStream();
            int len = inputStream.read();
//            System.out.println(len);
            return String.valueOf(len);
        } catch (Exception e1){
            e1.printStackTrace();
        }
        return null;
    }
    //更改vip
    public void updateVIP(int vip){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("升级vip");
            String info = "升级vip:"+String.valueOf(users.getUsername())+" "+vip;
            outputStream.write(info.getBytes());
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public String register(Users users){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("注册请求服务器！");
            String info = "注册:"+String.valueOf(users.getUsername())+" "+users.getUserpasswd();
            outputStream.write(info.getBytes());
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[256];
            int len = inputStream.read(bytes);
            String s = new String(bytes, 0, len);
            return s;
        } catch (Exception e1){
            e1.printStackTrace();
        }
        return null;
    }
    public void addUser(Users users){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("增加用户请求！");
            String info = "增加用户:"+String.valueOf(users.getUsername())+" "+users.getUserpasswd();
            outputStream.write(info.getBytes());
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void addBuys(ShoppingCart shoppingCart){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("加入已购请求！");
            String info = "加入已购:"+String.valueOf(shoppingCart.getUsername())+" "+String.valueOf(shoppingCart.getNumber())+" "
                    +String.valueOf(shoppingCart.getPrice())+" "+shoppingCart.getName();
            outputStream.write(info.getBytes());
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    //修改密码
    public void modifyUser(String passwd){
        try {
            Socket socket = Clientserver.Getsocket();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("修改密码！");
            String info = "修改密码:"+String.valueOf(users.getUsername())+" "+passwd;
            outputStream.write(info.getBytes());
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
