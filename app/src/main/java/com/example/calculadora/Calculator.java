package com.example.calculadora;

/**
 * @author María
 * @version 1.0
 * @since 01-11-2024
 */

/**
 * La clase Calculator contiene un constructor vacío y un método recursivo para las expresiones de la calculadora.
 * Nos va a permitir realizar cálculos matemáticos simples.
 */
public class Calculator {

    /**
     * Constructor vacío para la clase Calculator.
     */
    public Calculator() {
    }

    /**
     * Calcula el resultado de una expresión matemática dada.
     *
     * @param expr La expresión matemática a evaluar. Puede contener los operadores: +, -, *, /.
     *             Se permite el uso de números decimales, que deben estar separados por un PUNTO.
     * @return El resultado de la evaluación de la expresión.
     */
    public double calculate(String expr) {
        //Reemplazar comas por puntos para que no me de -1 cuando pongo algún número decimal
        expr = expr.replace(",", ".");

        //Para las restas
        if (expr.contains("-")) {
            String[] parts = expr.split("(?<=\\d)(-)(?=\\d)", 2);
            return calculate(parts[0]) - calculate(parts[1]);
        }

        //Para las sumas
        if (expr.contains("+")) {
            String[] parts = expr.split("\\+", 2);
            return calculate(parts[0]) + calculate(parts[1]);
        }

        //Para las multiplicaciones
        if (expr.contains("*")) {
            String[] parts = expr.split("\\*", 2);
            return calculate(parts[0]) * calculate(parts[1]);
        }

        //Para las divisiones
        if (expr.contains("/")) {
            String[] parts = expr.split("/", 2);
            return calculate(parts[0]) / calculate(parts[1]);
        }

        //Si no hay operadores, convertimos la cadena en un número
        return Double.parseDouble(expr);
    }

}