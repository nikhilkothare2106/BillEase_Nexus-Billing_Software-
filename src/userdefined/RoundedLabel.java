package userdefined;

import javax.swing.*;
import java.awt.*;

public class RoundedLabel extends JLabel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoundedBorder border;

    public RoundedLabel(String text, int radius, Color borderColor,Icon icon) {
        super(text,icon,JLabel.CENTER);
        this.border = new RoundedBorder(radius);  // Set the custom border with color
        setBorder(border);
        setOpaque(false);  // Let us manage the background painting
        setVerticalTextPosition(JLabel.BOTTOM);
    }
    @Override
    protected void paintComponent(Graphics g) {
        // Paint background inside the border
        g.setColor(getBackground());
        Insets insets = border.getBorderInsets(this);
        g.fillRoundRect(insets.left, insets.top, getWidth() - insets.left - insets.right,
                getHeight() - insets.top - insets.bottom, border.getRadius(), border.getRadius());
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (border != null) {
            border.paintBorder(this, g, 0, 0, getWidth(), getHeight());
        }
    }
}
