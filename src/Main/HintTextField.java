package Main;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

public class HintTextField extends JTextField {
    private String hint;
    private int padding;

    // Constructor with hint and padding
    public HintTextField(String hint, int padding) {
        this.hint = hint;
        this.padding = padding; // Padding value
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
            g2.setFont(g2.getFont().deriveFont(Font.BOLD));

            // Get font metrics to calculate the vertical position for centering the hint
            FontMetrics fm = g2.getFontMetrics();
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent(); // Calculate y for vertical centering

            // Use the padding value for left alignment
            g2.drawString(hint, padding, y);
            g2.dispose();
        }
    }
}
