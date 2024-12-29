package org.example.brainybean.Login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.brainybean.Con;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Application {

    private VBox rightPane;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // Left side: Logo section
        VBox leftPane = new VBox();
        leftPane.setAlignment(Pos.CENTER);
        leftPane.setPadding(new Insets(0));
        leftPane.setStyle("-fx-background-color: #3f7afd;");

        Image image = new Image(getClass().getResource("/org/example/brainybean/icon/Login.png").toExternalForm());
        ImageView logo = new ImageView(image);
        logo.setFitWidth(400);
        logo.setFitHeight(400);

        leftPane.getChildren().addAll(logo);

        rightPane = new VBox(15);
        rightPane.setPadding(new Insets(30));
        rightPane.setAlignment(Pos.CENTER_LEFT);
        rightPane.setPrefWidth(400);
        rightPane.setStyle("-fx-background-color: white;");

        // Welcome Text
        Text welcomeText = new Text("Welcome!");
        welcomeText.setFont(Font.font("Ubuntu", FontWeight.BOLD, 28));
        welcomeText.setStyle("-fx-fill: #3f7afd;");
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        welcomeText.setWrappingWidth(350);

        Text loginSubText = new Text("Login");
        loginSubText.setFont(Font.font("segoe ui", FontWeight.NORMAL, 18));
        loginSubText.setStyle("-fx-fill: gray;");
        loginSubText.setTextAlignment(TextAlignment.CENTER);
        loginSubText.setWrappingWidth(350);

        // Email Input
        Label emailLabel = new Label("Username or Email");
        emailLabel.setStyle("-fx-text-fill: #008CFF;");
        emailLabel.setFont(Font.font("segoe ui", FontWeight.NORMAL, 12));
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setPrefHeight(40);

        // Password Input
        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-text-fill: #008CFF;");
        passwordLabel.setFont(Font.font("segoe ui", FontWeight.NORMAL, 12));
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setPrefHeight(40);

        // Forgot Password
        Hyperlink forgotPassword = new Hyperlink("Forgot your password?");
        forgotPassword.setStyle("-fx-text-fill: gray; -fx-font-size: 12px;");

        // Login Button
        Button loginButton = new Button("Login");
        HBox loginButtonContainer = new HBox(loginButton);
        loginButtonContainer.setAlignment(Pos.CENTER);
        loginButton.setPrefSize(170, 40);
        loginButton.setFont(Font.font("segoe ui", FontWeight.BOLD, 16));
        loginButton.setStyle("-fx-background-color: #3f7afd; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-alignment: center;");
        loginButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                loginButton.setStyle("-fx-background-color: rgb(48,108,250); -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-alignment: center; -fx-cursor: hand;");
            } else {
                loginButton.setStyle("-fx-background-color: #3f7afd; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-alignment: center;");
            }
        });

        // OR Divider
        HBox orDivider = new HBox();
        orDivider.setAlignment(Pos.CENTER);
        orDivider.setSpacing(10);
        orDivider.getChildren().addAll(new Separator(), new Label("OR"), new Separator());

        // Social Media Buttons
        HBox socialButtons = new HBox(20);
        socialButtons.setAlignment(Pos.CENTER);

        // Icons
        ImageView googleIcon = new ImageView(new Image("https://cdn1.iconfinder.com/data/icons/google-s-logo/150/Google_Icons-09-512.png"));
        googleIcon.setFitWidth(30);
        googleIcon.setFitHeight(30);

        ImageView facebookIcon = new ImageView(new Image("https://cdn2.iconfinder.com/data/icons/social-media-2285/512/1_Facebook_colored_svg_copy-512.png"));
        facebookIcon.setFitWidth(30);
        facebookIcon.setFitHeight(30);

        ImageView appleIcon = new ImageView(new Image("https://cdn3.iconfinder.com/data/icons/picons-social/57/16-apple-512.png"));
        appleIcon.setFitWidth(30);
        appleIcon.setFitHeight(30);

        // Buttons for Social Media
        Button googleButton = new Button();
        googleButton.setGraphic(googleIcon);
        googleButton.setStyle("-fx-background-color: lightgray; -fx-cursor: hand;");

        Button facebookButton = new Button();
        facebookButton.setGraphic(facebookIcon);
        facebookButton.setStyle("-fx-background-color: lightgray; -fx-cursor: hand;");

        Button appleButton = new Button();
        appleButton.setGraphic(appleIcon);
        appleButton.setStyle("-fx-background-color: lightgray; -fx-cursor: hand;");

        socialButtons.getChildren().addAll(googleButton, facebookButton, appleButton);

        // Register Now
        HBox registerNow = new HBox();
        registerNow.setAlignment(Pos.CENTER);
        Label noAccount = new Label("Don't have an account? ");
        Hyperlink registerLink = new Hyperlink("Register Now");
        registerLink.setStyle("-fx-text-fill: #008CFF; -fx-font-weight: bold;");
        registerNow.getChildren().addAll(noAccount, registerLink);

        // Register Section
        VBox registerPane = new VBox(15);
        registerPane.setPadding(new Insets(30));
        registerPane.setAlignment(Pos.CENTER_LEFT);
        registerPane.setPrefWidth(400);
        registerPane.setStyle("-fx-background-color: white;");

        // 'Register' Title
        Text registerTitle = new Text("Register");
        registerTitle.setFont(Font.font("Ubuntu", FontWeight.BOLD, 28));
        registerTitle.setStyle("-fx-fill: #3f7afd;");
        registerTitle.setTextAlignment(TextAlignment.CENTER);
        registerTitle.setWrappingWidth(350);

        // Full Name
        Label fullNameLabel = new Label("Full Name");
        fullNameLabel.setStyle("-fx-text-fill: #008CFF;");
        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Enter your full name");
        fullNameField.setPrefHeight(40);

        // Username
        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-text-fill: #008CFF;");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setPrefHeight(40);

        // Email
        Label emailRegLabel = new Label("Email");
        emailRegLabel.setStyle("-fx-text-fill: #008CFF;");
        TextField emailRegField = new TextField();
        emailRegField.setPromptText("Enter your email");
        emailRegField.setPrefHeight(40);

        // Password
        Label passwordRegLabel = new Label("Password");
        passwordRegLabel.setStyle("-fx-text-fill: #008CFF;");
        PasswordField passwordRegField = new PasswordField();
        passwordRegField.setPromptText("Enter your password");
        passwordRegField.setPrefHeight(40);
        CheckBox showPasswordCheckBox = new CheckBox("Show Password");

        // Confirm Password
        Label confirmPasswordLabel = new Label("Confirm Password");
        confirmPasswordLabel.setStyle("-fx-text-fill: #008CFF;");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm your password");
        confirmPasswordField.setPrefHeight(40);
        CheckBox showConfirmPasswordCheckBox = new CheckBox("Show Password");

        // Terms and Conditions
        CheckBox agreeTerms = new CheckBox();
        Hyperlink termsLink = new Hyperlink("Terms and Conditions");
        termsLink.setStyle("-fx-text-fill: #008CFF;");
        HBox termsBox = new HBox(agreeTerms, new Label(" I agree to the "), termsLink);
        termsBox.setAlignment(Pos.CENTER_LEFT);

        // Register Button
        Button registerButton = new Button("Register");
        registerButton.setPrefSize(170, 50);
        registerButton.setFont(Font.font("segoe ui", FontWeight.BOLD, 15));
        registerButton.setStyle("-fx-background-color: #3f7afd; -fx-text-fill: white; -fx-background-radius: 20px;");
        HBox registerButtonContainer = new HBox(registerButton);
        registerButtonContainer.setAlignment(Pos.CENTER);
        registerButton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                registerButton.setStyle("-fx-background-color: rgb(48,108,250); -fx-text-fill: white; -fx-background-radius: 20px; -fx-cursor: hand;");
            } else {
                registerButton.setStyle("-fx-background-color: #3f7afd; -fx-text-fill: white; -fx-background-radius: 20px;");
            }
        });

        // Back Link
        Hyperlink backLink = new Hyperlink("Back to Login");
        backLink.setStyle("-fx-text-fill: #008CFF; -fx-font-weight: bold;");
        HBox backLinkContainer = new HBox(backLink);
        backLinkContainer.setAlignment(Pos.CENTER);

        // Add all components to Register Pane
        registerPane.getChildren().addAll(
                registerTitle,
                fullNameLabel, fullNameField,
                usernameLabel, usernameField,
                emailRegLabel, emailRegField,
                passwordRegLabel, passwordRegField,
                confirmPasswordLabel, confirmPasswordField,
                termsBox,
                registerButtonContainer,
                backLinkContainer
        );

        // Action to show Register Pane
        registerLink.setOnAction(event -> {
            ((HBox) primaryStage.getScene().getRoot()).getChildren().set(1, registerPane);
        });

        // Action to go back to Login Pane
        backLink.setOnAction(event -> {
            ((HBox) primaryStage.getScene().getRoot()).getChildren().set(1, rightPane);
        });

        HBox exitButton = new HBox();
        exitButton.setAlignment(Pos.CENTER);
        Hyperlink exitLink = new Hyperlink("Exit");
        exitLink.setStyle("-fx-text-fill: rgba(69,71,75,0.56); -fx-font-weight: bold;");
        exitButton.getChildren().addAll(exitLink);
        exitLink.setOnAction(event -> {
            primaryStage.close();
        });

        // Add components to the Right Pane
        rightPane.getChildren().addAll(
                welcomeText,
                loginSubText,
                emailLabel, emailField,
                passwordLabel, passwordField,
                forgotPassword,
                loginButtonContainer,
                orDivider,
                socialButtons,
                registerNow,
                exitButton
        );

        // Main layout
        HBox mainLayout = new HBox();
        mainLayout.getChildren().addAll(leftPane, rightPane);

        // Scene setup
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Register Button Action
        registerButton.setOnAction(event -> {
            String fullName = fullNameField.getText();
            String username = usernameField.getText();
            String email = emailRegField.getText();
            String password = passwordRegField.getText();
            String confirmPassword = confirmPasswordField.getText();

            boolean isValid = true;

            if (fullName.isEmpty()) {
                fullNameField.setStyle("-fx-border-color: red;");
                isValid = false;
            } else {
                fullNameField.setStyle(null);
            }

            if (username.isEmpty()) {
                usernameField.setStyle("-fx-border-color: red;");
                isValid = false;
            } else {
                usernameField.setStyle(null);
            }

            if (email.isEmpty()) {
                emailRegField.setStyle("-fx-border-color: red;");
                isValid = false;
            } else {
                emailRegField.setStyle(null);
            }

            if (password.isEmpty()) {
                passwordRegField.setStyle("-fx-border-color: red;");
                isValid = false;
            } else {
                passwordRegField.setStyle(null);
            }

            if (!password.equals(confirmPassword)) {
                confirmPasswordField.setStyle("-fx-border-color: red;");
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Passwords do not match");
                isValid = false;
            } else {
                confirmPasswordField.setStyle(null);
            }

            if (!agreeTerms.isSelected()) {
                termsBox.setStyle("-fx-border-color: red;");
                showAlert(Alert.AlertType.ERROR, "Form Error!", "You must agree to the terms and conditions");
                isValid = false;
            } else {
                termsBox.setStyle(null);
            }

            if (!isValid) {
                return;
            }

            // Check if username or email already exists
            if (isUsernameOrEmailExists(username, email)) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Username or Email already exists");
                return;
            }

            // Save to database
            saveToDatabase(fullName, username, email, password);
        });
    }

    private boolean isUsernameOrEmailExists(String username, String email) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
        try (Connection conn = Con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error!", "Error occurred while checking user information.");
        }
        return false;
    }

    private void saveToDatabase(String fullName, String username, String email, String password) {
        String query = "INSERT INTO users (full_name, username, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = Con.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, email);
            stmt.setString(4, password);

            stmt.executeUpdate();
            showAlert(Alert.AlertType.INFORMATION, "Registration Successful!", "User registered successfully!", true);

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error!", "Error occurred while saving user information.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message, boolean redirectToLogin) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait().ifPresent(response -> {
            if (redirectToLogin && response == ButtonType.OK) {
                ((HBox) primaryStage.getScene().getRoot()).getChildren().set(1, rightPane);
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}