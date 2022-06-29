package javacourse.dbserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDBconnection {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String createDatabase = "create database if not exists " + "javacoursedata" + " default charset = utf8;";
            String url =  "jdbc:mysql://localhost/javacoursedata?user=root&password=158895";

            try {
                Connection conn = DriverManager.getConnection(url);
                Statement stat = conn.createStatement();
                stat.executeUpdate(createDatabase);
                stat.close();
                conn.close();
            } catch (SQLException e) {
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
