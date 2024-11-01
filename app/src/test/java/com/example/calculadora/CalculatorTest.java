package com.example.calculadora;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba para la clase Calculator.
 *
 * @author María
 * @version 1.0
 * @since 01-11-2024
 */
public class CalculatorTest {
    private final Calculator calc = new Calculator();

    /**
     * Test para comprobar la suma de 5+3.
     */
    @Test
    public void testAdd2Operands() {
        double total = calc.calculate("5+3");
        assertEquals("X + Y operations not working correctly", 8, total);
        //The message here is displayed if the test fails
    }

    /**
     * Test para comprobar la suma de 4+3+1.
     */
    @Test
    public void testAdd1Operands() {
        double total = calc.calculate("4+3+1");
        assertEquals("X + Y operations not working correctly", 8, total);
        //The message here is displayed if the test fails
    }

    /**
     * Test para comprobar la multiplicación de 4*2.
     */
    @Test
    public void testMult2Operands() {
        double total = calc.calculate("4*2");
        assertEquals("X + Y operations not working correctly", 8, total);
        //The message here is displayed if the test fails
    }


    /**
     * Test para comprobar la multiplicación de 1*2*8.
     */
    @Test
    public void testMult3Operands() {
        double total = calc.calculate("1*2*8");
        assertEquals("X + Y operations not working correctly", 16, total, 0.001);
        //The message here is displayed if the test fails
    }

    /**
     * Test para comprobar la mezcla entre la multiplicación y la suma de 2*2+3.
     */
    @Test
    public void testMultAndAdd() {
        double total = calc.calculate("2*2+3");
        assertEquals("X + Y operations not working correctly", 7, total);
        //The message here is displayed if the test fails
    }

    /**
     * Test para comprobar la mezcla entre la suma y la multiplicación de 3+2*2.
     */
    @Test
    public void testAddAndMult() {
        double total = calc.calculate("2*2+3");
        assertEquals("X + Y operations not working correctly", 7, total);
        //The message here is displayed if the test fails
    }

    /**
     * Test para comprobar la multiplicación de 2.2*5.
     */
    @Test
    public void testMultFlotantes() {
        double total = calc.calculate("2.2*5");
        assertEquals("X + Y operations not working correctly", 11, total, 0.001); //El tercer valor del assertEquals es el margen de error permitido para números flotantes
        //The message here is displayed if the test fails
    }
}
