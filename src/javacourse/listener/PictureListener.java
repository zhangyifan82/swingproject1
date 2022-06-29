package javacourse.listener;

import javacourse.GUI.SingleGoodsGUI;
import javacourse.dbserver.Query;
import javacourse.entity.Goods;
import javacourse.entity.Users;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PictureListener implements ActionListener {
    public Users users;

    public PictureListener(Users users) {
        this.users = users;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        List<Goods> goodsList = new Query(users).queryAllGoods();
//        Goods goods = new Goods();
        for (Goods goods1:goodsList){
            if(goods1.getName().equals(name)){
                new SingleGoodsGUI(goods1,users).init();
              break;
            }
        }
        //单个商品界面

    }
}
