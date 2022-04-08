package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class ResultsController {

    public void initialize(){
        for (int i = 0; i < matches.size(); i++){
            resultBox.getChildren().add(matches.get(i));
        }
    }
    @FXML
    private VBox resultBox;
    private static ArrayList<HBox> matches = new ArrayList<>();


    public static void addMatch(HBox match){
        matches.add(match);
    }


}
