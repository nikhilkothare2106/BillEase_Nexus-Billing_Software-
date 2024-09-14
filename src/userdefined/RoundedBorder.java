package userdefined;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.border.Border;
import java.awt.geom.GeneralPath;

public class RoundedBorder implements Border {

    private int radiusTopLeft;
    private int radiusTopRight;
    private int radiusBottomLeft;
    private int radiusBottomRight;
    private int borderWidth;

    public RoundedBorder(int radiusTopLeft, int radiusTopRight, int radiusBottomLeft, int radiusBottomRight) {
        this.radiusTopLeft = radiusTopLeft;
        this.radiusTopRight = radiusTopRight;
        this.radiusBottomLeft = radiusBottomLeft;
        this.radiusBottomRight = radiusBottomRight;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        // Return insets as zero since we are drawing the border ourselves
        return new Insets(borderWidth,borderWidth,borderWidth,borderWidth);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new java.awt.BasicStroke(borderWidth));
        // Create a GeneralPath for the custom rounded rectangle
        GeneralPath path = new GeneralPath();
        
        int adjustedX = x + borderWidth / 2;
        int adjustedY = y + borderWidth / 2;
        int adjustedWidth = width - borderWidth;
        int adjustedHeight = height - borderWidth;
        
        // Start at the top-left corner
path.moveTo(adjustedX + radiusTopLeft, adjustedY);
        
        // Top edge
        path.lineTo(adjustedX + adjustedWidth - radiusTopRight, adjustedY);
        path.quadTo(adjustedX + adjustedWidth, adjustedY, adjustedX + adjustedWidth, adjustedY + radiusTopRight);
        
        // Right edge
        path.lineTo(adjustedX + adjustedWidth, adjustedY + adjustedHeight - radiusBottomRight);
        path.quadTo(adjustedX + adjustedWidth, adjustedY + adjustedHeight, adjustedX + adjustedWidth - radiusBottomRight, adjustedY + adjustedHeight);
        
        // Bottom edge
        path.lineTo(adjustedX + radiusBottomLeft, adjustedY + adjustedHeight);
        path.quadTo(adjustedX, adjustedY + adjustedHeight, adjustedX, adjustedY + adjustedHeight - radiusBottomLeft);
        
        // Left edge
        path.lineTo(adjustedX, adjustedY + radiusTopLeft);
        path.quadTo(adjustedX, adjustedY, adjustedX + radiusTopLeft, adjustedY);
        
        // Close the path
        path.closePath();
        
        // Draw the custom shape
        g2d.draw(path);
   
    }

    public int getRadiusTopLeft() {
        return radiusTopLeft;
    }

    public int getRadiusTopRight() {
        return radiusTopRight;
    }

    public int getRadiusBottomLeft() {
        return radiusBottomLeft;
    }

    public int getRadiusBottomRight() {
        return radiusBottomRight;
    }
}
