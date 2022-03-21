module edu.ntnu.idatt1002.sysdev_k1_05_ets {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens edu.ntnu.idatt1002.sysdev_k1_05_ets to javafx.fxml;
    exports edu.ntnu.idatt1002.sysdev_k1_05_ets;
}