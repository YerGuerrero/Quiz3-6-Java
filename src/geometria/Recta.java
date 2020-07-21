package geometria;

public class Recta{

    // y = mx+b
    private double m;
    private double b;
    
    public Recta(){
        this.m = 1.0; this.b = 0.0;
    }
    
    public Recta(Punto a, Punto b){
        this.m = (b.getY()-a.getY())*1.0/(b.getX()-a.getX());
        this.b = a.getY()-this.m*a.getX();
    }
    
    public Recta(Punto a){
        this(a, new Punto(0,0));
    }
    
    public Recta(double m, double b){
        this.m = m;
        this.b = b;
    }
    
    public double getM(){return m;}
    public double getB(){return b;}
    public void setM(double m){ this.m = m;}
    public void setB(double b){ this.b = b;}
    
    
    /**
     * retorna null si no hay intersección 
     * retorna {MAX_INT, MAX_INT} si son la misma
     */
    public Punto interseccion(Recta r){
        if(this.equals(r)) return new Punto(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if(this.esParalela(r)) return null;
        double x = (r.getB()-this.b)/(this.m-r.getM());
        double y = this.m*x+this.b;	
        return new Punto((int)Math.round(x), (int)Math.round(y));
    }
    
    public boolean equals(Recta r)
    {return r.getM() == this.m && r.getB() == this.b;}
    
    public boolean esParalela(Recta r){
        return r.getM() == this.m;
    }
    
    public boolean esPerpendicularCon(Recta r){
        return -0.999999 < r.getM()*this.m && r.getM()*this.m < -1.000001;
    }
    
    public boolean pasaPor(Punto pto){
        return pto.getY() == (int) Math.round(pto.getX()*this.m+this.b);
    }
    
    public Recta perpendicularEn(Punto p){
        double nvoM = -1/this.m;
        double nvoB = p.getY()-nvoM*p.getX();
        return new Recta(nvoM, nvoB);
    }
    
    
}
