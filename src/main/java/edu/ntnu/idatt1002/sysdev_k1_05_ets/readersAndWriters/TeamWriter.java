package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import java.io.*;
import java.util.ArrayList;

public class TeamWriter {
    private static final String NEWLINE_DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";

    public TeamWriter(){}

    public static void writeTeamsToFileAndOverwriteIfChanges(Team team)
    throws IOException{
        ArrayList<Team> teams = TeamReader.readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){
            int index = teams.indexOf(teamInFile);
            if (teamInFile.getNameOfTeam().equals(team.getNameOfTeam())){
                teams.set(index, team);
                break;
            }
            else if (teamInFile.getNameAbbr().equals(team.getNameAbbr())){
                teams.set(index, team);
                break;
            }
            else if (teamInFile.getMembers().equals(team.getMembers())){
                teams.set(index, team);
                break;
            }
        }

        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "teamFiles/all_Teams.csv")){
            StringBuilder stringBuilder = new StringBuilder();
            for (Team teamInFile : teams){
                stringBuilder.append(teamInFile.getNameOfTeam()).append(COMMA_DELIMITER).append(teamInFile.getNameAbbr())
                        .append(COMMA_DELIMITER);
                for (String member : teamInFile.getMembers()){
                    stringBuilder.append(member).append(",");
                }
                stringBuilder.append(NEWLINE_DELIMITER);
            }
            fileWriter.write(stringBuilder.toString());
        }
    }
}
