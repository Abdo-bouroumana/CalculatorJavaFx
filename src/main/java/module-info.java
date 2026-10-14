module net.bouroumana.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.bouroumana.calculator to javafx.fxml;
    exports net.bouroumana.calculator;
}