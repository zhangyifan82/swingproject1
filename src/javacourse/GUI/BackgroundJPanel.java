package javacourse.GUI;

import javax.swing.*;
import java.awt.*;

public class BackgroundJPanel extends JPanel
{
    Image im;
    public BackgroundJPanel(Image im)
    {
        this.im=im;
        this.setOpaque(true);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);

    }
}
