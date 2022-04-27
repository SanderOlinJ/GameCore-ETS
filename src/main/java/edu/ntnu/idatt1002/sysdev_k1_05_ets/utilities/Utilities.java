package edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers.AddTeamController;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers.BracketController;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * Class for doing tasks that are generally used in other classes
 */
public class Utilities {

    /**
     * Method replaces all characters except alphanumeric symbols.
     * @param str input string
     * @return string without characters that are non-alphanumeric.
     */
    public static String shortenAndReplaceUnnecessarySymbolsInString(String str){
        return str.replaceAll("[^A-Za-z0-9]","");
    }

    /**
     * Method replaces all characters that are not letters.
     * @param str input string
     * @return string without characters that are non-numeric.
     */
    public static boolean areThereAnyOtherCharactersThanNumbers(String str){
        return str.length() > str.replaceAll("[^0-9]", "").length();
    }

    /**
     * Method for getting file path to game image
     * @param gameAsString game name as string
     * @return path to game image as string
     */
    public static String getPathToGameImageFile(String gameAsString){
        gameAsString = shortenAndReplaceUnnecessarySymbolsInString(gameAsString);
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/gameImages/%s",
                gameAsString) + ".png";
    }

    /**
     * Method for getting file path to bracket image
     * @param bracketFormatAsString bracket format as string
     * @return path to bracket format image as string
     */
    public static String getPathToBracketImageFile(String bracketFormatAsString){
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/bracketFormats/%s",
                bracketFormatAsString) + ".png";
    }

    /**
     * Method takes in a tournament name, labels and imageview to
     * assign values to the labels and the imageview
     * @param tournamentName label where tournament name is displayed
     * @param imageView imageview where the game image is displayed
     * @param tournament input tournament
     * @param game label where game name is displayed
     * @param host label where host is displayed
     * @param startDate label where start date is displayed
     * @param startTime label where start time is displayed
     * @param platform label where platform is displayed
     * @param prizePool label where prize pool is displayed
     * @param entranceFee label where entrance fee is displayed
     * @param prizePoolCurrency label where prize pool currency is displayed
     * @param entranceFeeCurrency label where entrance fee currency is displayed
     */
    public static void showGameInfo(Label tournamentName, ImageView imageView,
                                    Tournament tournament, Label game, Label host, Label startDate,
                                    Label startTime, Label platform, Label prizePool, Label entranceFee,
                                    Label prizePoolCurrency, Label entranceFeeCurrency) {

        //Method assigns values to the labels and the image view
        tournamentName.setText(tournament.getTournamentName());
        imageView.setImage(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "Images/gameImages/" + Utilities.shortenAndReplaceUnnecessarySymbolsInString
                (tournament.getGame()) + ".png"));
        game.setText(tournament.getGame());
        host.setText(tournament.getTournamentHost());
        startDate.setText(tournament.getDate().toString());
        startTime.setText(tournament.getTime().toString());
        platform.setText(tournament.getPlatform());

        prizePool.setText(String.valueOf(tournament.getPrizePool()));
        if (tournament.getEntranceFee() == -1) {
            entranceFee.setText("0");
        } else {
            entranceFee.setText(String.valueOf(tournament.getEntranceFee()));
        }
        if (tournament.getPrizePool() != 0) {
            prizePoolCurrency.setText(tournament.getPrizePoolCurrency());
            entranceFeeCurrency.setText(tournament.getPrizePoolCurrency());
        }
    }

    /**
     * Method for switching scenes when a tournament in the different overview pages are clicked.
     * @param tournament input tournament
     * @throws IOException if scenes cannot be switched.
     */
    public static void onTournamentOverviewButtonClicked(Tournament tournament)
            throws IOException {
        /*
        Method sends the tournament name to the next Controller,
         so that the tournament from file may be read there.
         */
        /*
        If the registered teams in the tournament does not correspond to the bracket size,
        then the method switches scenes to the Add Team page
         */
        int numberOfTeams = tournament.getTeams().size();
        if (numberOfTeams != tournament.getNumberOfTeams()){
            AddTeamController.setNameOfTournament(tournament.getTournamentName());
            ViewSwitcher.switchTo(View.ADD_TEAM);
        }
        //If all teams are registered, then the method switches scenes to the Bracket Overview page
        switch (numberOfTeams){
            case 4 -> {
                BracketController.setNameOfTournament(tournament.getTournamentName());
                ViewSwitcher.switchTo(View.BRACKET_4);}
            case 8 -> {BracketController.setNameOfTournament(tournament.getTournamentName());
                ViewSwitcher.switchTo(View.BRACKET_8);}
            case 16 -> {BracketController.setNameOfTournament(tournament.getTournamentName());
                ViewSwitcher.switchTo(View.BRACKET_16);}
        }
    }
}
