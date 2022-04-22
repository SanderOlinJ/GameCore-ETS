package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.GameCoreETSApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.GeneralReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.NewTournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriterRework;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;
import org.controlsfx.control.textfield.TextFields;
import javafx.scene.control.TextField;

import java.io.File;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.ResourceBundle;

import java.io.IOException;



public class CreateNewTournamentPageController{

    public Button continueButton;
    private Scene scene;
    private Stage stage;
    private NewTournament tournament;

    @FXML private TextField tournamentNameBox;
    @FXML private ComboBox tournamentHostBox;
    @FXML private TextArea descriptionBox;
    @FXML private TextField gameBox;
    @FXML private TextField platformBox;
    @FXML private ComboBox tournamentTypeBox;
    @FXML private ComboBox totalNumberOfTeamsBox;
    @FXML private Label warningLabel;
    @FXML private ImageView gameImageView;
    @FXML private ImageView bracketFormatImageView;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox timeBoxHours;
    @FXML private ComboBox timeBoxMinutes;
    @FXML private Text prizePoolText;
    @FXML private TextField prizePoolTextField;
    @FXML private Text entranceFeeText;
    @FXML private TextField entranceFeeTextField;
    @FXML private Text prizePoolCurrencyText;
    @FXML private ComboBox prizePoolCurrencyBox;
    @FXML private Text entranceFeeCurrencyText;
    @FXML private ComboBox entranceFeeCurrencyBox;
    @FXML private CheckBox activatePrizePool;

    @FXML private MenuBar menuBar;

    @FXML private MenuItem homeButton;
    @FXML private MenuItem ongoingTournamentsButton;
    @FXML private MenuItem upcomingTournamentsButton;
    @FXML private MenuItem previousTournamentsButton;
    @FXML private MenuItem aboutButton;
    @FXML private MenuItem helpButton;

