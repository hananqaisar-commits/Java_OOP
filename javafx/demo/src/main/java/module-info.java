module src.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens src.demo to javafx.fxml;
    exports src.demo;
}