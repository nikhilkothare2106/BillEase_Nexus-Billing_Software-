package userdefined;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class RoundedPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Border border;

    public RoundedPanel(int radius) {
        this.border = new RoundedBorder(radius);
        setBorder(border);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the background color inside the border
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), ((RoundedBorder) border).getRadius(), ((RoundedBorder) border).getRadius());
    }
    
    // Helper method to get the radius from the border
    public int getRadius() {
        return ((RoundedBorder) border).getRadius();
    }
}
