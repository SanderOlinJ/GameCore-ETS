package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.util.ArrayList;
import java.util.Random;

public class Bracket {

    ArrayList<Team> teams;
    String nameOfTournament;
    String gameName;
    int numberOfTeams;
    int bracketSize;

    /**
     * Constructor that creates a bracket and sets tournament name
     * @param nameOfTournament
     */
    public Bracket(String nameOfTournament) {
        if (nameOfTournament == null || nameOfTournament.isEmpty()) {
            throw new IllegalArgumentException("Tournament name cannot be empty!");
        }
        this.nameOfTournament = nameOfTournament;
        this.teams = new ArrayList<>();
    }

    /**
     * Constructor that creates a bracket by passing in teams, name, game name and number of teams participating
     * @param teams
     * @param name
     * @param gameName
     * @param numberOfTeams
     */
    public Bracket(ArrayList<Team> teams, String nameOfTeam, String gameName, int numberOfTeams) {
        if (numberOfTeams > 32) {
            throw new IllegalArgumentException("Max number of teams = 32");
        }
        if (numberOfTeams < 1) {
            throw new IllegalArgumentException("Minimum number of teams = 2");
        }
        this.teams = new ArrayList<>();
        this.nameOfTournament = nameOfTeam;
        this.gameName = gameName;
        this.bracketSize = getNextPowerOf2(numberOfTeams);
        for(int i = 0; i <= bracketSize/2; i++){
            teams.add(new Team("TBD"));
        }

    }

    public Team getTeam(int teamNumber){
        return teams.get(teamNumber);
    }

    public void addTeam(Team team){
        this.teams.add(team);
    }

    public int getNumberOfTeams(){
        return teams.size();
    }

    public int getNextPowerOf2(int value){
        int highestOneBit = Integer.highestOneBit(value);
        if (value == highestOneBit) {
            return value;
        }
        return highestOneBit << 1;
    }

    public void seedBracket(){
        int bracketSize = getNextPowerOf2(getNumberOfTeams());
        int teamPosition = bracketSize/2;

    }

    public Team getTeamByName(String teamName){
        for (Team team : teams){
            if (team.getNameOfTeam().equals(teamName)){
                return team;
            }
        }
        return null;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    public Team randomlyRemoveTeam() {
        Random random = new Random();
        Team returnTeam = this.getTeam(random.nextInt(0,getNumberOfTeams()));
        removeTeam(returnTeam);
        return returnTeam;
    }
}
