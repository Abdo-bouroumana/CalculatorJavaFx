package net.bouroumana.calculator;

import net.bouroumana.calculator.controller.CalculatorControler;
import net.bouroumana.calculator.model.CalculatorModel;
import net.bouroumana.calculator.view.CalculatorConsole;

// Main program that tests the model through the full MVC chain with a console view
public class Calculette {

    public static void main(String[] args) {
        CalculatorControler controler = new CalculatorControler();
        CalculatorModel model = new CalculatorModel(controler);
        CalculatorConsole view = new CalculatorConsole();
        controler.setModel(model);
        controler.setView(view);
        view.affiche();

        // 3*(2+5*(4+7)) in RPN: 3 push 2 push 5 push 4 push 7 + * + *  -> 171
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

        // 10 push 4 -  -> 6 ; then 3 /  -> 2
        controler.onClear();
        controler.onDigit("1"); controler.onDigit("0"); controler.onPush();
        controler.onDigit("4");
        controler.onSubtract();
        controler.onDigit("3");
        controler.onDivide();
        System.out.println("Expected 2.0");
    }
}
