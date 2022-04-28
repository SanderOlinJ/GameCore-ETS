package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.GeneralReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters.TournamentWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.control.TextField;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

import java.io.IOException;

/**
 * Controller class for the Create New tournament page
 */
public class CreateTournamentPageController {

    public Button continueButton;

    @FXML private TextField tournamentNameBox;
    @FXML private ComboBox tournamentHostBox;
    @FXML private TextArea descriptionBox;
    @FXML private ComboBox gameBox;
    @FXML private TextField platformBox;
    @FXML private ComboBox tournamentTypeBox;
    @FXML private ComboBox totalNumberOfTeamsBox;
    @FXML private Label warningLabel;
    @FXML private ImageView gameImageView;
    @FXML private ImageView bracketFormatImageView;
    @FXML private DatePicker datePicker;
    @FXML private TextField showDateField;
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

    /**
     Method initializes the page with content.
     */
    @FXML
    public void initialize() {
        try {
            //Updates the locations of the tournaments
            TournamentWriter.updateTournamentFileLocation();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Sets listeners to game box, so that an image of the game may be displayed
        gameBox.getSelectionModel().selectedItemProperty().addListener
                ((observableValue, oldValue, newValue) ->
                        gameImageView.setImage(new Image(Utilities.getPathToGameImageFile(newValue.toString()))));

        //Sets listeners to tournament type box, so that the total number of teams box may be enabled.
        tournamentTypeBox.getSelectionModel().selectedItemProperty().addListener
                ((observableValue, oldValue, newValue) ->
                        totalNumberOfTeamsBox.setDisable(false));

        //Sets listeners to total number of teams box, so that an image of the bracket size may be displayed.
        totalNumberOfTeamsBox.getSelectionModel().selectedItemProperty().addListener
                ((observableValue, oldValue, newValue) ->
                        bracketFormatImageView.setImage(new Image(Utilities
                                .getPathToBracketImageFile(newValue.toString()))));
        datePicker.valueProperty().addListener(
                (observableValue, oldValue, newValue) ->
                        showDateField.setText(newValue.toString()));

        //Adds game choices to the game box
        gameBox.getItems().addAll("Counter-Strike: Global Offensive", "Valorant", "League of Legends");
        gameBox.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView listView) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });

        //Adds items to the hours box
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });

        //Adds items to the minutes box
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });

        //Add items to the tournament type box
        tournamentTypeBox.getItems().addAll("Brackets");
        tournamentTypeBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override public ListCell<String> call(ListView<String> p) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
        //Add items to the total number of teams box
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
        //Add items to the tournament host box
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
        //Add items to the prize pool currency box
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
        //Add items to the entrance fee currency box
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
                            getStyleClass().add("my-list-cell");
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });
    }

    /**
     * Method for activating fields relating to prize pool and entrance fee,
     * if the prize pool check box have been checked.
     */
    @FXML
    public void onActivatePrizePoolPressed(){
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

    /**
     * Method for writing tournament data to tournament file and overview, as well as redirect
     * to the Add Team page
     * @throws IOException if fields are not filled out, if fields are invalid or if scenes
     * cannot be switched
     */
    @FXML
    public void addTeamScene() throws IOException {

        //Method runs through checks to see if all values are valid

        //First check if all required fields are filled out
        checkIfAllRequiredFieldsAreFilledOut(tournamentNameBox.getText(),
                String.valueOf(tournamentHostBox.getValue()),
                String.valueOf(datePicker.getValue()),
                String.valueOf(timeBoxHours.getValue()),
                String.valueOf(timeBoxMinutes.getValue()),
                String.valueOf(gameBox.getValue()), platformBox.getText(),
                String.valueOf(tournamentTypeBox.getValue()),
                String.valueOf(totalNumberOfTeamsBox.getValue()));

        //Check if file exist under same tournament name.
        checkIfFileAlreadyExists(tournamentNameBox.getText());

        //Check if date is valid (in future)
        checkIfDateIsInvalid(datePicker.getValue(),
                LocalTime.parse(timeBoxHours.getValue()+":"+timeBoxMinutes.getValue()));

        //Check that game chosen, exists in library.
        checkThatGameExistsInLibrary(gameBox.getValue().toString());

        //Check if prize pool fields are correctly filled out
        if (activatePrizePool.isSelected()) {
            checkIfPrizePoolValuesAreValid(prizePoolTextField.getText(),
                    String.valueOf(prizePoolCurrencyBox.getValue()),
                    entranceFeeTextField.getText(),
                    String.valueOf(entranceFeeCurrencyBox.getValue()));
        }

        //The method assigns values from the page to variables, if the checks went ok.
        String status = "Not finished";
        String tournamentName = String.valueOf(tournamentNameBox.getText());
        String tournamentHost = String.valueOf(tournamentHostBox.getValue());
        LocalDate date = datePicker.getValue();
        LocalTime time = LocalTime.parse(timeBoxHours.getValue() + ":" + timeBoxMinutes.getValue());
        String description = String.valueOf(descriptionBox.getText());
        String game = String.valueOf(gameBox.getValue());
        String platform = String.valueOf(platformBox.getText());
        String tournamentType = String.valueOf(tournamentTypeBox.getValue());
        int numberOfTeams = Integer.parseInt(String.valueOf(totalNumberOfTeamsBox.getValue()));
        int prizePool = 0;
        String prizePoolCurrency = "null";
        int entranceFee = -1;
        String entranceFeeCurrency = "null";

        if (activatePrizePool.isSelected()){
            prizePool = Integer.parseInt(prizePoolTextField.getText());
            prizePoolCurrency = String.valueOf(prizePoolCurrencyBox.getValue());
            entranceFee = Integer.parseInt(entranceFeeTextField.getText());
            entranceFeeCurrency = String.valueOf(entranceFeeCurrencyBox.getValue());
        }
        //The tournament values are the written to a file-
        TournamentWriter.writeNewTournamentToFileWithBasicInfo(status, tournamentName,
                tournamentHost, date, time, description, game, platform, tournamentType, numberOfTeams,
                prizePool, prizePoolCurrency, entranceFee, entranceFeeCurrency);

        //Sends name of tournament to next page, so that the next controller knows what file to read from
        AddTeamController.setNameOfTournament(tournamentName);

        //Switches scene
        ViewSwitcher.switchTo(View.ADD_TEAM);
    }

    /**
     * Method checks if date of tournament is valid
     * @param date date of the tournament
     * @param time time of the tournament
     * @throws IOException if values are invalid
     */
    private void checkIfDateIsInvalid(LocalDate date, LocalTime time) throws IOException {
        if (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()) && time.isBefore(LocalTime.now())) {
            warningLabel.setText("You can't choose a date in the past");
            throw new IOException("You can't choose a date in the past");
        }
    }

    /**
     * Method checks if all required fields have been fillet out
     * @param tournamentName name of the tournament
     * @param tournamentHost host of the tournament
     * @param date date of the tournament
     * @param hours time of the tournament in hours
     * @param minutes time of the tournament in minutes
     * @param game game to be played at tournament
     * @param platform platform game is played on
     * @param tournamentType type of tournament
     * @param numberOfTeams number of teams participating in tournament
     * @throws IOException if values are invalid
     */
    private void checkIfAllRequiredFieldsAreFilledOut(String tournamentName, String tournamentHost, String date,
                                                      String hours, String minutes, String game, String platform,
                                                      String tournamentType, String numberOfTeams)
    throws IOException {
        if (tournamentName.isEmpty() || tournamentHost.isEmpty() || date.isEmpty() ||
                hours.isEmpty() || minutes.isEmpty() || game.isEmpty() ||
                platform.isEmpty() || tournamentType.isEmpty() ||
                !numberOfTeams.equals("4") && !numberOfTeams.equals("8") && !numberOfTeams.equals("16")){
            warningLabel.setText("You have to fill out all crucial fields (*)");
            throw new IOException("You have to fill out all crucial fields (*)");
        }
    }

    /**
     * Method checks if a tournament file under the given name already exist.
     * @param tournamentName name of the tournament
     * @throws IOException if there already exists a file under the name.
     */
    private void checkIfFileAlreadyExists(String tournamentName) throws IOException {
        String doesFileExist = TournamentWriter.ifFileExistsAndFindLocation(Utilities
                .shortenAndReplaceUnnecessarySymbolsInString(tournamentName));

        if (doesFileExist.equals("Ongoing") || doesFileExist.equals("Upcoming") || doesFileExist.equals("Previous")){
            warningLabel.setText("There is already a tournament file under this name");
            throw new IOException("There is already a tournament file under this name");
        }
    }

    /**
     * Method checks if prize pool related fields have values that are invalid.
     * @param prizePool prize pool of the tournament, has to be a positive integer
     * @param prizePoolCurrency prize pool currency of the tournament
     * @param entranceFee entrance fee of the tournament, has to be a positive integer
     * @param entranceFeeCurrency entrance fee currency of the tournament
     * @throws IOException if the fields have values that are invalid.
     */
    private void checkIfPrizePoolValuesAreValid(String prizePool, String prizePoolCurrency, String entranceFee,
                                           String entranceFeeCurrency)
    throws IOException{
        if (Utilities.areThereAnyOtherCharactersThanNumbers(prizePool) || prizePool.isEmpty()){
            warningLabel.setText("Prize pool has to be a positive integer");
            throw new IOException("Prize pool has to be a positive integer");
        }
        if (Integer.parseInt(prizePool) <= 0){
            warningLabel.setText("Prize pool has to be a positive integer");
            throw new IOException("Prize pool has to be a positive integer");
        }
        if (prizePoolCurrency.equals("null")){
            warningLabel.setText("Prize pool needs to be declared with a currency");
            throw new IOException("Prize pool needs to be declared with a currency");
        }
        if (Utilities.areThereAnyOtherCharactersThanNumbers(entranceFee) || entranceFee.isEmpty()){
            warningLabel.setText("Entrance fee has to be a positive integer");
            throw new IOException("Entrance fee has to be a positive integer");
        }
        if (Integer.parseInt(entranceFee) <= 0){
            warningLabel.setText("Entrance fee has to be a positive integer");
            throw new IOException("Entrance fee has to be a positive integer");
        }
        if (entranceFeeCurrency.equals("null")){
            warningLabel.setText("Entrance fee needs to be declared with a currency");
            throw new IOException("Entrance fee needs to be declared with a currency");
        }
    }

    /**
     * Method checks if the requested game is in the library.
     * @param game game to be played in tournament
     * @throws IOException if the requested game does not exist in the library.
     */
    private void checkThatGameExistsInLibrary(String game)
    throws IOException{
        if (!GeneralReader.isGameInLibrary(game)) {
            warningLabel.setText("The game you chose does not exist, or is not in library");
            throw new IOException("The game you chose does not exist, or is not in library");
        }

    }


    /**
     * Redirects to home page when clicked on home menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHomeButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.MAIN);
    }

    /**
     * Redirects to about page when clicked on about menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onAboutButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ABOUT);
    }

    /**
     * Redirects to ongoing tournaments page when clicked on ongoing tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onOngoingTournamentsButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.ONGOING_OVERVIEW);
    }

    /**
     * Redirects to upcoming tournaments page when clicked on upcoming tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onUpcomingTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.UPCOMING_OVERVIEW);
    }

    /**
     * Redirects to previous tournaments page when clicked on previous tournaments menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onPreviousTournamentsButtonPressed()
    throws IOException{
        ViewSwitcher.switchTo(View.PREVIOUS_OVERVIEW);
    }

    /**
     * Redirects to help page when clicked on help menu button
     * @throws IOException if scenes could not be switched
     */
    @FXML
    void onHelpButtonPressed()
    throws IOException {
        ViewSwitcher.switchTo(View.HELP);
    }
}
