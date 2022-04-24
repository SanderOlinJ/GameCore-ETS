package edu.ntnu.idatt1002.sysdev_k1_05_ets;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.View;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes.ViewSwitcher;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameCoreETSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.START);
        stage.setMinHeight(800);
        stage.setMinWidth(1200);
        stage.getIcons()
                .add(new Image("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/ETSicon.png"));
        stage.setTitle("ETS GameCore");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
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
}