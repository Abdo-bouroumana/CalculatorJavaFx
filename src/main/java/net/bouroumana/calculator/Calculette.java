package net.bouroumana.calculator;

import net.bouroumana.calculator.controller.CalculatorControler;
import net.bouroumana.calculator.model.CalculatorModel;
import net.bouroumana.calculator.view.CalculatorConsole;

public class Calculette {

    public static void main(String[] args) {
        CalculatorControler controler = new CalculatorControler();
        CalculatorModel model = new CalculatorModel(controler);
        CalculatorConsole view = new CalculatorConsole();
        controler.setModel(model);
        controler.setView(view);
        view.affiche();

        controler.onDigit("3"); controler.onPush();
        controler.onDigit("2"); controler.onPush();
        controler.onDigit("5"); controler.onPush();
        controler.onDigit("4"); controler.onPush();
        controler.onDigit("7");
        controler.onAdd();
        controler.onMultiply();
        controler.onAdd();
        controler.onMultiply();
        System.out.println("Expected 171.0");

        controler.onClear();
        controler.onDigit("1"); controler.onDigit("0"); controler.onPush();
        controler.onDigit("4");
        controler.onSubtract();
        controler.onDigit("3");
        controler.onDivide();
        System.out.println("Expected 2.0");
    }
}
