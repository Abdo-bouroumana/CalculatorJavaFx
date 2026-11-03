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
	
	
	// ===== Callbacks from the model (model → view) =====
	@Override
	public void change(String accu) {
		if (view != null) {			
			view.change(accu);
		}
		
	}

	@Override
	public void change(List<Double> stackData) {
		if (view != null) {
			
			view.change(stackData);
		}
	}
	
	 // ===== PART D: taking orders (view → model) =====
    public void onDigit(String digit) {
    	// TO DO: Check here for valid input, put everything input var and check.
        if (digit.equals(".") && input.contains(".")) return;
        // starting a new number: push the previous result (if any) so it is not overwritten
        if (input.isEmpty()) model.push();
        if (digit.equals(".") && input.isEmpty()) input = "0";
        input += digit;
        model.setAccu(Double.parseDouble(input));
    }

    public void onPush() { model.push(); input = ""; }
    public void onAdd()  { model.add();  input = ""; }
    public void onSubtract() { model.subtract(); input = ""; }
    public void onMultiply() { model.multiply(); input = ""; }
    public void onDivide() { model.divide(); input = ""; }
    public void onOpposite() {
        if (input.isEmpty()) { model.opposite(); return; }
        // while typing, just flip the sign of the number being typed
        input = input.startsWith("-") ? input.substring(1) : "-" + input;
        model.setAccu(Double.parseDouble(input));
    }
    public void onPop() { model.pop(); input = ""; }
    public void onDrop() { model.drop(); input = ""; }
    public void onSwap() { model.swap(); input = ""; }
    public void onClear() { model.clear(); input = ""; }

}
