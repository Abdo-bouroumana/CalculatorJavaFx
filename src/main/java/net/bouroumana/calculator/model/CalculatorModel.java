package net.bouroumana.calculator.model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private Double accu;
    private Stack<Double> memory = new Stack<>();


    // Clicking Enter (0 can be pushed)
    @Override
    public void push(){
        memory.push(accu);
        accu = null;
    }

    @Override
    public void pop(){
        if(memory.isEmpty()) return;
        accu = memory.pop();
    }

    @Override
    public void drop(){
        if(memory.isEmpty()) return;
//        if(accu != 0) accu = 0;
        memory.pop();
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
        accu = null;
    }

    @Override
    public void add(){
        if(memory.isEmpty()) return; // notify the user that the stack is empty
        if(accu == null && memory.size() >= 2){
            accu = memory.pop() + memory.pop();
        }else{
            accu += memory.pop();
        }
//        memory.push(accu);
    }

    @Override
    public void subtract(){
        if(memory.isEmpty()) return;
        if(accu == null && memory.size() >= 2){
            double a =  memory.pop();
            double b = memory.pop();
            accu = b - a;
        }else{
            accu -= memory.pop();
        }
        memory.push(accu);
    }

    @Override
    public void multiply(){
        if(memory.isEmpty()) return;
        if(accu == null && memory.size() >= 2){
            accu = memory.pop() * memory.pop();
        }else{
            accu *= memory.pop();
        }
        memory.push(accu);
    }





}