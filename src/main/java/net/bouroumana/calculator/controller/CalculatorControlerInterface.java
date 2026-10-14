package net.bouroumana.calculator.controller;

import java.util.List;

public interface CalculatorControlerInterface {
    void change(String accu);
    void change(List<Double> stackData);
}