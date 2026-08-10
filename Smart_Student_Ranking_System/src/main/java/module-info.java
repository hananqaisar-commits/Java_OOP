module src.smart_student_ranking_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.smart_student_ranking_system to javafx.fxml;
    exports src.smart_student_ranking_system;
}