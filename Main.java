package org.example.assignment1java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Video Games!");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));

        // Button to change the view
        Button barChartButton = new Button("Graphic Bar");
        barChartButton.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
                Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Button to change the view
        Button tableViewButton = new Button("Table graphic");
        tableViewButton.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("table.fxml"));
                Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox vBox = new VBox(barChartButton, tableViewButton);
        Scene initialScene = new Scene(vBox, 300, 200);

        primaryStage.setScene(initialScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}