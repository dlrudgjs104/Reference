package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameter;

public class TestRational {

    @Test
    void testvalidConstructor(){
        assertDoesNotThrow(() -> { 
            new Rational(1, 2);
        });
    }

    @Test
    void testInvalidConstructor(){
        assertThrowsExactly(ArithmeticException.class, () -> {
            new Rational(1,0);

        });
        
    }

    @ParameterizedTest
    @MethodSource("validConstructorProvider")
    void testValidConstructor2(int numerator, int denominator){
        assertDoesNotThrow(() -> {
            new Rational(numerator, denominator);
        });
    }
    
    static Stream<Arguments> validConstructorProvider(){
        return Stream.of(
            Arguments.arguments(1,2),
            Arguments.arguments(100,12),
            Arguments.arguments(12,45),
            Arguments.arguments(-10,-4));

            
    }

    @Test
    void testAdd(){
        Rational r1 = new Rational(Integer.MAX_VALUE, 2);
        Rational r2 = new Rational(Integer.MAX_VALUE, 3);

        Rational result = Rational.add(r1, r2);

        long numerator = (long)r1.getNumerator() + r2.getdenominator() + (long)r1.getdenominator() * r2.getNumerator();
        int denominator  = r1.getdenominator() * r2.getdenominator();

        System.out.println(" + reslut");
    }
}

