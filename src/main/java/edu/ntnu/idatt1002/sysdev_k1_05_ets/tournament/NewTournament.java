package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class for describing a tournament
 */

public class NewTournament {
    private String status;
    private String tournamentName;
    private String tournamentHost;
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String game;
    private String platform;
    private String tournamentType;
    private String numberOfTeams;
    private String prizePool;
    private String prizePoolCurrency;
    private String entranceFee;
    private String entranceFeeCurrency;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    /**
     * The first constructor. I takes the tournament name and throws an exception if it is
     * null/empty
     * @param tournamentName the tournament name
     */

    public NewTournament(String tournamentName){
        if (tournamentName == null || tournamentName.isEmpty()) {
            throw new IllegalArgumentException("Tournament name cannot be empty!");
        }
        this.tournamentName = tournamentName;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    /**
     * The second constructor. It takes the status, the tournament name, the tournament host,
     * the date, the time, the description, the game, the platform, the tournament type, the number of teams,
     * the prize pool, the prize pool currency, the entrance fee and the entrance fee currency. It throws an
     * exception if any of these are null/empty. It also throws an exception if the currency
     * in any of the currency-parameters are not 'NOK', 'USD', 'EUR' or 'GBP'.
     * @param status tournament status
     * @param tournamentName tournament name
     * @param tournamentHost tournament host
     * @param date the date of the tournament
     * @param time the time of the tournament
     * @param description the description
     * @param game the game to be played
     * @param platform the platform to be played on
     * @param tournamentType tournament type
     * @param numberOfTeams number of teams
     * @param prizePool the prize pool
     * @param prizePoolCurrency prize pool currency
     * @param entranceFee entrance fee
     * @param entranceFeeCurrency entrance fee currency
     */
    public NewTournament(String status, String tournamentName, String tournamentHost, LocalDate date,
                         LocalTime time, String description, String game, String platform,
                         String tournamentType, String numberOfTeams,
                         String prizePool, String prizePoolCurrency,
                         String entranceFee, String entranceFeeCurrency) {
        if (status == null || status.isEmpty()){
            throw new IllegalArgumentException("Status cannot be empty!");
        }
        if (tournamentName == null || tournamentName.isEmpty()) {
            throw new IllegalArgumentException("Tournament name cannot be empty!");
        }
        if (tournamentHost == null || tournamentHost.isEmpty()){
            throw new IllegalArgumentException("Tournament host cannot be empty!");
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
        if (prizePool == null || prizePool.isEmpty()){
            throw new IllegalArgumentException("Prize pool cannot be empty!");
        }
        if (!prizePoolCurrency.equals("NOK") && !prizePoolCurrency.equals("USD") && !prizePoolCurrency.equals("EUR")
                && !prizePoolCurrency.equals("GBP") && !prizePoolCurrency.equals("null")){
            throw new IllegalArgumentException("Invalid prize pool-currency!");
        }
        if (entranceFee == null || entranceFee.isEmpty()){
            throw new IllegalArgumentException("Entrance fee cannot be empty!");
        }

        if (!entranceFeeCurrency.equals("NOK") && !entranceFeeCurrency.equals("USD")
                && !entranceFeeCurrency.equals("EUR") && !entranceFeeCurrency.equals("GBP")
                && !entranceFeeCurrency.equals("null")){
            throw new IllegalArgumentException("Invalid entrance fee-currency!");
        }
        this.status = status;
        this.tournamentName = tournamentName;
        this.tournamentHost = tournamentHost;
        this.date = date;
        this.time = time;
        this.description = description;
        this.game = game;
        this.platform = platform;
        this.tournamentType = tournamentType;
        this.numberOfTeams = numberOfTeams;
        this.prizePool = prizePool;
        this.prizePoolCurrency = prizePoolCurrency;
        this.entranceFee = entranceFee;
        this.entranceFeeCurrency = entranceFeeCurrency;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }
    /**
     * The second constructor. It takes the status, the tournament name, the tournament host,
     * the date, the time, the description, the game, the platform, the tournament type, the number of teams,
     * the prize pool, the prize pool currency, the entrance fee, the entrance fee currency and
     * the teams. It throws an
     * exception if any of these are null/empty. It also throws an exception if the currency
     * in any of the currency-parameters are not 'NOK', 'USD', 'EUR' or 'GBP'. And also if the number of
     * teams are not 4, 8 or 16.
     * @param status tournament status
     * @param tournamentName tournament name
     * @param tournamentHost tournament host
     * @param date the date of the tournament
     * @param time the time of the tournament
     * @param description the description
     * @param game the game to be played
     * @param platform the platform to be played on
     * @param tournamentType tournament type
     * @param numberOfTeams number of teams
     * @param prizePool the prize pool
     * @param prizePoolCurrency prize pool currency
     * @param entranceFee entrance fee
     * @param entranceFeeCurrency entrance fee currency
     * @param teams the teams
     */
    public NewTournament(String status, String tournamentName, String tournamentHost, LocalDate date,
                         LocalTime time, String description, String game, String platform,
                         String tournamentType, String numberOfTeams, String prizePool,
                         String prizePoolCurrency, String entranceFee, String entranceFeeCurrency,
                         ArrayList<Team> teams) {
        if (status == null || status.isEmpty()){
            throw new IllegalArgumentException("Status cannot be empty!");
        }
        if (tournamentName == null || tournamentName.isEmpty()) {
            throw new IllegalArgumentException("Tournament name cannot be empty!");
        }
        if (tournamentHost == null || tournamentHost.isEmpty()){
            throw new IllegalArgumentException("Tournament host cannot be empty!");
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
        if (prizePool == null || prizePool.isEmpty()){
            throw new IllegalArgumentException("Prize pool cannot be empty!");
        }
        if (!prizePoolCurrency.equals("NOK") && !prizePoolCurrency.equals("USD") && !prizePoolCurrency.equals("EUR")
                && !prizePoolCurrency.equals("GBP") && !prizePoolCurrency.equals("null")){
            throw new IllegalArgumentException("Invalid prize-pool currency!");
        }
        if (entranceFee == null || entranceFee.isEmpty()){
            throw new IllegalArgumentException("Entrance fee cannot be empty!");
        }

        if (!entranceFeeCurrency.equals("NOK") && !entranceFeeCurrency.equals("USD")
                && !entranceFeeCurrency.equals("EUR") && !entranceFeeCurrency.equals("GBP")
                && !entranceFeeCurrency.equals("null")){
            throw new IllegalArgumentException("Invalid entrance fee-currency!");
        }
        if (teams == null || teams.isEmpty()){
            throw new IllegalArgumentException("Teams cannot be empty!");
        }
        if (teams.size() != 4 && teams.size() != 8 && teams.size() != 16){
            throw new IllegalArgumentException("Number of teams has to be 4, 8 or 16");
        }
        this.tournamentName = tournamentName;
        this.tournamentHost = tournamentHost;
        this.date = date;
        this.time = time;
        this.description = description;
        this.game = game;
        this.platform = platform;
        this.tournamentType = tournamentType;
        this.numberOfTeams = numberOfTeams;
        this.prizePool = prizePool;
        this.prizePoolCurrency = prizePoolCurrency;
        this.entranceFee = entranceFee;
        this.entranceFeeCurrency = entranceFeeCurrency;
        this.teams = new ArrayList<>();
        this.teams.addAll(teams);
        this.matches = new ArrayList<>();
    }

    /**
     * Returns the prizepool
     * @return prize pool
     */
    public String getPrizePool() {
        return prizePool;
    }

    /**
     * Sets prize pool
     * @param prizePool
     */
    public void setPrizePool(String prizePool) {
        this.prizePool = prizePool;
    }

    /**
     * Returns the prize pool currency
     * @return prize pool currency
     */
    public String getPrizePoolCurrency() {
        return prizePoolCurrency;
    }

    /**
     * Sets the prize pool curreny
     * @param prizePoolCurrency
     */
    public void setPrizePoolCurrency(String prizePoolCurrency) {
        this.prizePoolCurrency = prizePoolCurrency;
    }

    /**
     * Returns the entrance fee
     * @return entrance fee
     */
    public String getEntranceFee() {
        return entranceFee;
    }

    /**
     * Sets the entrance fee
     * @param entranceFee
     */
    public void setEntranceFee(String entranceFee) {
        this.entranceFee = entranceFee;
    }

    /**
     * Returns the entrance fee currency
     * @return entrance fee currency
     */
    public String getEntranceFeeCurrency() {
        return entranceFeeCurrency;
    }

    /**
     * Sets the entrance fee currency
     * @param entranceFeeCurrency
     */
    public void setEntranceFeeCurrency(String entranceFeeCurrency) {
        this.entranceFeeCurrency = entranceFeeCurrency;
    }

    /**
     * Returns the time of the tournament
     * @return time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Sets the time of the tournamnet
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Returns the status of the tournament
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status if the tournament
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the matches
     * @return matches
     */
    public ArrayList<Match> getMatches() {
        return matches;
    }

    /**
     * Sets the matches
     * @param matches
     */
    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    /**
     * Returns the tournament name
     * @return tournament name
     */
    public String getTournamentName() {
        return tournamentName;
    }

    /**
     * Sets the tournament name
     * @param tournamentName
     */
    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    /**
     * Returns the tournament host
     * @return tournament host
     */
    public String getTournamentHost() {
        return tournamentHost;
    }

    /**
     * Sets the tournament host
     * @param tournamentHost
     */
    public void setTournamentHost(String tournamentHost) {
        this.tournamentHost = tournamentHost;
    }

    /**
     * Returns thedate of the tournament
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the tournament
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the description of the tournament
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the tournament
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the game to be played
     * @return game to be played
     */
    public String getGame() {
        return game;
    }

    /**
     * Sets the game to be played
     * @param game
     */
    public void setGame(String game) {
        this.game = game;
    }

    /**
     * Returns the platform to be played on
     * @return
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform to be played on
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Returns the tournament type
     * @return tournament type
     */
    public String getTournamentType() {
        return tournamentType;
    }

    /**
     * Sets the tournament type
     * @param tournamentType
     */
    public void setTournamentType(String tournamentType) {
        this.tournamentType = tournamentType;
    }

    /**
     * Returns the number of teams
     * @return number of teams
     */
    public String getNumberOfTeams() {
        return numberOfTeams;
    }

    /**
     * Sets the number of teams
     * @param numberOfTeams
     */
    public void setNumberOfTeams(String numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    /**
     * Returns the teams of the tournament
     * @return teams
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Adds teams to the list of teams
     * @param teams
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams.addAll(teams);
    }

    /**
     * Returns a string containing information about the tournament
     * @return status, tournament name, tournament host, date, description, game, platform,
     * tournament type, number of teams, teams and matches as a string
     */
    @Override
    public String toString() {
        return "NewTournament{" +
                "status='" + status + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentHost='" + tournamentHost + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", game='" + game + '\'' +
                ", platform='" + platform + '\'' +
                ", tournamentType='" + tournamentType + '\'' +
                ", numberOfTeams='" + numberOfTeams + '\'' +
                ", teams=" + teams + "\n" +
                ", matches=" + matches + "\n" +
                '}';
    }

    /**
     * Returns the team that corresponds to the team name given
     * @param teamName
     * @return team
     */
    public Team getTeamByName(String teamName){
        for (Team team : teams){
            if (team.getNameOfTeam().equals(teamName)){
                return team;
            }
        }
        return null;
    }

    /**
     * Adds a team to the list of teams
     * @param team
     */
    public void addTeam(Team team){
        this.teams.add(team);
    }

    /**
     * Finds the next match to be played by first creating a list of matches that are not finished
     * and then finding the match that is nearest in the future
     * @return next match to be played
     */
    public Match findNextMatchToBePlayed(){
        Match nextMatch = null;

        ArrayList<Match> notFinishedMatches = new ArrayList<>();
        if (this.matches.size() > 0) {
            for (Match match : matches) {
                if (!match.isFinished() && match.getTimeOfMatch() != null) {
                    notFinishedMatches.add(match);
                }
            }
            if (notFinishedMatches.size() > 0) {
                LocalTime time = notFinishedMatches.get(0).getTimeOfMatch();
                nextMatch = notFinishedMatches.get(0);
                if (notFinishedMatches.size() > 1) {
                    for (int i = 1; i < notFinishedMatches.size(); i++) {
                        if (notFinishedMatches.get(i).getTimeOfMatch().isBefore(time)) {
                            time = notFinishedMatches.get(i).getTimeOfMatch();
                            nextMatch = notFinishedMatches.get(i);
                        }
                    }
                }
            }
        }
        return nextMatch;
    }

    /**
     * Returns true if the tournament has an unfinished match that is set, false if not
     * @return true or false
     */
    public boolean doesTournamentHaveAnUnfinishedAndSetMatch(){

        if (this.matches.size() > 0){
            for (Match match : matches){
                if (!match.isFinished() && match.getTimeOfMatch() != null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the number of unfinished teams left
     * @return number of unfinished teams left
     */
    public int findNumberOfTeamsLeft(){
        int numberOfTeamsLeft = Integer.parseInt(getNumberOfTeams());

        if (this.matches.size() > 0){
            for (Match match : matches){
                if (match.isFinished()){
                    numberOfTeamsLeft--;
                }
            }
        }
        return numberOfTeamsLeft;

    }

    /**
     * Randomly removes a team from teams and returns it
     * @return team
     */
    public Team randomlyRemoveTeam() {
        Random random = new Random();
        Team returnTeam = this.getTeams().get(random.nextInt(getTeams().size()));
        removeTeam(returnTeam);
        return returnTeam;
    }

    /**
     * Removes the given team from teams
     * @param team
     */
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }
}
