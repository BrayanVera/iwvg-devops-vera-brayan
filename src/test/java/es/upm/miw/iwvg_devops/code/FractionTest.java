package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(fraction.getNumerator());
        assertNotNull(fraction.getDenominator());
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testCustomConstructor() {
        Fraction customFraction = new Fraction(3, 4);

        assertEquals(3, customFraction.getNumerator());
        assertEquals(4, customFraction.getDenominator());
    }

    @Test
    void testDecimalConversion() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(0.5, fraction.decimal(), 0.001);
    }

    @Test
    void testToStringMethod() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals("Fraction{numerator=1, denominator=2}", fraction.toString());
    }

    @Test
    void testSetterMethods() {
        fraction.setNumerator(3);
        fraction.setDenominator(4);

        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testIsProper() {
        Fraction f = new Fraction(1, 2);
        assertTrue(f.isProper());
        assertFalse(f.isImproper());
    }

    @Test
    void testIsImproper() {
        Fraction f = new Fraction(2, 1);
        assertTrue(f.isImproper());
        assertFalse(f.isProper());
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        assertTrue(f1.isEquivalent(f2));

        Fraction f3 = new Fraction(1, 3);
        assertFalse(f1.isEquivalent(f3));
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction expected = new Fraction(5, 6);
        assertEquals(expected, f1.add(f2));
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction expected = new Fraction(1, 6);
        assertEquals(expected, f1.multiply(f2));
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction expected = new Fraction(3, 2);
        assertEquals(expected, f1.divide(f2));
    }
}
