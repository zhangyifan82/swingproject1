package javacourse.dbdao;

import javacourse.entity.Goods;

import java.sql.ResultSet;

public interface GoodsDao {
    //查询
    public ResultSet query(String kind);
    //增加
    public void add(Goods goods);
}
