package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
    private String bestOf;
    private String numberOfTeams;
    private String prizePool;
    private String prizePoolCurrency;
    private String entranceFee;
    private String entranceFeeCurrency;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    public NewTournament(String status, String tournamentName, String tournamentHost, LocalDate date,
                         LocalTime time, String description, String game, String platform,
                         String tournamentType, String bestOf, String numberOfTeams,
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
        if (bestOf == null || bestOf.isEmpty()){
            throw new IllegalArgumentException("Best of cannot be empty!");
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
        this.bestOf = bestOf;
        this.numberOfTeams = numberOfTeams;
        this.prizePool = prizePool;
        this.prizePoolCurrency = prizePoolCurrency;
        this.entranceFee = entranceFee;
        this.entranceFeeCurrency = entranceFeeCurrency;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public NewTournament(String status, String tournamentName, String tournamentHost, LocalDate date,
                         LocalTime time, String description, String game, String platform,
                         String tournamentType, String bestOf, String numberOfTeams, String prizePool,
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
        if (bestOf == null || bestOf.isEmpty()){
            throw new IllegalArgumentException("Best of cannot be empty!");
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
        this.bestOf = bestOf;
        this.numberOfTeams = numberOfTeams;
        this.prizePool = prizePool;
        this.prizePoolCurrency = prizePoolCurrency;
        this.entranceFee = entranceFee;
        this.entranceFeeCurrency = entranceFeeCurrency;
        this.teams = new ArrayList<>();
        this.teams.addAll(teams);
        this.matches = new ArrayList<>();
    }

    public String getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(String prizePool) {
        this.prizePool = prizePool;
    }

    public String getPrizePoolCurrency() {
        return prizePoolCurrency;
    }

    public void setPrizePoolCurrency(String prizePoolCurrency) {
        this.prizePoolCurrency = prizePoolCurrency;
    }

    public String getEntranceFee() {
        return entranceFee;
    }

    public void setEntranceFee(String entranceFee) {
        this.entranceFee = entranceFee;
    }

    public String getEntranceFeeCurrency() {
        return entranceFeeCurrency;
    }

    public void setEntranceFeeCurrency(String entranceFeeCurrency) {
        this.entranceFeeCurrency = entranceFeeCurrency;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
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

    public String getBestOf() {
        return bestOf;
    }

    public void setBestOf(String bestOf) {
        this.bestOf = bestOf;
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
                ", bestOf='" + bestOf + '\'' +
                ", numberOfTeams='" + numberOfTeams + '\'' +
                ", teams=" + teams + "\n" +
                ", matches=" + matches + "\n" +
                '}';
    }

    public Match findNextMatchToBePlayed(){
        Match nextMatch = null;

        ArrayList<Match> notFinishedMatches = new ArrayList<>();
        if (this.matches.size() > 0){
            for (Match match : matches){
                if (!match.isFinished()){
                    notFinishedMatches.add(match);
                }
            }
            LocalTime time = this.matches.get(0).getTimeOfMatch();
            LocalDate date = this.matches.get(0).getDateOfMatch();

            for (int i = 1; i < this.matches.size(); i++){
                if (this.matches.get(i).getDateOfMatch().isBefore(date)
                        || this.matches.get(i).getDateOfMatch().isEqual(date)
                                && this.matches.get(i).getTimeOfMatch().isBefore(time)){

                    date = this.matches.get(i).getDateOfMatch();
                    time = this.matches.get(i).getTimeOfMatch();
                    nextMatch = this.matches.get(i);
                }
            }
        }
        return nextMatch;
    }
}
