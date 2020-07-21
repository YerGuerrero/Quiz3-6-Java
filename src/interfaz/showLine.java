package interfaz;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;


public class showLine extends JPanel {
    private String vertice;
    private double puntoM;
    private double puntoB;
    private double puntoXG = 1000;
    private double puntoYG;
    private double puntoXP = 0;
    private double puntoYP;

    showLine(double m, double b) {
        this.puntoM = m;
        this.puntoB = b;
        this.vertice = vertice;
        puntoYG = (m * puntoXG) + b;
        puntoYP = (m * puntoXP) + b;
        //System.out.println("M: " + String.valueOf(m) + " B: " + String.valueOf(b));
        //System.out.println("X1: " + String.valueOf(puntoXP) + "  Y1: " + String.valueOf(puntoYP));
        //System.out.println("X2: " + String.valueOf(puntoXG) + "  Y2: " + String.valueOf(puntoYG));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(ColorUIResource.WHITE);
        g.drawLine((int) puntoXG, (int) puntoYG, (int) puntoXP, (int) puntoYP);
    }
}
