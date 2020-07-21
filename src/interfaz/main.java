/*
Thifany Gonzales
Yerlyn Guerrero
Daniela Paniagua
Edgar Oviedo
 */

package interfaz;

import aritmetica.Fraccion;
import geometria.Punto;
import geometria.Triangulo;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class main {

    public static void main(String[] args) {
        Properties config = new Properties();
        InputStream configInput = null;
        try {
            configInput = new FileInputStream("/home/edgar/IdeaProjects/Quiz3-6-Java/src/Config.properties");
            config.load(configInput);
            String x = config.getProperty("puntos_x");
            String[] puntosX = x.split(" ");
            String y = config.getProperty("puntos_y");
            String[] puntosY = y.split(" ");
            Punto puntoA = new Punto(Integer.parseInt(puntosX[0]), Integer.parseInt(puntosY[0]));
            Punto puntoB = new Punto(Integer.parseInt(puntosX[1]), Integer.parseInt(puntosY[1]));
            Punto puntoC = new Punto(Integer.parseInt(puntosX[2]), Integer.parseInt(puntosY[2]));
            Triangulo triangulo = new Triangulo(puntoA, puntoB, puntoC);

            String esperar1 = config.getProperty("esperar1");
            Thread.sleep(Integer.parseInt(esperar1));


            JFrame frame = new JFrame();
            frame.setTitle("Triangulo");
            frame.setBackground(Color.BLACK);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Triangilo original
            frame.add(new showColors(puntoA.getX(), puntoA.getY(), puntoB.getX(), puntoB.getY(), puntoC.getX(), puntoC.getY()));
            frame.setVisible(true);
            frame.pack();
            Thread.sleep(3000);

            // Escalar
            System.out.println("Escalar");
            String escalar = config.getProperty("escalar");
            String[] fraccion = x.split(" ");
            triangulo.escalar(new Punto(500, 500), new Fraccion(Integer.parseInt(fraccion[0]), Integer.parseInt(fraccion[1])));
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(new showColors(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY()));
            frame.pack();
            frame.setVisible(true);


            String esperar2 = config.getProperty("esperar2");
            Thread.sleep(Integer.parseInt(esperar2));

            // Rotar
            String rotar = config.getProperty("rotar");
            triangulo.rotar(new Punto(500, 500), Integer.parseInt(rotar));
            System.out.println(triangulo.getA());
            System.out.println(triangulo.getB());
            System.out.println(triangulo.getC());
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(new showColors(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY()));
            frame.pack();
            frame.setVisible(true);

            String esperar3 = config.getProperty("esperar3");
            Thread.sleep(Integer.parseInt(esperar3));

            // Textura
            String textura = config.getProperty("textura");
            frame.setBackground(Color.BLACK);
            frame.getContentPane().removeAll();
            frame.setBackground(Color.BLACK);
            frame.revalidate();
            frame.repaint();
            frame.setBackground(Color.BLACK);
            frame.add(new showTexture(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY(), textura));
            frame.pack();
            frame.setVisible(true);

            String esperar4 = config.getProperty("esperar4");
            Thread.sleep(Integer.parseInt(esperar4));

            // Bisectriz
            String bisectriz = config.getProperty("bisectriz");
            if (bisectriz == "bisectriz") {
                triangulo.getBisectriz('a');
                triangulo.getBisectriz('b');
                triangulo.getBisectriz('c');
            }

            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(new showTexture(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY(), textura));
            frame.setVisible(true);
            frame.add(new showLine(triangulo.getBisectriz('a').getM(), triangulo.getBisectriz('a').getB()));
            frame.setVisible(true);
            frame.add(new showLine(triangulo.getBisectriz('b').getM(), triangulo.getBisectriz('b').getB()));
            frame.setVisible(true);
            frame.add(new showLine(triangulo.getBisectriz('c').getM(), triangulo.getBisectriz('c').getB()));
            frame.setVisible(true);
            frame.pack();

            String esperar5 = config.getProperty("esperar5");
            Thread.sleep(Integer.parseInt(esperar5));

            // Mediatriz
            String mediatriz = config.getProperty("mediatriz");
            if (mediatriz == "mediatriz") {
                triangulo.getMediatriz('a');
                triangulo.getMediatriz('b');
                triangulo.getMediatriz('c');
            }

            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(new showTexture(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(), triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY(), textura));
            frame.setVisible(true);
            frame.add(new showLine(triangulo.getMediatriz('a').getM(), triangulo.getMediatriz('a').getB()));
            frame.setVisible(true);
            frame.add(new showLine(triangulo.getMediatriz('b').getM(), triangulo.getMediatriz('b').getB()));
            frame.setVisible(true);
            frame.add(new showLine(triangulo.getMediatriz('c').getM(), triangulo.getMediatriz('c').getB()));
            frame.setVisible(true);
            frame.pack();

            // Area
            String area = config.getProperty("area");
            if (area == "area") {
                triangulo.getArea();
            }
            JOptionPane.showMessageDialog(null, "El área del triángulo es: " + triangulo.getArea());


            String esperar6 = config.getProperty("esperar6");
            Thread.sleep(Integer.parseInt(esperar6));

            // Perimetro
            String perimetro = config.getProperty("perimetro");
            if (perimetro == "perimetro") {
                triangulo.getPerimetro();
            }
            JOptionPane.showMessageDialog(null, "El périmetro es: " + triangulo.getPerimetro());


            String esperar7 = config.getProperty("esperar7");
            Thread.sleep(Integer.parseInt(esperar7));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
