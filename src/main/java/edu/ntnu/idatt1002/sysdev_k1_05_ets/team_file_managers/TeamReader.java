package edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamReader {
    private static final String DELIMITER = ",";

    public TeamReader(){}

    public static ArrayList<Team> readFile(String tournamentName) throws IOException{
        ArrayList<Team> returnList = null;
        try (Scanner scanner = new Scanner("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "teamFiles/"+tournamentName+".csv")){
            if (!scanner.hasNext()){
                throw new IOException("File is empty");
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] values = line.split(DELIMITER);
                Team team = new Team(values[0]);
                for (int i = 1; i < values.length; i++){
                    team.addMember(values[i]);
                }
                returnList.add(team);
            }
        }
        return returnList;
    }
}
