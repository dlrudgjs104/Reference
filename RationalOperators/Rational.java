public class Rational {
    int numerator;
    int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Rational 객체 더하기
    public int[] plus(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        int g = gCD(newNumerator, newDenominator);

        newNumerator /= g;
        newDenominator /= g;
        return new int[] {newNumerator, newDenominator};
    }

    // Rational 객체 곱하기
    public int[] multiply(Rational other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        int g = gCD(newNumerator, newDenominator);

        newNumerator /= g;
        newDenominator /= g;
        return new int[] {newNumerator, newDenominator};
    }

    public int gCD(int m, int n){
        if (n == 0){
            return m;
        }
        else{
            return gCD(n, m % n);
        }
    }
 
    
}

class Test{
    public static void main(String[] args) {
        Rational rational1 = new Rational(2, 7);
        Rational rational2 = new Rational(2, 4);

        // 객체끼리 더하기
        int[] plusResult = rational1.plus(rational2);
        System.out.println("Plus Result: " + plusResult[0] + " " + plusResult[1]);

        // 객체끼리 곱하기
        int[] multiplyResult = rational1.multiply(rational2);
        System.out.println("Multiply Result: " + multiplyResult[0] + " " + multiplyResult[1]);   
    }
}
