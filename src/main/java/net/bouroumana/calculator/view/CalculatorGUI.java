package net.bouroumana.calculator.view;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import net.bouroumana.calculator.controller.CalculatorControler;

public class CalculatorGUI extends Scene implements CalculatorGUIInterface {

    private static final int STACK_LINES = 4;

    private final CalculatorControler controler;
    private final Label[] stackLabels = new Label[STACK_LINES];
    private final Label accuLabel = new Label();

    public CalculatorGUI(CalculatorControler controler) {
        super(new VBox(5));
        this.controler = controler;

        VBox root = (VBox) getRoot();
        root.setPadding(new Insets(10));

        for (int i = 0; i < STACK_LINES; i++) {
            stackLabels[i] = displayLabel();
            root.getChildren().add(stackLabels[i]);
        }
        displayLabel(accuLabel);
        accuLabel.setStyle(accuLabel.getStyle() + "-fx-font-weight: bold;");
        root.getChildren().add(accuLabel);

        GridPane keys = new GridPane();
        keys.setHgap(5);
        keys.setVgap(5);
        keys.setPadding(new Insets(10, 0, 0, 0));

        String[][] digits = { {"7", "8", "9"}, {"4", "5", "6"}, {"1", "2", "3"} };
        for (int row = 0; row < digits.length; row++) {
            for (int col = 0; col < 3; col++) {
                String d = digits[row][col];
                keys.add(button(d, () -> controler.onDigit(d)), col, row);
            }
        }
        keys.add(button("0", () -> controler.onDigit("0")), 0, 3);
        keys.add(button(",", () -> controler.onDigit(".")), 1, 3);
        keys.add(button("+/-", controler::onOpposite), 2, 3);

        keys.add(button("+", controler::onAdd), 3, 0);
        keys.add(button("-", controler::onSubtract), 3, 1);
        keys.add(button("*", controler::onMultiply), 3, 2);
        keys.add(button("/", controler::onDivide), 3, 3);

        keys.add(button("push", controler::onPush), 0, 4);
        keys.add(button("pop", controler::onPop), 1, 4);
        keys.add(button("drop", controler::onDrop), 2, 4);
        keys.add(button("<>", controler::onSwap), 3, 4);
        Button clear = button("clear", controler::onClear);
        clear.setMaxWidth(Double.MAX_VALUE);
        keys.add(clear, 0, 5, 4, 1);

        root.getChildren().add(keys);
    }

    private Label displayLabel() {
        return displayLabel(new Label());
    }

    private Label displayLabel(Label label) {
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setPadding(new Insets(4, 8, 4, 8));
        label.setMinHeight(28);
        label.setStyle("-fx-border-color: #b0b0b0; -fx-background-color: #f4f4f4; -fx-font-size: 14;");
        return label;
    }

    private Button button(String text, Runnable action) {
        Button b = new Button(text);
        b.setPrefSize(60, 35);
        b.setOnAction(e -> action.run());
        return b;
    }

    @Override
    public void affiche() {
    }

    @Override
    public void change(String accu) {
        accuLabel.setText(accu);
    }

    @Override
    public void change(List<Double> stackData) {
        int size = stackData.size();
        for (int i = 0; i < STACK_LINES; i++) {
            int index = size - STACK_LINES + i;
            stackLabels[i].setText(index >= 0 ? stackData.get(index).toString() : "");
        }
    }
}
