package interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class showTexture extends JPanel {
    private String direccion;
    private TriangleShape triangleShape;

    showTexture(int x1, int x2, int y1, int y2, int z1, int z2,String imagen) {
        direccion=imagen;
        triangleShape = new TriangleShape(new Point2D.Double(x1, x2),
                new Point2D.Double( y1, y2), new Point2D.Double(z1, z2));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        BufferedImage img = null;

        try {
            img = ImageIO.read( new File(direccion));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(new TexturePaint(img,new Rectangle(-1, 0, 90, 60)));
        g2d.fill(triangleShape);
        g2d.dispose();
    }

}