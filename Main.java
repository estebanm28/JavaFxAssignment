package org.example.assignment1java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Main class extending the Application class to create a JavaFX application
public class Main extends Application {

    // Override the start method which is the entry point for the JavaFX application
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set the title of the primary stage (window)
        primaryStage.setTitle("Video Games!");
        
        // Set the icon of the primary stage using an image from the resources
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));

        // Button to change the view to a bar chart
        Button barChartButton = new Button("Graphic Bar");
        // Set an action to be performed when the barChartButton is clicked
        barChartButton.setOnAction(e -> {
            try {
                // Load the main.fxml layout
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
                Scene scene = new Scene(loader.load());
                // Set the new scene to the primary stage
                primaryStage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace(); // Print the stack trace in case of an exception
            }
        });

        // Button to change the view to a table graphic
        Button tableViewButton = new Button("Table graphic");
        // Set an action to be performed when the tableViewButton is clicked
        tableViewButton.setOnAction(e -> {
            try {
                // Load the table.fxml layout
                FXMLLoader loader = new FXMLLoader(getClass().getResource("table.fxml"));
                Scene scene = new Scene(loader.load());
                // Set the new scene to the primary stage
                primaryStage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace(); // Print the stack trace in case of an exception
            }
        });

        // Create a VBox layout and add the buttons to it
        VBox vBox = new VBox(barChartButton, tableViewButton);
        // Create the initial scene with the VBox layout and set its size
        Scene initialScene = new Scene(vBox, 300, 200);

        // Set the initial scene to the primary stage
        primaryStage.setScene(initialScene);
        // Display the primary stage
        primaryStage.show();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
