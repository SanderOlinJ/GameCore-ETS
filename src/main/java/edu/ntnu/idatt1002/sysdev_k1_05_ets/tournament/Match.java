package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalDate;
import java.util.ArrayList;

public class Match {

    private ArrayList<Round> rounds;
    private final Team team1;
    private final Team team2;
    private LocalDate dateOfMatch;
    private boolean finished;

    public Match(Team team1, Team team2, LocalDate dateOfMatch) {
        this.team1 = team1;
        this.team2 = team2;
        this.dateOfMatch = dateOfMatch;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
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

    public void addAllRounds(ArrayList<Round> rounds){
        rounds.addAll(rounds);
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
}
