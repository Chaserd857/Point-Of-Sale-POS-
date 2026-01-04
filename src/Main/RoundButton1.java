package Main;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

public class RoundButton1 extends JButton {

    public RoundButton1(String text) {
        super(text);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Add some padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isArmed()) {
            g2d.setColor(Color.WHITE);
        } else {
            g2d.setColor(getBackground());
        }

        g2d.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 20);

        // Draw the outline
        g2d.setColor(new Color(77,87,93,255)); // Outline color
        g2d.setStroke(new BasicStroke(2)); // Outline thickness
        g2d.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 20, 20);

        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        return size;
    }
}
