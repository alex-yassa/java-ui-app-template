package pl.torun.twerdenergoplus.ui.template;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("TWERD ENERGO - PLUS ui application template");
        primaryStage.setScene(scene);

        primaryStage.sizeToScene();

        primaryStage.getIcons().add(new Image(getClass().getResource("/img/TwerEnergoPlusLogo.png").toExternalForm()));

        primaryStage.show();

        Platform.runLater(() -> {
            Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

            double centerX = screenBounds.getMinX() + (screenBounds.getWidth() - primaryStage.getWidth()) / 2;
            double centerY = screenBounds.getMinY() + (screenBounds.getHeight() - primaryStage.getHeight()) / 2;

            primaryStage.setX(centerX);
            primaryStage.setY(centerY);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}