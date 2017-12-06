package com.lxy.Semantic;

import javax.swing.*;
import java.awt.*;

public class SemanticPanel extends JPanel {

    private static double x = 100;
    private static double y = 100;
    public void display(double xPoint,double yPoint)
    {
        x = xPoint;
        y = yPoint;
        Graphics graphics = this.getGraphics();
        this.paint(graphics);
    }

    public void paint(Graphics g)
    {
        Graphics2D graphics2D = (Graphics2D)g;
        //初始化
        g.setColor(Color.BLUE);
        g.drawLine((int)x,(int)y,(int)x,(int)y);
    }

}
