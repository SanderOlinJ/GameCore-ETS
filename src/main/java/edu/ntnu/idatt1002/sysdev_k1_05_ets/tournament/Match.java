package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Match {

    private ArrayList<Round> rounds;
    private int matchScoreTeam1;
    private int matchScoreTeam2;
    private final Team team1;
    private final Team team2;
    private LocalDate dateOfMatch;
    private LocalTime timeOfMatch;
    private boolean finished;

    public Match(Team team1, Team team2, LocalDate dateOfMatch, LocalTime timeOfMatch) {
        this.team1 = team1;
        this.team2 = team2;
        this.dateOfMatch = dateOfMatch;
        this.timeOfMatch = timeOfMatch;
    }

    public Match(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    public Match(Team team1, Team team2, LocalDate dateOfMatch, LocalTime timeOfMatch, ArrayList<Round> rounds,
                 int matchScoreTeam1, int matchScoreTeam2){
        this.team1 = team1;
        this.team2 = team2;
        this.dateOfMatch = dateOfMatch;
        this.timeOfMatch = timeOfMatch;
        this.rounds = rounds;
        this.matchScoreTeam1 = matchScoreTeam1;
        this.matchScoreTeam2 = matchScoreTeam2;
    }

    public Team getTeam1() {
        return team1;
    }

    public int getMatchScoreTeam1() {
        return matchScoreTeam1;
    }

    public void setMatchScoreTeam1(int matchScoreTeam1) {
        this.matchScoreTeam1 = matchScoreTeam1;
    }

    public int getMatchScoreTeam2() {
        return matchScoreTeam2;
    }

    public void setMatchScoreTeam2(int matchScoreTeam2) {
        this.matchScoreTeam2 = matchScoreTeam2;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }

    public LocalTime getTimeOfMatch() {
        return timeOfMatch;
    }

    public void setTimeOfMatch(LocalTime timeOfMatch) {
        this.timeOfMatch = timeOfMatch;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public LocalDate getDateOfMatch() {
        return dateOfMatch;
    }

    public void setDateOfMatch(LocalDate dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void addRound(Round round){
        rounds.add(round);
    }

    public void addAllRounds(ArrayList<Round> roundsToAdd){
        this.rounds.addAll(roundsToAdd);
    }

    public Team getVictor(){
        int scoreTeam1 = 0;
        int scoreTeam2 = 0;
        for (Round round : rounds){
            scoreTeam1 = round.getScoreTeam1();
            scoreTeam2 = round.getScoreTeam2();
        }
        if (scoreTeam1 > scoreTeam2){
            return getTeam1();
        } else if (scoreTeam2 > scoreTeam1){
            return getTeam2();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "\nMatch{" +
                "rounds=" + rounds + "\n" +
                ", matchScoreTeam1=" + matchScoreTeam1 +
                ", matchScoreTeam2=" + matchScoreTeam2 +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", dateOfMatch=" + dateOfMatch +
                ", timeOfMatch=" + timeOfMatch +
                ", finished=" + finished +
                '}';
    }
}
