package edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers.AddTeamController;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers.BracketController;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Utilities {

    public static String shortenAndReplaceUnnecessarySymbolsInString(String str){
        return str.replaceAll("[^A-Za-z0-9]","");
    }

    public static String getPathToGameImageFile(String gameAsString){
        gameAsString = shortenAndReplaceUnnecessarySymbolsInString(gameAsString);
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/gameImages/%s",
                gameAsString) + ".png";
    }

    public static String getPathToBracketImageFile(String bracketFormatAsString){
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/bracketFormats/%s",
                bracketFormatAsString) + ".png";
    }

    public static void showGameInfo(Label tournamentName, String nameOfTournament, ImageView imageView, NewTournament tournament, Label game, Label host, Label startDate, Label startTime, Label platform, Label prizePool, Label entranceFee, Label prizePoolCurrency, Label entranceFeeCurrency) {
        tournamentName.setText(nameOfTournament);
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

    public static void onTournamentOverviewButtonClicked(NewTournament newTournament)
            throws IOException {
        int numberOfTeams = newTournament.getTeams().size();
        if (numberOfTeams != newTournament.getNumberOfTeams()){
            AddTeamController.setNameOfTournament(newTournament.getTournamentName());
            ViewSwitcher.switchTo(View.ADD_TEAM);
        }
        switch (numberOfTeams){
            case 4 -> {
                BracketController.setNameOfTournament(newTournament.getTournamentName());
                ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_4);}
            case 8 -> {BracketController.setNameOfTournament(newTournament.getTournamentName());
                ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_8);}
            case 16 -> {BracketController.setNameOfTournament(newTournament.getTournamentName());
                ViewSwitcher.switchTo(View.TOURNAMENT_OVERVIEW_16);}
        }
    }
}
