package edu.ntnu.idatt1002.sysdev_k1_05_ets.Controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters.GameAndPlatFormReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters.NewTournamentWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.textfield.TextFields;
import javafx.scene.control.TextField;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import java.io.IOException;



public class CreateNewTournamentPageController implements Initializable {

    private Scene scene;
    private Stage stage;

    @FXML TextField tournamentNameBox;
    @FXML ComboBox tournamentHostBox;
    @FXML TextArea descriptionBox;
    @FXML TextField gameBox;
    @FXML TextField platformBox;
    @FXML ComboBox tournamentTypeBox;
    @FXML ComboBox totalNumberOfTeamsBox;
    @FXML Label warningLabel;
    @FXML ImageView gameImageView;
    @FXML ImageView bracketFormatImageView;
    @FXML DatePicker datePicker;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        descriptionBox.setWrapText(true);
        try {
            TextFields.bindAutoCompletion(gameBox, GameAndPlatFormReader.readFile
                    (new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/games.txt")));
            TextFields.bindAutoCompletion(platformBox, GameAndPlatFormReader.readFile
                    (new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/platforms.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gameBox.textProperty().addListener(((observableValue, oldValue , newValue) ->
                gameImageView.setImage(new Image(getPathToGameImageFile(newValue)))));

        tournamentTypeBox.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldValue, newValue) ->
                        totalNumberOfTeamsBox.setDisable(false))
        );

        totalNumberOfTeamsBox.getSelectionModel().selectedItemProperty().addListener
                ((observableValue, oldValue, newValue) ->
                        bracketFormatImageView.setImage(new Image(getPathToBracketImageFile(newValue.toString()))));

        tournamentTypeBox.getItems().addAll("Brackets");
        tournamentTypeBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override public ListCell<String> call(ListView<String> p) {
                return new ListCell<>() {
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
        LocalDate date = datePicker.getValue();
        String description = String.valueOf(descriptionBox.getText());
        String game = String.valueOf(gameBox.getText());
        String platform = String.valueOf(platformBox.getText());
        String tournamentType = String.valueOf(tournamentTypeBox.getValue());
        String numberOfTeams = String.valueOf(totalNumberOfTeamsBox.getValue());

        if (tournamentName.isEmpty() || tournamentHost.isEmpty() || date == null|| game.isEmpty() ||
                platform.isEmpty() || tournamentType.isEmpty() || numberOfTeams.isEmpty()){
            warningLabel.setText("You have to fill out all crucial fields (*)");
            throw new IllegalArgumentException("You have to fill out all crucial fields (*)");
        }

        if (date.isBefore(LocalDate.now())){
            warningLabel.setText("You can't choose a date in the past");
            throw new IllegalArgumentException("You can't choose a date in the past");
        }

        int formatNr = Integer.parseInt(numberOfTeams);

        AddTeamController.setMaxTeams(formatNr);
        EightTeamController.setTournamentName(tournamentNameBox.getText());

        NewTournamentWriter.writeTournamentToFileWithoutTeams(tournamentName, tournamentHost,date, description,
                game, platform, tournamentType, numberOfTeams);

        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/add-team.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    public static String getPathToGameImageFile(String gameAsString){
        gameAsString = gameAsString.replaceAll("\\s","");
        gameAsString = gameAsString.replaceAll(":","");
        gameAsString = gameAsString.replaceAll("-","");
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/gameImages/%s",
                gameAsString) + ".png";
    }

    public static String getPathToBracketImageFile(String bracketFormatAsString){
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/bracketFormats/%s",
                bracketFormatAsString) + ".png";
    }
}
