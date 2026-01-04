package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircularButton extends JButton {

    public CircularButton(String label) {
        super(label);
        // Make the button non-focusable
        setFocusable(false);
        
        // Set size to ensure the button stays circular
        setPreferredSize(new Dimension(10, 10)); // Adjust size as needed
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.WHITE); // Change color when pressed
        } else {
            g.setColor(getBackground());
        }
        // Create a circular shape for the button
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1); // Draw circular border
    }

    @Override
    public boolean contains(int x, int y) {
        // Define the circular shape of the button
        Ellipse2D circle = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
        return circle.contains(x, y);
    }
}
