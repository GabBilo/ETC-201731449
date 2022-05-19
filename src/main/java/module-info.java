module com.example.etc201731449 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.etc201731449 to javafx.fxml;
    exports com.example.etc201731449;
}