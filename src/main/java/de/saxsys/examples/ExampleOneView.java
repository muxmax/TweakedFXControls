package de.saxsys.examples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by steven.lehmann on 22.03.2016.
 */
public class ExampleOneView implements Initializable {

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, String> tcName;
    @FXML
    private TableColumn<Person, String> tcPreName;
    @FXML
    private TableColumn<Person, String> tcCity;
    @FXML
    private TableColumn<Person, String> tcStreet;
    @FXML
    private TableColumn<Person, String> tcAge;

    @FXML
    void addData(ActionEvent event) {
        tableView.getItems().addAll(createTableData());
    }

    @FXML
    void clearTable(ActionEvent event) {
        tableView.getItems().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tcName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tcPreName.setCellValueFactory(cellData -> cellData.getValue().preNameProperty());
        tcCity.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        tcStreet.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
        tcAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asString());

        tableView.setItems(createTableData());
    }

    private ObservableList<Person> createTableData() {
        return FXCollections.observableArrayList(new Person("hawking", "stephen", "new york", "very long street", 19),
                new Person("Muster", "Max", "Dresden", "Tieckstrasse", 22),
                new Person("Hastenichgesehn", "Andreas", "Dresden", "Am goldenen Reiter", 55));
    }

}
