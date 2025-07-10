module com.example.karaoke_poprock {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.sql;
    requires java.management;

    opens com.example.karaoke_poprock to javafx.fxml;
    exports com.example.karaoke_poprock;
}