package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for reading Teams from the all_Teams.csv file into Team objects.
 */
public class TeamReader {
    private static final String COMMA_DELIMITER = ",";

    public TeamReader(){}

    /**
     Method used for returning all Teams in the all_Teams.csv as a list of Teams
     * @return list all Teams in the all_Teams.csv file
     * @throws IOException if file could not be read through
     */
    public static ArrayList<Team> readTeamsFromAllTeamsFile()
    throws IOException{

        //Method first reads through the file and returns the data.
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<String> fileAsList = GeneralReader.readFile(new File("src/main/resources/edu/ntnu/" +
                "idatt1002/sysdev_k1_05_ets/teamFiles/all_Teams.csv"));

        for (String str : fileAsList){
            //The lines of data are then split up.
            String[] values = str.split(COMMA_DELIMITER);
            //The first two values are the team name and team name abbreviation.
            Team team = new Team(values[0], values[1]);
            //We then add a number of members to the team.
            for (int i = 2; i < values.length; i++){
                team.addMember(values[i]);
            }
            //The team is the added to the list
            teams.add(team);
        }
        return teams;
    }

    /**
     * MEthod used for finding the Team based on the Team name
     * @param teamName name of team that you want
     * @return a Team, if a Team with that name was found
     * @throws IOException if file could be read from, or if team doesn't exist
     */
    public static Team findAndReturnTeamUsingTeamName(String teamName)
    throws IOException{

        Team teamFound = null;

        //Method first read out all the teams from the all_Teams.csv file
        ArrayList<Team> teams = readTeamsFromAllTeamsFile();
        for (Team team : teams){

            //The team is then returned if found
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

    /**
     * Method checks if there is already a team with the same team name as the input team
     * @param team input team
     * @return true if there is, false if not
     * @throws IOException if file could not be read from
     */
    public static boolean isThereAlreadyATeamWithSameTeamName(Team team)
            throws IOException{
        //Method first reads all teams
        ArrayList<Team> teams = readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){

            //Then returns true if name of the team is equal to the input team
            if (teamInFile.getNameOfTeam().equals(team.getNameOfTeam())){
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if there is already a team with the same team name abbreviation as the input team
     * @param team input team
     * @return true if there is, false if not
     * @throws IOException if file could not be read from
     */
    public static boolean isThereAlreadyATeamWithSameTeamNameAbbreviation(Team team)
            throws IOException{
        //Method first reads all teams
        ArrayList<Team> teams = readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){

            //Then returns true if team name abbreviation is equal to the input team
            if (teamInFile.getNameAbbr().equals(team.getNameAbbr())){
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if there is already a team with the same team members as the input team
     * @param team input team
     * @return true if there is, false if not
     * @throws IOException if file could not be read from
     */
    public static boolean isThereAlreadyATeamWithSameTeamMembers(Team team)
            throws IOException{
        //Method first reads all teams
        ArrayList<Team> teams = readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){

            //Then returns true if team members are equal to the input team
            if (teamInFile.getMembers().equals(team.getMembers())){
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if the there is a team with all or none similar attributes to the input team.
     * @param team input team
     * @return true if there is no team in the file that are equal to the input team, false if there is.
     * @throws IOException if file could not be read from.
     */
    public static boolean wasThereChangesMadeToTeam(Team team)
    throws IOException{
        ArrayList<Team> teams = readTeamsFromAllTeamsFile();
        for (Team teamInFile : teams){
            if (teamInFile.equals(team)){
                return false;
            }
        }
        return true;
    }

    /**
     * Method checks if the input team have unique new values compared to any of the already existing teams.
     * @param team input team
     * @return true if the input teams have unique values compared to the already existing teams,
     * false if it does not.
     * @throws IOException if file could not be read from.
     */
    public static boolean isThisANewTeam(Team team)
    throws IOException{
        ArrayList<Team> teams = readTeamsFromAllTeamsFile();
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
