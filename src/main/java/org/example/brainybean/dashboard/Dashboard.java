package org.example.brainybean.dashboard;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Dashboard extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Logo box at the top
        HBox logoBox = new HBox();
        logoBox.setPadding(new Insets(20));
        logoBox.setStyle("-fx-background-color: #ffffff;");
        logoBox.setAlignment(Pos.CENTER_LEFT);

        ImageView logoIcon = createIcon("/org/example/brainybean/icon/Logo.png");
        logoIcon.setFitWidth(50);
        logoIcon.setFitHeight(50);

        TextField searchBar = new TextField();
        searchBar.setPromptText("Search...");
        searchBar.setStyle("-fx-background-radius: 15px;");
        searchBar.setPrefWidth(300);

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        Button createQuizButton = new Button("Create Quiz");
        createQuizButton.setStyle("-fx-background-color: #3f7afd; -fx-text-fill: white; -fx-background-radius: 15px;");
        createQuizButton.setFont(Font.font("segoe ui", FontWeight.BOLD, 14));

        Label greetingLabel = new Label("Hello, Username!");
        greetingLabel.setFont(Font.font("segoe ui", FontWeight.NORMAL, 16));

        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        logoBox.getChildren().addAll(logoIcon, spacer1, searchBar, spacer2, createQuizButton, greetingLabel);

        // Left sliding pane
        VBox leftPane = new VBox(18);
        leftPane.setPadding(new Insets(20));
        leftPane.setStyle("-fx-background-color: rgba(66,115,213,0.21);");
        leftPane.setPrefWidth(60);
        leftPane.setPrefHeight(Double.MAX_VALUE);
        leftPane.setAlignment(Pos.TOP_CENTER);

        // Icons for the left pane
        ImageView homeIcon = createIcon("/org/example/brainybean/icon/Logo.png");
        ImageView leaderboardIcon = createIcon("/org/example/brainybean/icon/Logo.png");
        ImageView profileIcon = createIcon("/org/example/brainybean/icon/Logo.png");
        ImageView logoutIcon = createIcon("/org/example/brainybean/icon/Logo.png");

        leftPane.getChildren().addAll(homeIcon, leaderboardIcon, profileIcon, logoutIcon);

        // Sliding functionality
        leftPane.setOnMouseEntered(event -> {
            leftPane.setPrefWidth(200);
            leftPane.getChildren().clear();
            leftPane.getChildren().addAll(
                    createLabeledIcon("Home", homeIcon),
                    createLabeledIcon("Leaderboard", leaderboardIcon),
                    createLabeledIcon("Profile", profileIcon),
                    createLabeledIcon("Logout", logoutIcon));
        });

        leftPane.setOnMouseExited(event -> {
            leftPane.setPrefWidth(60);
            leftPane.getChildren().clear();
            leftPane.getChildren().addAll(homeIcon, leaderboardIcon, profileIcon, logoutIcon);
        });

        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(logoBox);
        mainLayout.setLeft(leftPane);

        Scene scene = new Scene(mainLayout, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BrainyBean");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private ImageView createIcon(String path) {
        Image image = new Image(getClass().getResource(path).toExternalForm());
        ImageView icon = new ImageView(image);
        icon.setFitWidth(40);
        icon.setFitHeight(40);
        return icon;
    }

    private HBox createLabeledIcon(String label, ImageView icon) {
        Label textLabel = new Label(label);
        textLabel.setFont(Font.font("segoe ui", FontWeight.NORMAL, 14));
        textLabel.setTextFill(Color.WHITE);
        HBox hbox = new HBox(10, icon, textLabel);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}