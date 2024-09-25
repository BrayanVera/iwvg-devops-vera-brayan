package es.upm.miw.iwvg_devops.code;

import java.util.Objects;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return numerator < denominator;
    }

    public boolean isImproper() {
        return numerator >= denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        return (double) numerator / denominator == (double) fraction.numerator / fraction.denominator;
    }

    public Fraction add(Fraction fraction) {
        int newNumerator = numerator * fraction.denominator + fraction.numerator * denominator;
        int newDenominator = denominator * fraction.denominator;

        int gcdValue = calculateGreatestCommonDivisor(newNumerator, newDenominator);
        return new Fraction(newNumerator / gcdValue, newDenominator / gcdValue);
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two integers.
     * This method uses the iterative Euclidean algorithm to find the GCD.
     */
    private int calculateGreatestCommonDivisor(int firstNumber, int secondNumber) {

        if (secondNumber == 0) {
            return firstNumber;
        }

        int temporaryNumber = secondNumber;
        secondNumber = firstNumber % secondNumber;

        return calculateGreatestCommonDivisor(temporaryNumber, secondNumber);
    }

    public Fraction multiply(Fraction fraction) {
        int newNumerator = numerator * fraction.numerator;
        int newDenominator = denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction fraction) {
        if (fraction.numerator == 0 || denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        int newNumerator = numerator * fraction.denominator;
        int newDenominator = denominator * fraction.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
