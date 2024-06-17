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

public class tableViewController {
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

    @FXML
    public void initialize() {
        videoGameNameColumn.setCellValueFactory(new PropertyValueFactory<>("videoGameName"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("platform"));
        releaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));

        ObservableList<videoGamesModel> dataList = FXCollections.observableArrayList();

        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "SELECT videoGameName, platform, release_year, rating, sales FROM Video_Games";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                dataList.add(new videoGamesModel(
                        resultSet.getString("videoGameName"),
                        resultSet.getString("platform"),
                        resultSet.getInt("release_year"),
                        resultSet.getFloat("rating"),
                        resultSet.getInt("sales")
                ));
            }

            tableView.setItems(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
