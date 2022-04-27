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
        int index = -1;
        for (int i = 0; i < teams.size(); i++){
            if (teams.get(i).getNameOfTeam().equals(team.getNameOfTeam())){
                index = i;
                break;
            } else if (teams.get(i).getNameAbbr().equals(team.getNameAbbr())){
                index = i;
                break;
            } else if (teams.get(i).getMembers().equals(team.getMembers())){
                index = i;
                break;
            }
        }
        if (index != -1){
            teams.set(index, team);
        } else {
            teams.add(team);
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
