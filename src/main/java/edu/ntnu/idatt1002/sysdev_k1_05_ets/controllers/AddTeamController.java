package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.MainApplication;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers.TeamReader;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers.TeamWriter;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTeamController {

    private Scene scene;
    private Stage stage;
    private ArrayList<Team> existingTeams;
    private Pane p = new Pane();
    private Pane pC = new Pane();


    private static int maxTeams;

    @FXML
    TextField teamNameField;

    @FXML
    TextArea playersNameField;

    @FXML
    Label warningLabel;

    @FXML
    Label existingTeamsAdd;

    @FXML
    ScrollPane scrollPane;

    @FXML
    ScrollPane currentTeams;


    @FXML
    public void setMainScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("scenes/start-screen.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setBracketScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainApplication.class.getResource("brackets/eight_team_bracket.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addTeamExisting(String teamName){
        for (Team team : existingTeams) {
            if (team.getNameOfTeam().equals(teamName)) {
                EightTeamController.getBracket().addTeam(team);
                Label newTeam = new Label(teamName);
                pC.getChildren().add(newTeam);
            }
        }
        existingTeamsAdd.setText(teamName + " has been added to your tournament");
        setCurrentTeams();
    }


    @FXML
    public void initialize () throws IOException {
        scrollPane.setContent(null);
        TeamReader readExistingTeams = new TeamReader();
        existingTeams = new ArrayList<>(readExistingTeams.readFile(
                new File("src/main/resources/edu/ntnu/idatt1002" +
                        "/sysdev_k1_05_ets/" + "teamFiles/all_Teams.csv")));
        for (int i = 0; i < existingTeams.size(); i++){
            Label teamLabel = new Label();
            teamLabel.setText(existingTeams.get(i).getNameOfTeam());
            p.getChildren().add(teamLabel);
            p.getChildren().get(i).setOnMouseClicked
                    (mouseEvent -> addTeamExisting(teamLabel.getText()));
            p.getChildren().get(i).setLayoutY(20 * i);

        }
        scrollPane.setContent(p);
    }



    public void addTeam(ActionEvent actionEvent) throws IOException {
        if (teamNameField.getText().strip().equals("")){
            warningLabel.setText("Invalid team name.");
        }
        //check if max amount of teams has been exceeded
        if(EightTeamController.getBracket().getTeams().size() >= maxTeams){
            warningLabel.setText("You have reached the maximum number of teams for this tournament. \n"
            + "max teams: "+maxTeams);
        }

        else {
            warningLabel.setText("");
            if (playersNameField.getText().isBlank()){
                EightTeamController.getBracket().addTeam(new Team(teamNameField.getText()));
                teamNameField.setText("");
                Label newTeam = new Label(teamNameField.getText());
                pC.getChildren().add(newTeam);
            } else {
                String[] players = playersNameField.getText().split("\n");
                List<String> returnList = Arrays.asList(players);
                ArrayList<String> returnListFinal = new ArrayList<String>();
                returnListFinal.addAll(returnList);
                Team addedTeam = new Team(returnListFinal, teamNameField.getText());
                Label newTeam = new Label(teamNameField.getText());
                pC.getChildren().add(newTeam);
                EightTeamController.getBracket().addTeam(addedTeam);
                ArrayList<Team> writeTeamList = new ArrayList<>();
                writeTeamList.add(addedTeam);
                TeamWriter.writeFile(writeTeamList,"all_Teams");
                System.out.println(teamNameField.getText());
                for (String string : players){
                    System.out.println(string);
                }
                setCurrentTeams();
                playersNameField.setText("");
                teamNameField.setText("");

            }
        }
    }

    public void setCurrentTeams(){
        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0f);
        ds.setColor(Color.color(0.1f, 0.1f, 0.1f));
        for (int i = 0; i < pC.getChildren().size(); i++) {
            pC.getChildren().get(i).setLayoutY(20 * i);
            pC.getChildren().get(i).setEffect(ds);
            pC.getChildren().get(i).setCache(true);

            //scaling
            pC.getChildren().get(i).setScaleY(1);
            pC.getChildren().get(i).setScaleX(1);
        }
        currentTeams.setContent(pC);
    }


    public static void setMaxTeams(int maxNrOfTeams) {
        maxTeams = maxNrOfTeams;
    }

}
