package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

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

    public static ArrayList<Team> readTeamsFromAllTeamsFile()
    throws IOException{
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<String> fileAsList = GeneralReader.readFile(new File("src/main/resources/edu/ntnu/" +
                "idatt1002/sysdev_k1_05_ets/teamFiles/all_Teams.csv"));

        for (String str : fileAsList){
            String[] values = str.split(DELIMITER);
            Team team = new Team(values[0], values[1]);
            for (int i = 2; i < values.length; i++){
                team.addMember(values[i]);
            }
            teams.add(team);
        }
        return teams;
    }


    public Team createTeamFromLine(String fileLine){
        String[] strArr = fileLine.split(",");
        String teamName = strArr[0];
        String teamNameAbbr = strArr[1];
        ArrayList<String> members = new ArrayList<>();
        members.addAll(Arrays.asList(strArr).subList(1, strArr.length));
        return new Team(members, teamName, teamNameAbbr);
    }

    public static Team findAndReturnTeamUsingTeamName(String teamName)
    throws IOException{
        Team teamFound = null;
        ArrayList<Team> teams = readTeamsFromAllTeamsFile();
        for (Team team : teams){
            if (team.getNameOfTeam().equals(teamName)){
                teamFound = team;
                break;
            }
        }
        if (teamFound == null){
            throw new IOException("Team was not found in the all_Teams.csv file");
        }
        return teamFound;
    }

    public static boolean isThereAlreadyATeamWithSameTeamName(Team team)
            throws IOException{
        ArrayList<Team> teams = TeamReader.readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){
            if (teamInFile.getNameOfTeam().equals(team.getNameOfTeam())){
                return true;
            }
        }
        return false;
    }

    public static boolean isThereAlreadyATeamWithSameTeamNameAbbreviation(Team team)
            throws IOException{
        ArrayList<Team> teams = TeamReader.readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){
            if (teamInFile.getNameAbbr().equals(team.getNameAbbr())){
                return true;
            }
        }
        return false;
    }

    public static boolean isThereAlreadyATeamWithSameTeamMembers(Team team)
            throws IOException{
        ArrayList<Team> teams = TeamReader.readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){
            if (teamInFile.getMembers().equals(team.getMembers())){
                return true;
            }
        }
        return false;
    }

    public static boolean wasThereChangesMadeToTeam(Team team)
    throws IOException{
        ArrayList<Team> teams = TeamReader.readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){
            if (teamInFile.equals(team)){
                return false;
            }
        }
        return true;
    }

    public static boolean isThisANewTeam(Team team)
    throws IOException{
        ArrayList<Team> teams = TeamReader.readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){
            if (teamInFile.getNameOfTeam().equals(team.getNameOfTeam()) ||
                    teamInFile.getNameAbbr().equals(team.getNameAbbr()) ||
                    teamInFile.getMembers().equals(team.getMembers())){
                return false;
            }
        }
        return true;
    }
}
