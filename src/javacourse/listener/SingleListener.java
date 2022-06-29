package javacourse.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleListener implements ActionListener {
    public JTextField jTextField;
    public int number;

    public SingleListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         number = Integer.parseInt(jTextField.getText());
         if(e.getActionCommand().equals("增加")){
             number++;
             jTextField.setText(""+number);
         }else {
             if(number<=1){
               return;
             }else {
                 number--;
                 jTextField.setText(""+number);
             }
         }
    }
    public int getNumber(){
        return number;
    }
}
