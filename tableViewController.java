package org.example.assignment1java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// Controller class for handling TableView and populating it with data
public class tableViewController {
    // FXML annotations to bind the UI components from the FXML file
    @FXML
    private TableView<videoGamesModel> tableView;
    @FXML
    private TableColumn<videoGamesModel, String> videoGameNameColumn;
    @FXML
    private TableColumn<videoGamesModel, String> platformColumn;
    @FXML
    private TableColumn<videoGamesModel, Integer> releaseYearColumn;
    @FXML
    private TableColumn<videoGamesModel, Float> ratingColumn;
    @FXML
    private TableColumn<videoGamesModel, Integer> salesColumn;

    // Method that initializes the controller, called after the FXML file is loaded
    @FXML
    public void initialize() {
        // Set up the cell value factories for each column
        videoGameNameColumn.setCellValueFactory(new PropertyValueFactory<>("videoGameName"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("platform"));
        releaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));

        // Create an observable list to hold the data
        ObservableList<videoGamesModel> dataList = FXCollections.observableArrayList();

        // Connect to the database and fetch data
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "SELECT videoGameName, platform, release_year, rating, sales FROM Video_Games";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and add data to the list
            while (resultSet.next()) {
                dataList.add(new videoGamesModel(
                        resultSet.getString("videoGameName"),
                        resultSet.getString("platform"),
                        resultSet.getInt("release_year"),
                        resultSet.getFloat("rating"),
                        resultSet.getInt("sales")
                ));
            }

            // Set the items of the TableView to the data list
            tableView.setItems(dataList);
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an exception
        }
    }
}