    @FXML
    public void initialize() {


        try {
            TournamentWriterRework.updateTournamentFileLocation();
            TextFields.bindAutoCompletion(gameBox, GeneralReader.readFile
                    (new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/games.txt")));
            TextFields.bindAutoCompletion(platformBox, GeneralReader.readFile
                    (new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/platforms.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gameBox.textProperty().addListener(((observableValue, oldValue , newValue) ->
                gameImageView.setImage(new Image(Utilities.getPathToGameImageFile(newValue)))));

        tournamentTypeBox.getSelectionModel().selectedItemProperty().addListener
                ((observableValue, oldValue, newValue) ->
                        totalNumberOfTeamsBox.setDisable(false));

        totalNumberOfTeamsBox.getSelectionModel().selectedItemProperty().addListener
                ((observableValue, oldValue, newValue) ->
                        bracketFormatImageView.setImage(new Image(Utilities
                                .getPathToBracketImageFile(newValue.toString()))));


        timeBoxHours.getItems().addAll("00","01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20","21","22","23");
        timeBoxHours.setCellFactory(new Callback<ListView, ListCell>() {
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
        timeBoxMinutes.getItems().addAll("00","05","10","15","20","25","30","35","40","45","50","55");
        timeBoxMinutes.setCellFactory(new Callback<ListView, ListCell>() {
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

        prizePoolCurrencyBox.getItems().addAll("NOK","USD","EUR","GBP");
        prizePoolCurrencyBox.setCellFactory(new Callback<ListView, ListCell>() {
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

        entranceFeeCurrencyBox.getItems().addAll("NOK","USD","EUR","GBP");
        entranceFeeCurrencyBox.setCellFactory(new Callback<ListView, ListCell>() {
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
    public void onActivatePrizePoolPressed(ActionEvent event){
        if (activatePrizePool.isSelected()) {
            prizePoolText.setOpacity(1);
            prizePoolCurrencyText.setOpacity(1);
            entranceFeeText.setOpacity(1);
            entranceFeeCurrencyText.setOpacity(1);
            prizePoolTextField.setDisable(false);
            prizePoolCurrencyBox.setDisable(false);
            entranceFeeTextField.setDisable(false);
            entranceFeeCurrencyBox.setDisable(false);
        }else {
            prizePoolText.setOpacity(0.5);
            prizePoolCurrencyText.setOpacity(0.5);
            entranceFeeText.setOpacity(0.5);
            entranceFeeCurrencyText.setOpacity(0.5);
            prizePoolTextField.setDisable(true);
            prizePoolCurrencyBox.setDisable(true);
            entranceFeeTextField.setDisable(true);
            entranceFeeCurrencyBox.setDisable(true);
        }
    }



    @FXML
    public void addTeamScene(ActionEvent event) throws IOException {
        //------ parse the current information of combobox to addTeamScene -----
        String status = "Not finished";
        String tournamentName = String.valueOf(tournamentNameBox.getText());
        String tournamentHost = String.valueOf(tournamentHostBox.getValue());
        LocalDate date = datePicker.getValue();
        LocalTime time;
        try {
            time = LocalTime.parse(timeBoxHours.getValue() + ":" + timeBoxMinutes.getValue());
        } catch (DateTimeException exception){
            warningLabel.setText("You must pick a time");
            throw new IOException("You must pick a time");
        }
        String description = String.valueOf(descriptionBox.getText());
        String game = String.valueOf(gameBox.getText());
        String platform = String.valueOf(platformBox.getText());
        String tournamentType = String.valueOf(tournamentTypeBox.getValue());
        String numberOfTeams = String.valueOf(totalNumberOfTeamsBox.getValue());
        String prizePool = "0";
        String prizePoolCurrency = "null";
        String entranceFee = "0";
        String entranceFeeCurrency = "null";

        if (activatePrizePool.isSelected()){
            prizePool = String.valueOf(prizePoolTextField.getText());
            prizePoolCurrency = String.valueOf(prizePoolCurrencyBox.getValue());
            entranceFee = String.valueOf(entranceFeeTextField.getText());
            entranceFeeCurrency = String.valueOf(entranceFeeCurrencyBox.getValue());
        }
        try {
            checkIfAllRequiredFieldsAreFilledOut(tournamentName, tournamentHost, date, game, platform, tournamentType, numberOfTeams);
            checkIfFileAlreadyExists(tournamentName);
            checkIfDateIsInvalid(date, time);
            checkThatGameExistsInLibrary(game);
            checkThatPlatformExistsInLibrary(platform);
            if (activatePrizePool.isSelected()) {
                checkIfPricePoolActivated(prizePool, prizePoolCurrency, entranceFee, entranceFeeCurrency);
            }
        } catch (IOException exception){
            throw new IOException(exception.getMessage());
        }

        NewTournament tournament= new NewTournament(status, tournamentName, tournamentHost, date, time,
                description, game, platform, tournamentType, numberOfTeams, prizePool, prizePoolCurrency,
                entranceFee, entranceFeeCurrency);

        TournamentWriterRework.writeNewTournamentToFileWithBasicInfo(status, tournamentName,
                tournamentHost, date, time, description, game, platform, tournamentType, numberOfTeams,
                prizePool, prizePoolCurrency, entranceFee, entranceFeeCurrency);

        int formatNr = Integer.parseInt(numberOfTeams);
        AddTeamController.setMaxTeams(formatNr);
        AddTeamController.setTournament(tournament);

        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource(
                "scenes/add-team-scene.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    private void checkIfDateIsInvalid(LocalDate date, LocalTime time) throws IOException {
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()) && time.isBefore(LocalTime.now())) {
            warningLabel.setText("You can't choose a date in the past");
            throw new IOException("You can't choose a date in the past");
        }
    }

    private void checkIfAllRequiredFieldsAreFilledOut(String tournamentName, String tournamentHost, LocalDate date,
                                                      String game, String platform, String tournamentType,
                                                      String numberOfTeams)
    throws IOException {

        if (tournamentName.isEmpty() || tournamentHost.isEmpty() || date == null ||
                game.isEmpty() || platform.isEmpty() || tournamentType.isEmpty() ||
                numberOfTeams.isEmpty()){
            warningLabel.setText("You have to fill out all crucial fields (*)");
            throw new IOException("You have to fill out all crucial fields (*)");
        }
    }

    private void checkIfFileAlreadyExists(String tournamentName) throws IOException {
        String doesFileExist = NewTournamentWriter.doesFileWithSameNameAlreadyExist(Utilities
                .shortenAndReplaceUnnecessarySymbolsInString(tournamentName));

        if (doesFileExist.equals("Ongoing") || doesFileExist.equals("Upcoming") || doesFileExist.equals("Previous")){
            warningLabel.setText("There is already a tournament file under this name");
            throw new IOException("There is already a tournament file under this name");
        }
    }

    private void checkIfPricePoolActivated(String prizePool, String prizePoolCurrency, String entranceFee,
                                                  String entranceFeeCurrency)
    throws IOException{
        if (prizePool.equals("") || prizePool.equals("0")){
            warningLabel.setText("Prize pool cannot be 0 or blank");
            throw new IOException("Prize pool cannot be 0 or blank");
        }
        if (prizePoolCurrency.equals("null")){
            warningLabel.setText("Prize pool needs to be declared with a currency");
            throw new IOException("Prize pool needs to be declared with a currency");
        }
        if (entranceFee.equals("")){
            warningLabel.setText("Entrance fee cannot be blank. " +
                    "If there are no entrance fee, type '0'");
            throw new IOException("Entrance fee cannot be blank.\n" +
                    "If there are no entrance fee, type '0'");
        }
        if (entranceFeeCurrency.equals("null")){
            warningLabel.setText("Entrance fee needs to be declared with a currency");
            throw new IOException("Entrance fee needs to be declared with a currency");
        }
    }

    private void checkThatGameExistsInLibrary(String game)
    throws IOException{
        if (!GeneralReader.isGameInLibrary(game)) {
            warningLabel.setText("The game you chose does not exist, or is not in library");
            throw new IOException("The game you chose does not exist, or is not in library");
        }

    }

    private void checkThatPlatformExistsInLibrary(String platform)
    throws IOException{
        if (!GeneralReader.isPlatformInLibrary(platform)){
            warningLabel.setText("The platform you chose does not exist, or is not in library");
            throw new IOException("The platform you chose does not exist, or is not in library");
        }
    }

    public NewTournament getTournament() {
        return tournament;
    }


    @FXML
    void onHomeButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/main-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onAboutButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/about-page.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onOngoingTournamentsButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/ongoing-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    private void setNextWindowFromMenuBar(Parent root) {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(1200);
        stage.setMinHeight(800);
        stage.show();
    }

    @FXML
    void onUpcomingTournamentsButtonPressed(ActionEvent event)
            throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/upcoming-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onPreviousTournamentsButtonPressed(ActionEvent event)
            throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class
                .getResource("scenes/previous-overview.fxml")));
        setNextWindowFromMenuBar(root);
    }

    @FXML
    void onHelpButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GameCoreETSApplication.class.getResource("scenes/help-page.fxml")));
        setNextWindowFromMenuBar(root);
    }
}
