package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Match {

    private int matchScoreTeam1;
    private int matchScoreTeam2;
    private final Team team1;
    private final Team team2;
    private LocalTime timeOfMatch;
    private boolean finished;

    public Match(Team team1, Team team2, int scoreTeam1, int scoreTeam2, LocalTime timeOfMatch) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchScoreTeam1 = scoreTeam1;
        this.matchScoreTeam2 = scoreTeam2;
        this.timeOfMatch = timeOfMatch;
    }

    public Match(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
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

    public Team getVictor(){
        if (matchScoreTeam1 > matchScoreTeam2){
            return team1;
        }
        return team2;
    }

    @Override
    public String toString() {
        return "\nMatch{" +
                ", matchScoreTeam1=" + matchScoreTeam1 +
                ", matchScoreTeam2=" + matchScoreTeam2 +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", timeOfMatch=" + timeOfMatch +
                ", finished=" + finished +
                '}';
    }
}
