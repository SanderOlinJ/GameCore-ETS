package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * tournament represents all the attributes and variables that makes up a tournament
 * It is used to store tournament information in object, after reading for file.
 */

public class Tournament {
    private String status;
    private String tournamentName;
    private String tournamentHost;
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String game;
    private String platform;
    private String tournamentType;
    private int numberOfTeams;
    private int prizePool;
    private String prizePoolCurrency;
    private int entranceFee;
    private String entranceFeeCurrency;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    /**
     * The first constructor.
     * It takes the tournament name and throws an exception if it is null/empty
     * @param tournamentName the name of the tournament
     */

    public Tournament(String tournamentName){
        if (tournamentName == null || tournamentName.isEmpty()) {
            throw new IllegalArgumentException("tournament name cannot be empty!");
        }
        this.tournamentName = tournamentName;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    /**
     * The second constructor.
     * It throws an exception if any of the parameters have illegal value i.e. "null".
     * @param status status of the tournament
     * @param tournamentName name of the tournament
     * @param tournamentHost host of the tournament
     * @param date date of the tournament
     * @param time time of the tournament
     * @param description description of the tournament
     * @param game game to be played
     * @param platform platform to be played on
     * @param tournamentType type of tournament
     * @param numberOfTeams number of teams
     * @param prizePool prize pool of the tournament
     * @param prizePoolCurrency currency of the prize pool
     * @param entranceFee entrance fee of the tournament
     * @param entranceFeeCurrency currency of the entrance fee
     */
    public Tournament(String status, String tournamentName, String tournamentHost, LocalDate date,
                      LocalTime time, String description, String game, String platform,
                      String tournamentType, int numberOfTeams,
                      int prizePool, String prizePoolCurrency,
                      int entranceFee, String entranceFeeCurrency) {
        if (status == null || status.isEmpty()){
            throw new IllegalArgumentException("Status cannot be empty!");
        }
        if (tournamentName == null || tournamentName.isEmpty()) {
            throw new IllegalArgumentException("tournament name cannot be empty!");
        }
        if (tournamentHost == null || tournamentHost.isEmpty()){
            throw new IllegalArgumentException("tournament host cannot be empty!");
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
            throw new IllegalArgumentException("tournament type cannot be empty!");
        }
        if (numberOfTeams != 4 && numberOfTeams != 8 && numberOfTeams != 16){
            throw new IllegalArgumentException("Number of teams cannot be anything other than 4,8 or 16!");
        }
        if (!prizePoolCurrency.equals("NOK") && !prizePoolCurrency.equals("USD") && !prizePoolCurrency.equals("EUR")
                && !prizePoolCurrency.equals("GBP") && !prizePoolCurrency.equals("null")){
            throw new IllegalArgumentException("Invalid prize pool-currency!");
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
     * The third constructor.
     * Throws exceptions at same values as the second constructor.
     * Also throws exception at illegal values when instantiating teams.
     * @param status status of the tournament
     * @param tournamentName name of the tournament
     * @param tournamentHost host of the tournament
     * @param date date of the tournament
     * @param time time of the tournament
     * @param description description of the tournament
     * @param game game to be played
     * @param platform platform to be played on
     * @param tournamentType type of tournament
     * @param numberOfTeams number of teams
     * @param prizePool prize pool of the tournament
     * @param prizePoolCurrency currency of the prize pool
     * @param entranceFee entrance fee of the tournament
     * @param entranceFeeCurrency currency of the entrance fee
     * @param teams teams participating in the tournament
     */
    public Tournament(String status, String tournamentName, String tournamentHost, LocalDate date,
                      LocalTime time, String description, String game, String platform,
                      String tournamentType, int numberOfTeams, int prizePool,
                      String prizePoolCurrency, int entranceFee, String entranceFeeCurrency,
                      ArrayList<Team> teams) {
        if (status == null || status.isEmpty()){
            throw new IllegalArgumentException("Status cannot be empty!");
        }
        if (tournamentName == null || tournamentName.isEmpty()) {
            throw new IllegalArgumentException("tournament name cannot be empty!");
        }
        if (tournamentHost == null || tournamentHost.isEmpty()){
            throw new IllegalArgumentException("tournament host cannot be empty!");
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
            throw new IllegalArgumentException("tournament type cannot be empty!");
        }
        if (numberOfTeams != 4 && numberOfTeams != 8 && numberOfTeams != 16){
            throw new IllegalArgumentException("Number of teams cannot be anything other than 4,8 or 16!");
        }
        if (!prizePoolCurrency.equals("NOK") && !prizePoolCurrency.equals("USD") && !prizePoolCurrency.equals("EUR")
                && !prizePoolCurrency.equals("GBP") && !prizePoolCurrency.equals("null")){
            throw new IllegalArgumentException("Invalid prize-pool currency!");
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
     * Returns the prize pool of the tournament
     * @return prize pool of the tournament
     */
    public int getPrizePool() {
        return prizePool;
    }

    /**
     * Sets prize pool of the tournament
     * @param prizePool prize pool of the tournament
     */
    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    /**
     * Returns the currency of the prize pool
     * @return currency of the prize pool
     */
    public String getPrizePoolCurrency() {
        return prizePoolCurrency;
    }

    /**
     * Sets the currency of the prize pool
     * @param prizePoolCurrency currency of the prize pool
     */
    public void setPrizePoolCurrency(String prizePoolCurrency) {
        this.prizePoolCurrency = prizePoolCurrency;
    }

    /**
     * Returns the entrance fee of the tournament
     * @return entrance fee of the tournament
     */
    public int getEntranceFee() {
        return entranceFee;
    }

    /**
     * Sets the entrance fee of the tournament
     * @param entranceFee entrance fee of the tournament
     */
    public void setEntranceFee(int entranceFee) {
        this.entranceFee = entranceFee;
    }

    /**
     * Returns the currency of the entrance fee
     * @return currency of the entrance fee
     */
    public String getEntranceFeeCurrency() {
        return entranceFeeCurrency;
    }

    /**
     * Sets the currency of the entrance fee
     * @param entranceFeeCurrency currency of the entrance fee
     */
    public void setEntranceFeeCurrency(String entranceFeeCurrency) {
        this.entranceFeeCurrency = entranceFeeCurrency;
    }

    /**
     * Returns the time of the tournament
     * @return time of the tournament
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Sets the time of the tournamnet
     * @param time time of the tournament
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Returns the status of the tournament
     * @return status of the tournament
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the tournament
     * @param status status of the tournament
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the matches in the tournament
     * @return matches in the tournament
     */
    public ArrayList<Match> getMatches() {
        return matches;
    }

    /**
     * Sets the matches in the tournament
     * @param matches matches in the tournament
     */
    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    /**
     * Returns the name of the tournament
     * @return name of the tournament
     */
    public String getTournamentName() {
        return tournamentName;
    }

    /**
     * Sets the name of the tournament
     * @param tournamentName name of the tournament
     */
    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    /**
     * Returns the host of the tournament
     * @return host of the tournament
     */
    public String getTournamentHost() {
        return tournamentHost;
    }

    /**
     * Sets the host of the tournament
     * @param tournamentHost host of the tournament
     */
    public void setTournamentHost(String tournamentHost) {
        this.tournamentHost = tournamentHost;
    }

    /**
     * Returns the date of the tournament
     * @return date of the tournament
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the tournament
     * @param date date of the tournament
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the description of the tournament
     * @return description of the tournament
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the tournament
     * @param description description of the tournament
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
     * @param game game to be played
     */
    public void setGame(String game) {
        this.game = game;
    }

    /**
     * Returns the platform to be played on
     * @return platform to be played on
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform to be played on
     * @param platform platform to be played on
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Returns the type of tournament
     * @return type of tournament
     */
    public String getTournamentType() {
        return tournamentType;
    }

    /**
     * Sets the type of tournament
     * @param tournamentType type of tournament
     */
    public void setTournamentType(String tournamentType) {
        this.tournamentType = tournamentType;
    }

    /**
     * Returns the number of teams
     * @return number of teams
     */
    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    /**
     * Sets the number of teams
     * @param numberOfTeams number of teams
     */
    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    /**
     * Returns the teams participating in the tournament
     * @return teams participating in the tournament
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Adds teams to the list of teams
     * @param teams teams participating in the tournament
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams.addAll(teams);
    }

    /**
     * Returns a string containing information about the tournament
     * @return String displaying all tournament information.
     */
    @Override
    public String toString() {
        return "tournament{" +
                "status='" + status + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentHost='" + tournamentHost + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", game='" + game + '\'' +
                ", platform='" + platform + '\'' +
                ", tournamentType='" + tournamentType + '\'' +
                ", numberOfTeams=" + numberOfTeams +
                ", prizePool=" + prizePool +
                ", prizePoolCurrency='" + prizePoolCurrency + '\'' +
                ", entranceFee=" + entranceFee +
                ", entranceFeeCurrency='" + entranceFeeCurrency + '\'' +
                ", teams=" + teams +
                ", matches=" + matches +
                '}';
    }

    /**
     * Returns the team that corresponds to the team name given
     * @param teamName name of the team
     * @return team participating the tournament,
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
     * @param team input team
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
        int numberOfTeamsLeft = getNumberOfTeams();

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
     * Removes the given team from tournaments list of teams
     * @param team input team
     */
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }


    /**
     * Method for fetching number of matches that have no time set yet
     * @return number of matches with no time set
     */
    public int getNumberOfMatchesWithNoTimeSet(){
        int nr = 0;
        for (Match match : matches){
            if (match.getTimeOfMatch() == null){
                nr++;
            }
        }
        return nr;
    }

    /**
     * Method for fetching matches that have no time set yet
     * @return matches with no time set
     */
    public ArrayList<Match> getMatchesWithNoTimeSet(){
        ArrayList<Match> matchesWithNoTimeSet = new ArrayList<>();
        for (Match match : matches){
            if (match.getTimeOfMatch() == null){
                matchesWithNoTimeSet.add(match);
            }
        }
        return matchesWithNoTimeSet;
    }

    /**
     * Method for fetching number of matches that are not yet marked finished
     * @return number of unfinished matches
     */
    public int getNumberOfUnfinishedMatches(){
        int nr = 0;
        for (Match match : matches){
            if (!match.isFinished()){
                nr++;
            }
        }
        return nr;
    }

    /**
     * Method for fetching matches that are not yet marked finished
     * @return unfinished matches
     */
    public ArrayList<Match> getUnfinishedMatches(){
        ArrayList<Match> unfinishedMatches = new ArrayList<>();
        for (Match match : matches){
            if (!match.isFinished()){
                unfinishedMatches.add(match);
            }
        }
        return unfinishedMatches;
    }

    /**
     * Method for fetching matches that are marked finished
     * @return finished matches
     */
    public ArrayList<Match> getFinishedMatches(){
        ArrayList<Match> finishedMatches = new ArrayList<>();
        for (Match match : matches){
            if (match.isFinished()){
                finishedMatches.add(match);
            }
        }
        return finishedMatches;
    }

    /**
     * Method for fetching first place of tournament, only if finished
     * @return winner of the final match, which is the first place of the tournament
     */
    public Team getFirstPlace(){
        if (getStatus().equals("Finished")) {
            return this.matches.get(this.numberOfTeams - 2).getVictor();
        } else {
            return null;
        }
    }

    /**
     * Method for fetching second place of a tournament, only if finished
     * @return loser of the final match, which is the second place of the tournament
     */
    public Team getSecondPlace(){
        if (getStatus().equals("Finished")) {
            return this.matches.get(this.numberOfTeams - 2).getLoser();
        } else {
            return null;
        }
    }
}
