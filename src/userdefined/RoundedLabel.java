package userdefined;

import javax.swing.*;
import java.awt.*;

public class RoundedLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
    private Color borderColor;
    private int cornerRadius = 30;
    private int borderThickness = 2; // Thickness of the border

    public RoundedLabel(String text, int cornerRadius, Color bgColor, Color borderColor, int borderThickness) {
        super(text);
        this.cornerRadius = cornerRadius;
        this.backgroundColor = bgColor;
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
        setOpaque(false); // Make JLabel transparent
        setForeground(Color.BLACK); // Set text color
        setHorizontalAlignment(SwingConstants.CENTER); // Align text in center
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Enable anti-aliasing for smoother edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded rectangle background
        g2.setColor(backgroundColor);
        g2.fillRoundRect(borderThickness, borderThickness,
                getWidth() - borderThickness * 2, getHeight() - borderThickness * 2,
                cornerRadius, cornerRadius);

        // Draw the rounded border
        g2.setStroke(new BasicStroke(borderThickness)); // Set border thickness
        g2.setColor(borderColor);
        g2.drawRoundRect(borderThickness / 2, borderThickness / 2,
                getWidth() - borderThickness, getHeight() - borderThickness,
                cornerRadius, cornerRadius);

        // Draw the label's text
        super.paintComponent(g);
    }

}