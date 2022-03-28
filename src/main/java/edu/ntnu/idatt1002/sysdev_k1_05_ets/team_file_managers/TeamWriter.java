
package edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers;


import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.*;
import java.util.ArrayList;

public class TeamWriter {
    private static final String NEWLINE = "\n";
    private static final String DELIMITER = ",";

    public TeamWriter(){}

    public static void writeFile(ArrayList<Team> listOfTeams, String fileName) throws IOException {
        if (listOfTeams == null || listOfTeams.isEmpty()){
            throw new IOException("List of teams cannot be empty");
        }
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "teamFiles/" + fileName + ".csv",true)){
            for (Team team : listOfTeams){
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(team.getNameOfTeam()).append(DELIMITER);
                    for (int i = 0; i < team.getMembers().size(); i++){
                        stringBuilder.append(team.getMembers().get(i)).append(DELIMITER);
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                    stringBuilder.append(NEWLINE);
                    fileWriter.write(stringBuilder.toString());
                }catch (IOException e){
                    throw new IOException("Cannot write teams to file" + e.getMessage());
                }
            }
        }
    }

}
