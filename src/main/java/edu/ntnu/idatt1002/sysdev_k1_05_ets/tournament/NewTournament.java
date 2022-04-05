package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalDate;
import java.util.ArrayList;

public class NewTournament {
    private String tournamentName;
    private String tournamentHost;
    private LocalDate date;
    private String description;
    private String game;
    private String platform;
    private String tournamentType;
    private String numberOfTeams;
    private ArrayList<Team> teams;

    public NewTournament(String tournamentName, String tournamentHost, LocalDate date, String description,
                      String game, String platform, String tournamentType, String numberOfTeams) {
        if (tournamentName == null || tournamentHost.isEmpty()) {
            throw new IllegalArgumentException("Tournament name cannot be empty!");
        }
        if (tournamentHost == null || tournamentHost.isEmpty()){
            throw new IllegalArgumentException("Tournament host cannot be empty!");
        }
        if (date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Date cannot be in the past");
        }
        if (description == null || description.isEmpty()){
            description += "No description";
        }
        if (game == null || game.isEmpty()){
            throw new IllegalArgumentException("Game cannot be empty!");
        }
        if (platform == null || platform.isEmpty()){
            throw new IllegalArgumentException("Platform cannot be empty!");
        }
        if (tournamentType == null || tournamentType.isEmpty()){
            throw new IllegalArgumentException("Tournament type cannot be empty!");
        }
        if (numberOfTeams == null || numberOfTeams.isEmpty()){
            throw new IllegalArgumentException("Number of teams cannot be empty!");
        }
        this.tournamentName = tournamentName;
        this.tournamentHost = tournamentHost;
        this.date = date;
        this.description = description;
        this.game = game;
        this.platform = platform;
        this.tournamentType = tournamentType;
        this.numberOfTeams = numberOfTeams;
        this.teams = new ArrayList<>();
    }

    public NewTournament(String tournamentName, String tournamentHost, LocalDate date, String description,
                      String game, String platform, String tournamentType, String numberOfTeams,
                      ArrayList<Team> teams) {
        if (tournamentName == null || tournamentHost.isEmpty()) {
            throw new IllegalArgumentException("Tournament name cannot be empty!");
        }
        if (tournamentHost == null || tournamentHost.isEmpty()){
            throw new IllegalArgumentException("Tournament host cannot be empty!");
        }
        if (date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Date cannot be in the past");
        }
        if (description == null || description.isEmpty()){
            description += "No description";
        }
        if (game == null || game.isEmpty()){
            throw new IllegalArgumentException("Game cannot be empty!");
        }
        if (platform == null || platform.isEmpty()){
            throw new IllegalArgumentException("Platform cannot be empty!");
        }
        if (tournamentType == null || tournamentType.isEmpty()){
            throw new IllegalArgumentException("Tournament type cannot be empty!");
        }
        if (numberOfTeams == null || numberOfTeams.isEmpty()){
            throw new IllegalArgumentException("Number of teams cannot be empty!");
        }
        if (teams == null || teams.isEmpty()){
            throw new IllegalArgumentException("Teams cannot be empty!");
        }
        if (teams.size() != 4 || teams.size() != 8 || teams.size() != 16){
            throw new IllegalArgumentException("Number of teams has to be 4, 8 or 16");
        }
        this.tournamentName = tournamentName;
        this.tournamentHost = tournamentHost;
        this.date = date;
        this.description = description;
        this.game = game;
        this.platform = platform;
        this.tournamentType = tournamentType;
        this.numberOfTeams = numberOfTeams;
        this.teams.addAll(teams);
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getTournamentHost() {
        return tournamentHost;
    }

    public void setTournamentHost(String tournamentHost) {
        this.tournamentHost = tournamentHost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(String tournamentType) {
        this.tournamentType = tournamentType;
    }

    public String getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(String numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams.addAll(teams);
    }



}
