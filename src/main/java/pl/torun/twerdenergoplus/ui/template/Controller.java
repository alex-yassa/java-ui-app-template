package pl.torun.twerdenergoplus.ui.template;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button button;

    @FXML
    private void handleButtonClick() {
        System.out.println("Button clicked!");
    }
}
