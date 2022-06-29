package javacourse.listener;

import javacourse.GUI.ResearchGUI;
import javacourse.dbserver.Query;
import javacourse.entity.Goods;
import javacourse.entity.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ResearchListener implements ActionListener {
    public Users users;
    public int page;
    public JTextField research;
    public String kind;
    public JFrame frame;
    public ResearchListener(JTextField research,Users users) {
        this.research = research;
        this.users = users;
    }

    public ResearchListener(Users users,String kind) {
        this.users = users;
        this.kind = kind;
    }

    public ResearchListener(Users users,int page, String kind) {
        this.users = users;
        this.page = page;
        this.kind = kind;
    }

    public ResearchListener(Users users,int page, String kind, JFrame frame) {
        this.users = users;
        this.page = page;
        this.kind = kind;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name;
            if(research!=null){
               name = research.getText();
            }
            else {
               name = kind;
            }
        List<Goods> goodsList = new Query(users).queryGoods(name);
        System.out.println(goodsList.size());
        if(frame!=null){
               frame.dispose();
           }
         new ResearchGUI(goodsList,users,page).init();
    }
}
