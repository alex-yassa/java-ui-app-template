package pl.torun.twerdenergoplus.ui.template;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("TWERD ENERGO - PLUS ui application template");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResource("/img/TwerEnergoPlusLogo.png").toExternalForm())); // Set the application icon here
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}