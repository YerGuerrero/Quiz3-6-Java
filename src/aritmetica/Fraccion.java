package aritmetica;

public class Fraccion{
    
    private int numerador;
    private int denominador;
    
    public Fraccion(){
        this.numerador = 0;
        this.denominador = 1;
    }
    
    public Fraccion(int num, int den){
        if(den != 0){
            this.numerador= num;
            this.denominador = den;  
            simplificar();          
        }       
        // else throw ArithmeticException...
    }
    
    private void simplificar(){
            int g = gcd(numerador, denominador);
            this.numerador/=g;
            this.denominador/=g;
    }
    
    public int getNumerador(){return numerador;}
    public int getDenominador(){return denominador;}
    
    //Algoritmo de Euclides
    private int gcd(int a, int b){
        return b == 0? a: gcd(b, a%b);
    }
    
    public int intValue(){
        return this.numerador/this.denominador;
    }
    
    public double doubleValue(){
        return (1.0*this.numerador)/this.denominador;
    }
    
    public Fraccion multiplicar(int val){
        return new Fraccion(this.numerador*val, this.denominador);
    }
    
    public Fraccion multiplicar(Fraccion f){
        return new Fraccion(this.numerador*f.getNumerador(), this.denominador*f.getDenominador());
    }
    
    
    
    

}
