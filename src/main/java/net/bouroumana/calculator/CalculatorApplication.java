package net.bouroumana.calculator;

import javafx.application.Application;
import javafx.stage.Stage;
import net.bouroumana.calculator.controller.CalculatorControler;
import net.bouroumana.calculator.model.CalculatorModel;
import net.bouroumana.calculator.view.CalculatorGUI;

public class CalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        CalculatorControler controler = new CalculatorControler();
        CalculatorModel model = new CalculatorModel(controler);
        CalculatorGUI gui = new CalculatorGUI(controler);
        controler.setModel(model);
        controler.setView(gui);
        gui.affiche();

        stage.setTitle("Ma calculette");
        stage.setScene(gui);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
