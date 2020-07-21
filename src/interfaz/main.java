package interfaz;

import aritmetica.Fraccion;
import geometria.Punto;
import geometria.Triangulo;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class   main {

    public static void main(String[] args) {
        Properties config = new Properties();
        InputStream configInput = null;
        try {
            configInput = new FileInputStream("/home/yerguerrero/Diseño/Quiz3-6/src/Config.properties");
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
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            System.out.println("Escalar");
            String escalar = config.getProperty("escalar");
            String[] fraccion = x.split(" ");
            triangulo.escalar(new Punto(500, 500), new Fraccion(Integer.parseInt(fraccion[0]), Integer.parseInt(fraccion[1])));
            System.out.println(triangulo.getA());
            System.out.println(triangulo.getB());
            System.out.println(triangulo.getC());
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(new showColors(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(),triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY()));
            frame.pack();
            frame.setVisible(true);


            String esperar2 = config.getProperty("esperar2");
            Thread.sleep(Integer.parseInt(esperar2));

            System.out.println("Rotar");
            String rotar = config.getProperty("rotar");
            triangulo.rotar(new Punto(500, 500), Integer.parseInt(rotar));
            System.out.println(triangulo.getA());
            System.out.println(triangulo.getB());
            System.out.println(triangulo.getC());
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(new showColors(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(),triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY()));
            frame.pack();
            frame.setVisible(true);


            String esperar3 = config.getProperty("esperar3");
            Thread.sleep(Integer.parseInt(esperar3));

            String textura = config.getProperty("textura");

                frame.getContentPane().removeAll();
                frame.revalidate();
                frame.repaint();
                frame.add(new showTexture(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(),triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY(),textura));
                frame.pack();
                frame.setVisible(true);



            String esperar4 = config.getProperty("esperar4");
            Thread.sleep(Integer.parseInt(esperar4));

            System.out.println("bisectriz");
            String bisectriz = config.getProperty("bisectriz");
            if (bisectriz == "bisectriz") {
                triangulo.getBisectriz('a');
                triangulo.getBisectriz('b');
                triangulo.getBisectriz('c');
            }

            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            frame.add(new showTexture(triangulo.getA().getX(), triangulo.getA().getY(), triangulo.getB().getX(),triangulo.getB().getY(), triangulo.getC().getX(), triangulo.getC().getY(),textura));
            frame.add(new showLine(triangulo.getBisectriz('a').getM(),triangulo.getBisectriz('a').getB()));
            frame.add(new showLine(triangulo.getBisectriz('b').getM(),triangulo.getBisectriz('b').getB()));
            frame.add(new showLine(triangulo.getBisectriz('c').getM(),triangulo.getBisectriz('c').getB()));
            frame.pack();
            frame.setVisible(true);

            System.out.println(triangulo.getBisectriz('a').getM() + "," + triangulo.getBisectriz('a').getB());
            System.out.println(triangulo.getBisectriz('b').getM() + "," + triangulo.getBisectriz('b').getB());
            System.out.println(triangulo.getBisectriz('c').getM() + "," + triangulo.getBisectriz('c').getB());


            String esperar5 = config.getProperty("esperar5");
            Thread.sleep(Integer.parseInt(esperar5));

            System.out.println("Mediatriz");
            String mediatriz = config.getProperty("mediatriz");
            if (mediatriz == "mediatriz") {
                triangulo.getMediatriz('a');
                triangulo.getMediatriz('b');
                triangulo.getMediatriz('c');
            }
            System.out.println(triangulo.getMediatriz('a').getM() + "," + triangulo.getMediatriz('a').getB());
            System.out.println(triangulo.getMediatriz('b').getM() + "," + triangulo.getMediatriz('b').getB());
            System.out.println(triangulo.getMediatriz('c').getM() + "," + triangulo.getMediatriz('c').getB());

            System.out.println("area");
            String area = config.getProperty("area");
            if (area == "area") {
                triangulo.getArea();
            }
            JOptionPane.showMessageDialog(null, "El área del triángulo es: " + triangulo.getArea());


            String esperar6 = config.getProperty("esperar6");
            Thread.sleep(Integer.parseInt(esperar6));

            System.out.println("perimetro");
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
