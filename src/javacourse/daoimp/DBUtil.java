package javacourse.daoimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
  //初始化各表
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String createDatabase = "create database if not exists " + "javacoursedata" + " default charset = utf8;";
            String url =  "jdbc:mysql://localhost/javacoursedata?user=root&password=158895";
            String createUserTable =
                    "Create Table If Not Exists users(" +
                            "  id int AUTO_INCREMENT," +
                            "  username int," +
                            "  userpasswd varchar(255)," +
                            "  vip INT ," +
                            "  PRIMARY KEY (id)" +
                            ")DEFAULT CHARSET=utf8;";

            String createGoodsTable =
                    "Create Table If Not Exists Goods (" +
                            "  id int AUTO_INCREMENT," +
                            "  name varchar(255) ," +
                            "  kind varchar(255) ," +
                            "  path varchar(255) ," +
                            "  price double ," +
                            "  information varchar(10000) ," +
                            "  PRIMARY KEY (id)" +
                            ")DEFAULT CHARSET=utf8;";

            String createShoppingCartTable =
                    "Create Table If Not Exists  ShoppingCart(" +
                            "  id int AUTO_INCREMENT," +
                            "  username int," +
                            "  number int," +
                            "  name varchar(255)," +
                            "  PRIMARY KEY (id)" +
                            ")DEFAULT CHARSET=utf8;";
            String createBuysTable =
                    "Create Table If Not Exists  Buys(" +
                            "  id int AUTO_INCREMENT," +
                            "  username int," +
                            "  number int," +
                            "  price double," +
                            "  name varchar(255)," +
                            "  PRIMARY KEY (id)" +
                            ")DEFAULT CHARSET=utf8;";
            try {
                Connection conn = DriverManager.getConnection(url);
                Statement stat = conn.createStatement();
                stat.executeUpdate(createDatabase);
                stat.executeUpdate(createUserTable);
                stat.executeUpdate(createGoodsTable);
                stat.executeUpdate(createShoppingCartTable);
                stat.executeUpdate(createBuysTable);
                stat.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        String url =  "jdbc:mysql://localhost/javacoursedata?user=root&password=158895";
        return DriverManager.getConnection(url);
    }

}
