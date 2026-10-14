package net.bouroumana.calculator.model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private double accu;
    private Stack<Double> memory = new Stack<>();


    // Clicking Enter
    @Override
    public void push(){
        memory.push(accu);
        accu = 0;
    }

    @Override
    public void pop(){
        if(memory.isEmpty()) return;
        accu = memory.pop();
    }


}