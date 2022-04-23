
package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;


import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.*;
import java.util.ArrayList;

public class TeamWriter {
    private static final String NEWLINE = "\n";
    private static final String DELIMITER = ",";

    public TeamWriter(){}

    public static void writeFile(ArrayList<Team> listOfTeams) throws IOException {
        if (listOfTeams == null || listOfTeams.isEmpty()){
            throw new IOException("List of teams cannot be empty");
        }
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "teamFiles/all_Teams.csv",true)){
            for (Team team : listOfTeams){
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(team.getNameOfTeam()).append(DELIMITER);
                    stringBuilder.append(team.getNameAbbr()).append(DELIMITER);
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


    public static boolean removeInstanceOfTeam(Team team)
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
                stringBuilder.append(teamInFile.getNameOfTeam()).append(DELIMITER).append(teamInFile.getNameAbbr())
                        .append(DELIMITER);
                for (String member : teamInFile.getMembers()){
                    stringBuilder.append(member).append(",");
                }
                stringBuilder.append(NEWLINE);
            }
            fileWriter.write(stringBuilder.toString());
        }
        return false;
    }
}
