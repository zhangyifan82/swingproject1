package javacourse.dbdao;

import javacourse.entity.Users;

import java.sql.ResultSet;

public interface UsersDao {
    //添加
    public void add(Users user);
    //查询
    public ResultSet query(Users user) ;
    //查询vip等级
    public ResultSet query1(Users user) ;
    //修改用户密码
    public void modify(Users users,String passwd);
    //更改vip
    public void modifyVip(Users users,int vip);
}
