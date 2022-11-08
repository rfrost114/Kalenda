package com.mycompany.kalenda.two;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

//        User user = new User("Richie");
//        AvailView pane = new AvailView(user);
//        Scene scene = new Scene(pane);
//        primaryStage.setTitle("AvailView Test");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        UserStartView pane = new UserStartView();
        Scene scene = new Scene(pane);
        primaryStage.setTitle("AvailView Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}