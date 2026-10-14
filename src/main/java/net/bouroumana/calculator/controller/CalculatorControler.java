package net.bouroumana.calculator.controller;

import java.util.List;
import net.bouroumana.calculator.model.*;
import net.bouroumana.calculator.view.*;

public class CalculatorControler implements CalculatorControlerInterface {

	private CalculatorGUIInterface view;
	private CalculatorModelInterface model;
	
	
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

}
