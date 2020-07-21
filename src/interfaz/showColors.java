package interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class showColors extends JPanel {

    private TriangleShape triangleShape;

    showColors(int x1, int x2, int y1, int y2, int z1, int z2) {

        super.setBackground(Color.BLACK);
        triangleShape = new TriangleShape(new Point2D.Double(x1, x2),
                new Point2D.Double( y1, y2), new Point2D.Double(z1, z2));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.CYAN);
        g2d.fill(triangleShape);
        g2d.dispose();
    }
}

class TriangleShape extends Path2D.Double {

    public TriangleShape(Point2D... points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
}
