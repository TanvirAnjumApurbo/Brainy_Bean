package org.example.brainybean.splash;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.brainybean.Login.Login;

public class Splash extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load the image from the resources folder
        Image splashImage = new Image(getClass().getResource("/org/example/brainybean/icon/splash.png").toExternalForm());
        ImageView imageView = new ImageView(splashImage);

        // Bind the ImageView size to the Scene size
        imageView.fitWidthProperty().bind(primaryStage.widthProperty());
        imageView.fitHeightProperty().bind(primaryStage.heightProperty());
        imageView.setPreserveRatio(true);

        // Create a layout and add the ImageView
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 700, 350);  // Set the initial scene size

        // Set the stage to be undecorated
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setX(350); // Set the initial X position of the stage
        primaryStage.setY(200); // Set the initial Y position of the stage
        primaryStage.show();

        // Close the splash screen after 5 seconds and proceed to the main application
        new Thread(() -> {
            try {
                Thread.sleep(5000); // Wait for 5 seconds
                // After 5 seconds, show the next screen
                javafx.application.Platform.runLater(() -> {
                    primaryStage.close();
                    // Launch the main application (Login/Registration screen)
                    launchMainApplication();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void launchMainApplication() {
        // Load the Login or Registration screen here
        Login login = new Login();
        Stage loginStage = new Stage();
        try {
            login.start(loginStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}