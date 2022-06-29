package javacourse.dbdao;

import javacourse.entity.ShoppingCart;
import javacourse.entity.Users;

import java.sql.ResultSet;

public interface ShoppingCartDao {
    public void add(ShoppingCart shoppingCart);
    public void delete(ShoppingCart shoppingCart);
    public void update(ShoppingCart shoppingCart);
    public ResultSet query(Users users);
}
