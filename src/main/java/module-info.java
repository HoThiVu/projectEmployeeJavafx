module com.example.projectemployee {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.projectemployee to javafx.fxml;
    exports com.example.projectemployee;
}