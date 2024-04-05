package package1;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
// import java.awt.Graphics2D;
public class ArrowLineFrame extends JPanel {

    private static final long serialVersionUID = 1L;

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArrowLine(g, 50, 50, 150, 150);
    }

    public static void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Draw the line
        g2d.drawLine(x1, y1, x2, y2);
        
        // Calculate the angle of the line
        double angle = Math.atan2(y2 - y1, x2 - x1);
        
        // Length and width of the arrowhead
        int arrowLength = 10;
        int arrowWidth = 5;
        
        // Draw the arrowhead at the end of the line
        Polygon arrowHead = new Polygon();
        arrowHead.addPoint(0, 0);
        arrowHead.addPoint(-arrowWidth, -arrowLength);
        arrowHead.addPoint(arrowWidth, -arrowLength);
        
        AffineTransform tx = new AffineTransform();
        tx.translate(x2, y2);
        tx.rotate(angle - Math.PI / 2);
        
        Graphics2D g2 = (Graphics2D) g2d.create();
        g2.setTransform(tx);
        g2.fill(arrowHead);
        g2.dispose();
        
        g2d.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Directed Line Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ArrowLineFrame());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}