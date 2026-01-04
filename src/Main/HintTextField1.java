package Main;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Graphics;

public class HintTextField1 extends JTextField {
    private String hint;
    private int padding;

    // Constructor with hint and padding
    public HintTextField1(String hint, int padding) {
        this.hint = hint;
        this.padding = padding; // Padding value
        setOpaque(false); // Make the background transparent for the rounded border
        setBorder(new RoundedBorder(6)); // Set the rounded border with radius 6
        setBackground(Color.WHITE); // Set the background color to white
    }

    @Override
    public Insets getInsets() {
        return new Insets(5, padding, 5, 5); // Top, left, bottom, right padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);  // Color of the hint

            // Set the font to plain
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN));

            // Get font metrics to calculate the vertical position for centering the hint
            FontMetrics fm = g2.getFontMetrics();
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent(); // Calculate y for vertical centering

            // Use the padding value for left alignment
            g2.drawString(hint, padding, y);
            g2.dispose();
        }
    }
 // Custom RoundedBorder class
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
