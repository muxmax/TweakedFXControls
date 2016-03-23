package de.saxsys.examples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by steven.lehmann on 22.03.2016.
 */
public class ExampleOneStarter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ExampleOneView.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("PercentageTableColumn example");
        stage.setScene(scene);
        stage.show();
    }
}
