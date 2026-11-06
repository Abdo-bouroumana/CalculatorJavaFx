package net.bouroumana.calculator.model;

import java.util.ArrayList;
import java.util.Stack;

import net.bouroumana.calculator.controller.CalculatorControlerInterface;

public class CalculatorModel implements CalculatorModelInterface {
    private Double accu = null;
    private Stack<Double> memory = new Stack<>();
    private CalculatorControlerInterface controler;

    public CalculatorModel(CalculatorControlerInterface controler) {
        this.controler = controler;
    }

    private void notifyChange() {
        if (controler == null) return;
        controler.change(accu == null ? "" : accu.toString());
        controler.change(new ArrayList<>(memory));
    }

    private boolean hasTwoOperands() {
        return (accu != null && memory.size() >= 1) || memory.size() >= 2;
    }

    private double secondOperand() {
        if (accu != null) {
            double value = accu;
            accu = null;
            return value;
        }
        return memory.pop();
    }

    @Override
    public void push(){
        if(accu == null) return;
        memory.push(accu);
        accu = null;
        notifyChange();
    }

    @Override
    public void pop(){
        if(memory.isEmpty()) return;
        accu = memory.pop();
        notifyChange();
    }

    @Override
    public void drop(){
        if(memory.isEmpty()) return;
        memory.pop();
        notifyChange();
    }

    @Override
    public void swap(){
        if(memory.size() < 2) return;
        Double temp = memory.pop();
        Double temp2 = memory.pop();
        memory.push(temp);
        memory.push(temp2);
        notifyChange();
    }

    @Override
    public void clear(){
        memory.clear();
        accu = null;
        notifyChange();
    }

    @Override
    public void add(){
        if(!hasTwoOperands()) return;
        double b = secondOperand();
        double a = memory.pop();
        accu = a + b;
        notifyChange();
    }

    @Override
    public void subtract(){
        if(!hasTwoOperands()) return;
        double b = secondOperand();
        double a = memory.pop();
        accu = a - b;
        notifyChange();
    }

    @Override
    public void multiply(){
        if(!hasTwoOperands()) return;
        double b = secondOperand();
        double a = memory.pop();
        accu = a * b;
        notifyChange();
    }

    @Override
    public void divide(){
        if(!hasTwoOperands()) return;
        double denominator = (accu != null) ? accu : memory.peek();
        if(denominator == 0.0) return;
        double b = secondOperand();
        double a = memory.pop();
        accu = a / b;
        notifyChange();
    }

    @Override
    public void opposite(){
        if(accu == null) return;
        accu = -accu;
        notifyChange();
    }

    @Override
    public void setAccu(Double accu){
        this.accu = accu;
        notifyChange();
    }
}
