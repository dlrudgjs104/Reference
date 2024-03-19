package com.nhnacademy;
public class Rational {
    private int numerator;
    private int denominator;

    public Rational(){

    }

    public Rational(int n){
        numerator = n;
        denominator = 1;
    }

    public Rational(int numerator, int denominator){
        if(denominator == 0){
            throw new ArithmeticException();
        }
        
        if(denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }

        int g = gcd(Math.abs(numerator), Math.abs(denominator));

        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public Rational(Rational other){
        this.numerator = other.getNumerator();
        this.denominator = other.getdenominator();
    }

    int getNumerator(){
        return numerator;
    }

    int getdenominator(){
        return denominator;
    }

    @Override
    public String toString(){
        if (getdenominator() == 1){
            return "[" + getNumerator() + "]";
        }
        else {
            return "[" + getNumerator() + "/" + getdenominator() + "]";
        }
    }

    @Override
    public boolean equals(Object other){
        return (other instanceof Rational)
                && (getNumerator() == ((Rational) other).getNumerator())
                && (getdenominator() == ((Rational) other).getNumerator());
    }

    public static Rational add(Rational x, Rational y){
        return new Rational(
        x.getNumerator() * y.getdenominator() + x.getdenominator() * y.getNumerator(),
        x.getdenominator() * y.getdenominator());
   
        }

    public static Rational subtraction(Rational x, Rational y){
        return new Rational(
        x.getNumerator() * y.getdenominator() - x.getdenominator() * y.getNumerator(),
        x.getdenominator() * y.getdenominator());
    }

    public static Rational multiplication(Rational x, Rational y){
        return new Rational(
            x.getNumerator() * y.getNumerator(), 
            x.getdenominator() * y.getdenominator());
    }

    public static Rational division(Rational x, Rational y){
        return new Rational(
            x.getNumerator() * y.getdenominator(),
            x.getdenominator() * y.getNumerator());
    }

    public Rational inverse(){
        return new Rational(getdenominator(), getNumerator());
    }

    public Rational oppsite(){
        return new Rational(-getNumerator(), getdenominator());

    }
    
    public Rational pow(int n){
        if (n > 1){
            return new Rational(pow(n-1).getNumerator() * getNumerator(), pow(n-1).getdenominator() * getdenominator());
        }
        else{
            return new Rational(getNumerator(), getdenominator());
        }
            
    }
 
    int gcd(int x, int y){
        if((x < 0) || (y < 0)){
            throw new ArithmeticException();
        }

        if(y == 0){
            return x;
        }

        return gcd(y, x % y);
    }
}
