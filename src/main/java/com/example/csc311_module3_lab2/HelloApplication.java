package com.example.csc311_module3_lab2;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    private StackPane root;

    @Override
    public void start(Stage stage) {
        root = new StackPane();

        showSplash();

        Scene scene = new Scene(root, 900, 600);

        scene.getStylesheets().add(
                getClass().getResource("/styles.css").toExternalForm()
        );

        stage.setTitle("Module 3 Lab 2");
        stage.setScene(scene);
        stage.show();
    }

    private void showSplash() {
        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);
        box.getStyleClass().add("splash");

        Label title = new Label("WELCOME");
        title.getStyleClass().add("title");

        Label subtitle = new Label("Module 3 Lab 2");
        subtitle.getStyleClass().add("subtitle");

        box.getChildren().addAll(title, subtitle);
        root.getChildren().setAll(box);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        pause.setOnFinished(e -> showLogin());

        pause.play();
    }

    private void showLogin() {
        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);
        box.setMaxWidth(350);
        box.getStyleClass().add("card");

        Label title = new Label("Login");
        title.getStyleClass().add("title");

        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button login = new Button("Login");
        login.getStyleClass().add("button");

        Label register = new Label("Don't have an account? Register");
        register.getStyleClass().add("link");

        login.setOnAction(e -> showLanding());

        register.setOnMouseClicked(e -> showLanding());

        box.getChildren().addAll(
                title,
                username,
                password,
                login,
                register
        );

        root.getChildren().setAll(box);
    }

    private void showLanding() {
        VBox box = new VBox(20);
        box.setAlignment(Pos.CENTER);
        box.getStyleClass().add("landing");

        Label title = new Label("Dashboard");
        title.getStyleClass().add("title");

        Label welcome = new Label("Welcome to the application!");
        welcome.getStyleClass().add("subtitle");

        Button logout = new Button("Logout");
        logout.getStyleClass().add("button");

        logout.setOnAction(e -> showLogin());

        box.getChildren().addAll(
                title,
                welcome,
                logout
        );

        root.getChildren().setAll(box);
    }

    public static void main(String[] args) {
        launch();
    }
}