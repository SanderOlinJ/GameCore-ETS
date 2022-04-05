package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class NewTournamentWriter {

    private static final String DELIMITER = "\n";

    public NewTournamentWriter(){}


    public static void writeTournamentToFileWithoutTeams(
            String tournamentName, String tournamentHost, LocalDate date, String description, String game,
            String platform, String tournamentType, String numberOfTeams) throws IOException {

        description = description.replaceAll("\n"," ");
        if (description.equals("")){
            description += "No description";
        }

        boolean notFinished = true;
        String tournamentNameWithOutSpaces = tournamentName.replaceAll("\\s","");
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments" + tournamentNameWithOutSpaces + ".txt")){
            String str = tournamentName + DELIMITER + notFinished + DELIMITER + tournamentHost + DELIMITER +
                    date + DELIMITER + description + DELIMITER + game + DELIMITER + platform +
                    DELIMITER + tournamentType + DELIMITER + numberOfTeams +
                    DELIMITER;
            fileWriter.write(str);
        }
    }

    public static void writeTeamsToTournament(String tournamentName, ArrayList<Team> teams) throws IOException{
        String tournamentNameWithOutSpaces = tournamentName.replaceAll("\\s","");
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/" + tournamentNameWithOutSpaces + ".txt",true)){

            StringBuilder str = new StringBuilder();
            for (Team team : teams){
                str.append(team.getNameOfTeam()).append(DELIMITER);
            }
            fileWriter.write(str.toString());
        }
    }
}
