package Main;

import javax.swing.Icon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CustomRadioButtonIcon implements Icon {
    private final boolean selected;

    public CustomRadioButtonIcon() {
        this(false);
    }

    public CustomRadioButtonIcon(boolean selected) {
        this.selected = selected;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the size of the circle (radio button)
        int circleDiameter = 14; // You can change this to make it larger or smaller

        // Draw the outer circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, circleDiameter, circleDiameter);
        
        // Draw the filled circle if selected
        if (selected) {
            g2d.setColor(Color.BLACK);
            g2d.fillOval(x + 4, y + 4, circleDiameter - 8, circleDiameter - 8); // Inner circle size
        }
    }

    @Override
    public int getIconWidth() {
        return 20; // Adjust this value based on circle size
    }

    @Override
    public int getIconHeight() {
        return 16; // Adjust this value based on circle size
    }
}
