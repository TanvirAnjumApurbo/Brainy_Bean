module org.example.brainybean {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.sql;

    opens org.example.brainybean to javafx.fxml;
    opens org.example.brainybean.splash to javafx.fxml;
    opens org.example.brainybean.Login to javafx.fxml;
    opens org.example.brainybean.dashboard to javafx.fxml;

    exports org.example.brainybean.splash;
    exports org.example.brainybean.Login;
    exports org.example.brainybean;
    exports org.example.brainybean.dashboard;
}