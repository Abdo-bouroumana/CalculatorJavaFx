package net.bouroumana.calculator.controller;

import java.util.List;
import net.bouroumana.calculator.model.*;
import net.bouroumana.calculator.view.*;

public class CalculatorControler implements CalculatorControlerInterface {

	private CalculatorGUIInterface view;
	private CalculatorModelInterface model;
	private String input = "";    
	
	
	public void setModel(CalculatorModelInterface model) {
		this.model = model;
	}
	
	public void setView(CalculatorGUIInterface view) {
		this.view = view;
	}
	
	
	@Override
	public void change(String accu) {
		// TODO Auto-generated method stub
		if (view != null) {			
			view.change(accu);
		}
		
	}

	@Override
	public void change(List<Double> stackData) {
		// TODO Auto-generated method stub
		if (view != null) {
			
			view.change(stackData);
		}
	}
	
	 // ===== PART D: taking orders (view → model) =====
    public void onDigit(String digit) {
    	// TO DO: Check here for valid input, put everything input var and check.
        if (digit.equals(".") && input.contains(".")) return;
        input += digit;
        model.setAccu(Double.parseDouble(input));
    }

    public void onPush() { model.push(); input = ""; }
    public void onAdd()  { model.add();  input = ""; }
    public void onMultiply() { model.subtract(); input = ""; }
    public void onSubstract() { model.subtract(); input = ""; }
    public void onSubstract() { model.subtract(); input = ""; }
    public void onSubstract() { model.subtract(); input = ""; }
    public void onSubstract() { model.subtract(); input = ""; }
    public void onSubstract() { model.subtract(); input = ""; }
    public void onSubstract() { model.subtract(); input = ""; }
    public void onSubstract() { model.subtract(); input = ""; }
    
    
    // ... same pattern for the other buttons
//    void add();
//    void subtract();
//    void multiply();
//    void divide();
//    void opposite();
//    void push();
//    void pop();
//    void drop();
//    void swap();
//    void clear();
//    void setAccu(Double accu);

}
