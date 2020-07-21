package geometria;

public class Punto{

    private int x;
    private int y;
    
    public Punto(){
        this.x = 0; this.y=0;
    }
    
     public Punto(int x, int y){
        this.x = x; this.y=y;
    }
    
    public Punto mover(int deltaX, int deltaY){
        return new Punto(this.x+deltaX, this.y+deltaY);        
    }
    
    public int getX(){return this.x;}
    
    public int getY(){return this.y;}
    
    public double distanciaCon(Punto pto){
        int dx = this.x - pto.getX();
        int dy = this.y - pto.getY();
        return Math.sqrt(dx*dx+dy*dy);
    }

    public Punto rotar(int alfa) {
        alfa %= 360;
        System.out.println(Math.round(Math.cos(alfa)));
        int nx = (int) ((Math.round(Math.cos(alfa))) * this.x - (Math.round(Math.sin(alfa))) * this.y);
        int ny = (int) ((Math.round(Math.sin(alfa))) * this.x + (Math.round(Math.cos(alfa))) * this.y);
        return new Punto(nx, ny);
    }
    
    public Punto puntoEntre(Punto p, double razon){
        return new Punto( (int)Math.round((this.x+razon*p.getX())/(razon+1)),
                          (int)Math.round((this.y+razon*p.getY())/(razon+1)));
    }
    
    public Punto puntoMedioCon (Punto p){
        return this.puntoEntre(p,1.0);
    }
    
    public String toString(){
        return "("+this.getX()+", "+this.getY()+")";
    }

}
