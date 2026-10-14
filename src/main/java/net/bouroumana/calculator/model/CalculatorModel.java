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

    @Override
    public void drop(){
        if(memory.isEmpty()) return;
        if(accu != 0) accu = 0;
        else memory.pop();
    }

    @Override
    public void swap(){
        if(memory.isEmpty()) return;
        Double temp = memory.pop();
        Double temp2 = memory.pop();
        memory.push(temp2);
        memory.push(temp);
    }

    @Override
    public void clear(){
        memory.clear();
        accu = 0;
    }

}