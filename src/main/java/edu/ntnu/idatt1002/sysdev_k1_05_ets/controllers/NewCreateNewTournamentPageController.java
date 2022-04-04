package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters.GameReader;
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
import org.controlsfx.control.textfield.TextFields;
import javafx.scene.control.TextField;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;



public class NewCreateNewTournamentPageController implements Initializable {

    private Scene scene;
    private Stage stage;

    @FXML TextField tournamentNameBox;
    @FXML ComboBox tournamentHostBox;
    @FXML TextField descriptionBox;
    @FXML TextField gameBox;
    @FXML ComboBox platformBox;
    @FXML ComboBox tournamentTypeBox;
    @FXML ComboBox totalNumberOfTeamsBox;
    @FXML Label warningLabel;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] strings = {"yo","homie"};
        try {
            TextFields.bindAutoCompletion(gameBox, GameReader.readFile
                    (new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/gameFiles/games.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        tournamentTypeBox.getItems().addAll("Bracket");
        tournamentTypeBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
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
        totalNumberOfTeamsBox.getItems().addAll("4","8","16");
        totalNumberOfTeamsBox.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView listView) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            //This won't work for the first time but will be the one
                            //used in the next calls
                            getStyleClass().add("my-list-cell");
                            //size in px
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
        tournamentHostBox.getItems().add("Admin");
        tournamentHostBox.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView listView) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            //This won't work for the first time but will be the one
                            //used in the next calls
                            getStyleClass().add("my-list-cell");
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
        String tournamentName = String.valueOf(tournamentNameBox.getText());
        String tournamentHost = String.valueOf(tournamentHostBox.getValue());
        String description = String.valueOf(descriptionBox.getText());
        String game = String.valueOf(gameBox.getText());
        String platform = String.valueOf(platformBox.getValue());
        String tournamentType = String.valueOf(tournamentTypeBox.getValue());
        String totalNumberOfTeams = String.valueOf(totalNumberOfTeamsBox.getValue());

        if (tournamentName.isEmpty() ||
                tournamentType.isEmpty() || totalNumberOfTeams.isEmpty()){
            warningLabel.setText("You have to fill out all crucial fields (*)");
            throw new IllegalArgumentException("You have to fill out all crucial fields (*)");
        }

        int formatNr = Integer.parseInt(totalNumberOfTeams);

        AddTeamController.setMaxTeams(formatNr);
        EightTeamController.setTournamentName(tournamentNameBox.getText());

        Parent root = FXMLLoader.load(GameCoreETSApplication.class.getResource("scenes/add-team.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }
}
