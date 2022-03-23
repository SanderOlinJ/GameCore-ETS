
package edu.ntnu.idatt1002.sysdev_k1_05_ets;


import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class teamWriter {
    private static final String NEWLINE = "\n";
    private static final String DELIMITER = ",";

    public teamWriter(){}

    public static void writeFile(ArrayList<Team> listOfTeams) throws IOException {
        if (listOfTeams == null || listOfTeams.isEmpty()){
            throw new IOException("List of teams cannot be empty");
        }
        try (FileWriter fileWriter = new FileWriter("src/main/resources/teamFiles/8_team_file.csv")){
            for (Team team : listOfTeams){
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(team.getNameOfTeam());
                    for (int i = 0; i < team.getMembers().size(); i++){
                        stringBuilder.append(team.getMembers().get(i) + DELIMITER);
                    }
                    stringBuilder.append(NEWLINE);
                    fileWriter.write(stringBuilder.toString());
                }catch (IOException e){
                    throw new IOException("Cannot write teams to file" + e.getMessage());
                }
            }
        }
    }

}
