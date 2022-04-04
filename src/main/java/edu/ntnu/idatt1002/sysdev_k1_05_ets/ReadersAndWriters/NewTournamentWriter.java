package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NewTournamentWriter {

    private static final String NEWLINE = "\n";
    private static final String DELIMITER = ",";

    public NewTournamentWriter(){}


    public static void writeTournamentToFileWithoutTeams(
            String tournamentName, String tournamentHost, String description, String game, String platform,
            String tournamentType, String totalTeams) throws IOException {

        String tournamentNameWithOutSpaces = tournamentName.replaceAll("\\s","");
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/" + tournamentNameWithOutSpaces + ".csv")){
            String str = tournamentName + DELIMITER + tournamentHost + DELIMITER +
                    description + DELIMITER + game + DELIMITER + platform +
                    DELIMITER + tournamentType + DELIMITER + totalTeams +
                    DELIMITER;
            fileWriter.write(str);
        }
    }

    public static void writeTeamsToTournament(String tournamentName, ArrayList<Team> teams) throws IOException{
        String tournamentNameWithOutSpaces = tournamentName.replaceAll("\\s","");
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/" + tournamentNameWithOutSpaces + ".csv",true)){
            StringBuilder str = new StringBuilder();
            for (Team team : teams){
                str.append(team.getNameOfTeam()).append(DELIMITER);
            }
            fileWriter.write(str.toString());
        }
    }
}
