package geometria;

import aritmetica.Fraccion;
import java.awt.Polygon;
import java.awt.desktop.SystemSleepEvent;

public class Triangulo extends Polygon{
    private Punto A;
    private Punto B;
    private Punto C;

    public Triangulo(int [] xs, int [] ys){
        super(xs,ys,3);
    }
    
    public Triangulo(Punto A, Punto B, Punto C){
        if(!sonColineales(A,B,C)){
            this.A = A; this.B = B; this.C = C;
            int xs[] = {A.getX(), B.getX(), C.getX()};
            int ys[] = {A.getY(), B.getY(), C.getY()};
            super.xpoints = xs;
            super.ypoints = ys;
            super.npoints = 3;	            
        }
        //else  throw GeometricException
    }
        
    private boolean sonColineales(Punto A, Punto B, Punto C){
        Recta r1 = new Recta (A,B);
        return r1.equals(new Recta(A,C));
    }
    
    public double getPerimetro(){
        return geta()+getb()+getc();
    }
    
    public double geta(){return B.distanciaCon(C);}
    public double getb(){return A.distanciaCon(C);}
    public double getc(){return B.distanciaCon(A);}
    
    public Punto getA(){return this.A;}
    public Punto getB(){return this.B;}
    public Punto getC(){return this.C;}
    
    public double getArea(){
        double S = getPerimetro()/2;
        return Math.sqrt(S*(S-geta())*(S-getb())*(S-getc()));        
    }
    
    public void mover(int deltaX, int deltaY){// super.traslate(deltaX, deltaY)
        this.A = A.mover(deltaX, deltaY);
        this.B = B.mover(deltaX, deltaY);
        this.C = C.mover(deltaX, deltaY);
    }
    
    public void escalar(Punto ref, Fraccion f){
        this.mover(ref.getX()*-1, ref.getY()*-1);
 	  	this.A = new Punto(f.multiplicar(A.getX()).intValue(), f.multiplicar(A.getY()).intValue());
       	this.B = new Punto(f.multiplicar(B.getX()).intValue(), f.multiplicar(B.getY()).intValue());
       	this.C = new Punto(f.multiplicar(C.getX()).intValue(), f.multiplicar(C.getY()).intValue());
        this.mover(ref.getX(), ref.getY());	
    }
    
    public void escalar(Fraccion f){
        escalar(new Punto(0,0), f);
    }
    
    public void rotar(Punto ref, int angulo){
        this.mover(ref.getX()*-1, ref.getY()*-1);
 	  	this.A = A.rotar(angulo);
       	this.B = B.rotar(angulo);
       	this.C = C.rotar(angulo);
        this.mover(ref.getX(), ref.getY());
    }
    
    /*
     * Retorna la "recta notable" del lado opuesto al vértice indicado
     */
    
    public Recta getMediatriz(char vertice){
        Recta r;
        switch(vertice){
            case 'a' : r = new Recta(this.B, this.C);
                       return r.perpendicularEn(B.puntoMedioCon(C));
            case 'b' : r = new Recta(this.A, this.C);
                       return r.perpendicularEn(A.puntoMedioCon(C));
            default :  r = new Recta(this.A, this.B);
                       return r.perpendicularEn(A.puntoMedioCon(B));
        }
    }
    
    public Recta getBisectriz(char vertice){
        double r;
        switch(vertice){
            case 'a' : r = this.A.distanciaCon(this.B)/this.A.distanciaCon(this.C);
                       return new Recta(this.A, this.B.puntoEntre(C,r));
            case 'b' : r = this.B.distanciaCon(this.C)/this.B.distanciaCon(this.A);
                       return new Recta(this.B, this.C.puntoEntre(A,r));
            default :  r = this.C.distanciaCon(this.A)/this.C.distanciaCon(this.B);
                       return new Recta(this.C, this.A.puntoEntre(B,r));
            }
    }   
    
    public Recta getMediana(char vertice){
        switch(vertice){
            case 'a' : return new Recta(this.A, this.B.puntoMedioCon(this.C));
            case 'b' : return new Recta(this.B, this.A.puntoMedioCon(this.C));
            default : return new Recta(this.C, this.B.puntoMedioCon(this.A));
        }
    }
    
    public Recta getAltura(char vertice){
        Recta r;
       switch(vertice){
            case 'a' : r = new Recta(this.B, this.C);
                       return r.perpendicularEn(this.A);
            case 'b' : r = new Recta(this.A, this.C);
                       return r.perpendicularEn(this.B);
            default :  r = new Recta(this.A, this.B);
                       return r.perpendicularEn(this.C);
        }
    }
 
    /*
     * Retorna la intersección de las rectas notables 
     */   
     
     public Punto getCircuncentro(){
        return getMediatriz('a').interseccion(getMediatriz('b'));
     }
     
     public Punto getIncentro(){
        return getBisectriz('a').interseccion(getBisectriz('b'));
     }
     
     public Punto getBaricentro(){
        return getMediana('a').interseccion(getMediana('b'));
     }
     
     public Punto getOrtocentro(){
        return getAltura('a').interseccion(getAltura('b'));
     }
     
     public boolean contains(Punto p){
        return super.contains(p.getX(), p.getY());
     }
    
}
