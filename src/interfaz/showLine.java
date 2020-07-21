package interfaz;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;


public class showLine extends JPanel {
    private String vertice;
    private double puntoM;
    private double puntoB;
    private double puntoXG= 1000;
    private double puntoYG;
    private double puntoXP= -1000;
    private double puntoYP;

    showLine(double m, double b) {
        this.puntoM=m;
        this.puntoB=b;
        this.vertice=vertice;
        puntoYG=m*puntoXG+b;
        puntoYP=m*puntoXP+b;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(ColorUIResource.RED);
        g.drawLine((int) puntoXG, (int)puntoYG,(int)puntoXP,(int)puntoYP);
    }
}
