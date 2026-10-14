package net.bouroumana.calculator.view;

import java.util.List;


public interface CalculatorGUIInterface {
    void affiche();
    void change(String accu);
    void change(List<Double> stackData);
}
