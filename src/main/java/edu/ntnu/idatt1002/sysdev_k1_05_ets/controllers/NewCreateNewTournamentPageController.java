package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class NewCreateNewTournamentPageController implements Initializable {

    private Scene scene;
    private Stage stage;

    @FXML
    TextField tournamentNameField;
    @FXML
    TextArea teamsNameFieldWithPlayerNames;
    @FXML
    ComboBox bracketFormat;
    @FXML
    Label warningLabel;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bracketFormat.getItems().addAll("4","8","16");
        bracketFormat.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override public ListCell<String> call(ListView<String> p) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            //This won't work for the first time but will be the one
                            //used in the next calls
                            getStyleClass().add("my-list-cell");
                            setTextFill(Color.RED);
                            //size in px
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
           }


    @FXML
    public void addTeamScene(ActionEvent event) throws IOException {
        //------ parse the current information of combobox to addTeamScene -----
        String bracketChoice = String.valueOf(bracketFormat.getValue());

        try {
            int formatNr = Integer.parseInt(bracketChoice);
        } catch (NumberFormatException nfe) {
            warningLabel.setText("You have to choose a tournament format");
            return;
        }

        AddTeamController.setMaxTeams(Integer.parseInt(bracketChoice));
        EightTeamController.setTournamentName(tournamentNameField.getText());

        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/add-team.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }
}
