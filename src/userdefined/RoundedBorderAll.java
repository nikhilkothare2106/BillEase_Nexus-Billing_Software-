package userdefined;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public  class RoundedBorderAll implements Border {

    private int radius;
    public RoundedBorderAll(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
    
    public int getRadius() {
        return radius;
    }
} 