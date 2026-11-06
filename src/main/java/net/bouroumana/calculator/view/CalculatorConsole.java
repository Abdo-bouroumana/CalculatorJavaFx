package net.bouroumana.calculator.view;

import java.util.List;

public class CalculatorConsole implements CalculatorGUIInterface {

    @Override
    public void affiche() {
        System.out.println("=== Calculator (console) ===");
    }

    @Override
    public void change(String accu) {
        System.out.println("accu  : " + accu);
    }

    @Override
    public void change(List<Double> stackData) {
        System.out.println("stack : " + stackData);
    }
}
