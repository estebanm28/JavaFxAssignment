package org.example.assignment1java;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

// Controller class for handling UI interactions and data population
public class controller {

    // FXML annotations to bind the UI components from the FXML file
    @FXML
    private Button switchButton;

    @FXML
    private BarChart<String, Number> barChart;

    // Boolean flag to toggle between views
    private boolean isTableView = false;

    // Method that initializes the controller, called after the FXML file is loaded
    @FXML
    public void initialize() {
        try (Connection connection = dataBaseConnection.getConnection()) {
            // SQL query to fetch video game names and their sales from the database
            String query = "SELECT videoGameName, sales FROM Video_Games";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Create a new series for the bar chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            // Populate the series with data from the result set
            while (resultSet.next()) {
                series.getData().add(new XYChart.Data<>(resultSet.getString("videoGameName"), resultSet.getInt("sales")));
            }

            // Add the series to the bar chart
            barChart.getData().add(series);
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an exception
        }
    }

    // Method to change the view between bar chart and another view
    @FXML
    private void changeView() {
        if (isTableView) {
            // Switch to the bar chart view
            barChart.setVisible(true);
            isTableView = false;
            switchButton.setText("Switch to Table View");
        } else {
            // Hide the bar chart and switch to another view (e.g., table view)
            barChart.setVisible(false); // Hide the bar chart
            isTableView = true;
            switchButton.setText("Switch to Bar Chart View");
        }
    }
}
