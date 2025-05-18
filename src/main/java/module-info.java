module com.example.esirunv2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.esirunv2 to javafx.fxml;
    exports com.example.esirunv2;
}