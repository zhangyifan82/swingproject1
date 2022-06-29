package javacourse.dbserver;

import javacourse.entity.Buys;
import javacourse.entity.Goods;
import javacourse.entity.ShoppingCart;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

public class TcpServer {
    public  static ServerSocket socketonserver  ;
    static {
        try {
            socketonserver=new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ServerSocket Getserversoket() throws IOException {
         return socketonserver;
    }

    public void querydata(Socket accept) throws IOException {
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[512];
        int len = inputStream.read(bytes);
        String s = new String(bytes, 0, len);
        System.out.println(s);
        if (s.startsWith("已购买:")) {
            List<Buys> query = new ServerQuery(s.substring(s.indexOf(":")+1)).queryBuys();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
            objectOutputStream.writeObject(query);
            System.out.println("已回应1");
        }
 else if(s.startsWith("购物车:")){
            List<ShoppingCart> query = new ServerQuery(s.substring(s.indexOf(":")+1)).shoppingCartList();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
            objectOutputStream.writeObject(query);
            System.out.println("已回应");
        }else if(s.startsWith("商品:")){
            List<Goods> query = new ServerQuery(s.substring(s.indexOf(":")+1)).allGoodsList();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
            objectOutputStream.writeObject(query);
            System.out.println("已回应2");
        }else if (s.startsWith("搜索商品:")){
            List<Goods> query = new ServerQuery("").goodsList(s.substring(s.indexOf(":")+1));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
            objectOutputStream.writeObject(query);
            System.out.println("已回应3");
        }else if(s.startsWith("删除购物车商品:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            new ServerQuery("").deleteCart(split);
        }else if(s.startsWith("登录:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            try {
                boolean login = new ServerQuery("").login(split);
                  int judge = login==true?1:0;
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write(judge);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(s.startsWith("注册:")){
            try {
                String[] split = s.substring(s.indexOf(":") + 1).split(" ");
                boolean isreapt = new ServerQuery("").isreapt(split[0]);
                int judge = isreapt==true?1:0;
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write(judge);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(s.startsWith("增加用户:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            new ServerQuery("").addUser(split);
        }else if(s.startsWith("加入已购:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            new ServerQuery("").addBuys(split);
        }else if(s.startsWith("增加购物车商品:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            new ServerQuery(split[0]).addShopping(split);
            System.out.println("增加成功！");
        }else if(s.startsWith("更新购物车商品:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            new ServerQuery(split[0]).updateShopping(split);
            System.out.println("更改成功！");
        }
        else if(s.startsWith("修改密码:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            new ServerQuery(split[0]).modifyUser(split);
            System.out.println("密码修改！");
        }else if(s.startsWith("vip:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            try {
                int vip = new ServerQuery(split[0]).vip(split);
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write(vip);
                System.out.println("vipA！"+vip);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(s.startsWith("升级vip:")){
            String[] split = s.substring(s.indexOf(":") + 1).split(" ");
            new ServerQuery(split[0]).updateVIP(split);
            System.out.println("vip修改！");
        }
        }

    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ServerPicture.serverpicture();
            }
        }).start();
        ServerSocket serverSocket2 = Getserversoket();
        Socket accept1 = serverSocket2.accept();
        while(true){
            new TcpServer().querydata(accept1);
        }
    }
}
