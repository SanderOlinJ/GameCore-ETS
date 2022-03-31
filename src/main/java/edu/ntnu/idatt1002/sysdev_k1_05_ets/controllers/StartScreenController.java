package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {

    @FXML private BorderPane startScreenPane;


    /**
     * Redirects to add team scene from MainPage
     * @param event
     * @throws IOException
     */
    @FXML
    public void onCreateNewTournamentClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/main-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(startScreenPane.getHeight());
        stage.setWidth(startScreenPane.getWidth());
        stage.setMinWidth(780);
        stage.setMinHeight(600);
        stage.show();
    }

}
