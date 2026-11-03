package net.bouroumana.calculator.view;

import java.util.List;

// Minimal view that prints the model state in the console (used to test MVC before the GUI exists)
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
