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

public class controller {

    @FXML
    private Button switchButton;

    @FXML
    private BarChart<String, Number> barChart;

    private boolean isTableView = false;


    @FXML
    public void initialize() {
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "SELECT videoGameName, sales FROM Video_Games";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            while (resultSet.next()) {
                series.getData().add(new XYChart.Data<>(resultSet.getString("videoGameName"), resultSet.getInt("sales")));
            }

            barChart.getData().add(series);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void changeView() {
        if (isTableView) {
            // Cambiar a la vista de gráfico de barras
            barChart.setVisible(true);
            isTableView = false;
            switchButton.setText("Switch to Table View");
        } else {
            // Cambiar a otra vista (aquí puedes cargar otra vista si es necesario)
            barChart.setVisible(false); // Ocultar el gráfico de barras
            isTableView = true;
            switchButton.setText("Switch to Bar Chart View");
        }
    }
}