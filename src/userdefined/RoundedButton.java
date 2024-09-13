package userdefined;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class RoundedButton extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Border border;
	private Color color;

    public RoundedButton(String text, int radius, Color color) {
        super(text);
        this.color = color;
        this.border = new RoundedBorder(radius);  // Set the custom border
        setBorder(border);
        setContentAreaFilled(false);  // Disable default background filling
    }
    @Override
    protected void paintComponent(Graphics g) {
        // Paint background inside the border
    	g.setColor(getBackground());

        // Fill the rounded area with background color
        g.fillRoundRect(0, 0, getWidth(), getHeight(), ((RoundedBorder) border).getRadius(), ((RoundedBorder) border).getRadius());
        g.setColor(color);

        // Paint the text and rest of the component
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (border != null) {
            border.paintBorder(this, g, 0, 0, getWidth(), getHeight());
        }
    }
}
