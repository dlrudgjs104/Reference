package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
        try{
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(100, 25);

            System.out.println("r1: " + r1 + "  r2: " + r2);
            System.out.println("r1 + r2: " + Rational.add(r1, r2));
            System.out.println("r1 - r2: " + Rational.subtraction(r1, r2));
            System.out.println("r1 * r2: " + Rational.multiplication(r1, r2));
            System.out.println("r1 / r2: " + Rational.division(r1, r2));
            System.out.println("r1 inverse: " + r1.inverse());
            System.out.println("pow(r1, n): " + r1.pow(2));

        }catch (ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}                       