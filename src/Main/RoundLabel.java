package Main;

import javax.swing.JLabel;
import javax.swing.border.AbstractBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

public class RoundLabel extends JLabel {

    public RoundLabel(String text, int radius) {
        super(text);
        setOpaque(false); // Make the label transparent for custom drawing
        setBackground(Color.WHITE); // Set the background color
        setBorder(new RoundedBorder(radius)); // Set the rounded border with a specified radius
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill the background with a round rectangle
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Adjust the radius to match the border

        super.paintComponent(g2); // Paint the label text and other components
        g2.dispose();
    }

    // Custom RoundedBorder class for the label
    private static class RoundedBorder extends AbstractBorder {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY); // Border color
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius); // Draw the rounded rectangle
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(10, 10, 10, 10); // Padding for the rounded border
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = insets.top = insets.bottom = 10;
            return insets;
        }
    }
}
