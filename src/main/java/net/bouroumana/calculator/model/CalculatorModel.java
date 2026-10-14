package net.bouroumana.calculator.model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private double accu;
    private Stack<Double> memory = new Stack<>();

    @Override
    public void push() {
        memory.push(accu);
        accu = 0;
    }

    @Override
    public void add() {
        if (memory.isEmpty()) return;     // nothing to combine with
        accu = memory.pop() + accu;
    }

    // substract, multiply, divide, opposite, pop, drop, swap, clear...
}