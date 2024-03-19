package com.nhnacademy;

import java.util.logging.Logger;
import java.util.logging.LogManager;


/** 유리수
 * @author xtra
 */
public class Rational {
    // 분자
    private int numerator;
    // 분모
    private int denominator;

    Logger logger = Logger.getLogger(Rational.class.getName());
    
    /**
     * 정수를 받아서 생성
     * @param n 정수
     */
    public Rational(int n){
        numerator = n;
        denominator = 1;
        logger.info(String.format("new rational : [%d/%d]", numerator, denominator));

    }
    /**
     * 분수의 분모와 분자를 받아서 생성
     * @param numerator     분자(정수)
     * @param denominator   분모(정수)
     * throw new ArithmeticException 분모가 0인경우
     * g    최대공약수
     */
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
    /**
     * 다른 객체를 받아서 생성
     * @param other     다른객체
     */
    public Rational(Rational other){
        this.numerator = other.getNumerator();
        this.denominator = other.getdenominator();
    }

    /**
     * 
     * @return 객체의 분자 값을 반환
     */
    int getNumerator(){
        return numerator;
    }

    /**
     * 
     * @return 객체의 분모 값을 반환
     */
    int getdenominator(){
        return denominator;
    }

    /**
     * 출력을 임의의 형식으로 오버라이딩하여 출력
     */
    @Override
    public String toString(){
        if (getdenominator() == 1){
            return "[" + getNumerator() + "]";
        }
        else {
            return "[" + getNumerator() + "/" + getdenominator() + "]";
        }
    }
    /**
     * 현재 객체와 다른 객체가 가지고 있는 값이 같은지 비교
     */
    @Override
    public boolean equals(Object other){
        return (other instanceof Rational)
                && (getNumerator() == ((Rational) other).getNumerator())
                && (getdenominator() == ((Rational) other).getNumerator());
    }

    /**
     * 두 유리수의 덧셈
     * @param x     유리수 객체
     * @param y     유리수 객체
     * @return      두 유리수의 덧셈 값을 반환
     */
    public static Rational add(Rational x, Rational y){
        return new Rational(
        x.getNumerator() * y.getdenominator() + x.getdenominator() * y.getNumerator(),
        x.getdenominator() * y.getdenominator());
   
        }

    /**
     * 두 유리수의 뺄셈
     * @param x     유리수 객체
     * @param y     유리수 개체
     * @return      두 유리수의 뺄셈 값을 반환
     */
    public static Rational subtraction(Rational x, Rational y){
        return new Rational(
        x.getNumerator() * y.getdenominator() - x.getdenominator() * y.getNumerator(),
        x.getdenominator() * y.getdenominator());
    }

    /**
     * 두 유리수의 곱셈
     * @param x     유리수 객체
     * @param y     유리수 객체
     * @return      두 유리수의 뺄셈 값을 반환
     */
    public static Rational multiplication(Rational x, Rational y){
        return new Rational(
            x.getNumerator() * y.getNumerator(), 
            x.getdenominator() * y.getdenominator());
    }

    /**
     * 두 유리수의 나눗셈
     * @param x     유리수 객체
     * @param y     유리수 객체
     * @return      두 유리수의 나눗셈 값을 반환
     */
    public static Rational division(Rational x, Rational y){
        return new Rational(
            x.getNumerator() * y.getdenominator(),
            x.getdenominator() * y.getNumerator());
    }

    /**
     * 분모와 분자의 값을 바꾸는 메서드
     * @return      분모와 분자의 값이 바뀐 유리수
     */
    public Rational inverse(){
        return new Rational(getdenominator(), getNumerator());
    }


    /**
     * 유리수를 음수로 변환해주는 메서드
     * @return  음수로 변환된 유리수
     */
    public Rational oppsite(){
        return new Rational(-getNumerator(), getdenominator());

    }
    
    /**
     * 유리수를 n제곱 해주는 메서드
     * @param n     유리수를 곱할 횟수
     * @return      n제곱된 유리수 값
     */
    public Rational pow(int n){
        if (n > 1){
            return new Rational(pow(n-1).getNumerator() * getNumerator(), pow(n-1).getdenominator() * getdenominator());
        }
        else{
            return new Rational(getNumerator(), getdenominator());
        }
            
    }
 
    /**
     * 두 유리수의 분모값의 최대공약수를 구하는 메서드
     * @param x     분모값(정수)
     * @param y     분모값(정수)
     * @return      두 분모 값의 최대공약수(정수)
     */
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
