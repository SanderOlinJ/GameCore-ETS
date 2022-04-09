package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TeamReader {
    private static final String DELIMITER = ",";

    public TeamReader(){}

    public ArrayList<Team> readFile(File file) throws IOException{
        ArrayList<Team> returnList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)){
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


    public static String readTeamsFileAtLine(String teamFileName, int n){
        n = Math.abs(n)-1;
        String line = null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/teamFiles/"+teamFileName+".csv"
        ))){
            for(int i = 0; i<n; i++){
                bufferedReader.readLine();
            }
            line = bufferedReader.readLine();
            return line;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }

    public Team createTeamFromLine(String fileLine){
        String[] strArr = fileLine.split(",");
        String teamName = strArr[0];
        String teamNameAbbr = strArr[1];
        ArrayList<String> members = new ArrayList<>();
        members.addAll(Arrays.asList(strArr).subList(1, strArr.length));
        return new Team(members, teamName, teamNameAbbr);
    }


    public String convertTournamentFileToText(String tournamentName) throws IOException {
        ArrayList<Team> teams = new ArrayList<>();
        for(int i = 1; i<= Files.lines(Paths.get("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "teamFiles/"+tournamentName+".csv")).count(); i++){

            String readLines = readTeamsFileAtLine(tournamentName, i);
            Team team = createTeamFromLine(readLines);
            teams.add(team);
        }


        StringBuilder str = new StringBuilder();
        teams.forEach(t -> str.append("Team name: ").append(t.getNameOfTeam()).append(", Team members: ").append(t.getMembersAsText()).append("\n"));
        return str.toString();
    }

}
