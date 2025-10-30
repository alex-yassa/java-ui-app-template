module ui.template {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.torun.twerdenergoplus.ui.template to javafx.fxml, javafx.graphics;
    exports pl.torun.twerdenergoplus.ui.template;
}
