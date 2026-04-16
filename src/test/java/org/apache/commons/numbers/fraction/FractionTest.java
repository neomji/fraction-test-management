package org.apache.commons.numbers.fraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class FractionTest {
    
    private Fraction f1;
    private Fraction f2;
    
    @Before
    public void setUp() {
        f1 = Fraction.of(1, 2);
        f2 = Fraction.of(1, 3);
    }
    
    @Test
    public void testOf() {
        Fraction f = Fraction.of(1, 2);
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());
    }
    
    @Test
    public void testReduction() {
        Fraction f = Fraction.of(2, 4);
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());
    }
    
    @Test
    public void testAdd() {
        Fraction result = f1.add(f2);
        assertEquals(5, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }
    
    @Test
    public void testSubtract() {
        Fraction result = f1.subtract(f2);
        assertEquals(1, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }
    
    @Test
    public void testMultiply() {
        Fraction f = Fraction.of(2, 3);
        Fraction result = f1.multiply(f);
        assertEquals(1, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }
    
    @Test
    public void testToString() {
        assertEquals("1 / 2", f1.toString());
    }
    
    @Test
    public void testZeroDenominator() {
        try {
            Fraction.of(1, 0);
            fail("应该抛出异常");
        } catch (Exception e) {
            // 预期行为
        }
    }
}