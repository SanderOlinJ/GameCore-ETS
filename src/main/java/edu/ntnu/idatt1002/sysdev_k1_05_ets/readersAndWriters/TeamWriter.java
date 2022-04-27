package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import java.io.*;
import java.util.ArrayList;

/**
 * Class used for writing teams to the all_Teams.csv file
 */
public class TeamWriter {
    private static final String NEWLINE_DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";

    public TeamWriter(){}


    /**
     Method used for adding teams to the all_Teams.csv
     Method also edits already existing teams, if the input team
     has some, if not all, equal attributes to one of the teams in the list.
     * @param team team to be edited or added to all_Teams.csv
     * @throws IOException if all_Teams.csv file could not be read, or if file could not be written to.
     */
    public static void writeTeamsToFileAndOverwriteIfChanges(Team team)
    throws IOException{

        //Method first reads all the existing teams to a list
        ArrayList<Team> teams = TeamReader.readTeamsFromAllTeamsFile();

        int index = -1;

        /*Method then looks for similarities between the already existing teams and the input team.
        If an existing team matches the input team, the method stores the index slot in the index variable.
         */
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
        /*If there was an already existing team with some or all equal attributes,
        then the arraylist replaces the original instance with the updated one.
        If not, then it just appends the team.
         */
        if (index != -1){
            teams.set(index, team);
        } else {
            teams.add(team);
        }

        //The list of teams is then written back to the all_Teams.csv file
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
