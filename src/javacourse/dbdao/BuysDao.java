package javacourse.dbdao;

import javacourse.entity.Buys;
import javacourse.entity.Users;

import java.sql.ResultSet;

public interface BuysDao {
    //查询
    public ResultSet query(Users users);
    public ResultSet query1();
    //增加
    public void add(Buys buys);
}
