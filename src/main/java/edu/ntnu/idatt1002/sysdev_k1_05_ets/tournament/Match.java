package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalDate;

public class Match {
    Team team1;
    int scoreTeam1;
    Team team2;
    int scoreTeam2;
    LocalDate dateOfMatch;
    boolean finished;

    public Match(Team team1, Team team2, LocalDate dateOfMatch) {
        this.team1 = team1;
        this.team2 = team2;
        this.dateOfMatch = dateOfMatch;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public LocalDate getDateOfMatch() {
        return dateOfMatch;
    }

    public void setDateOfMatch(LocalDate dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }

    public Team getWinner() {
        if (scoreTeam1 > scoreTeam2) {
            return team1;
        } else if (scoreTeam2 > scoreTeam1) {
            return team2;
        } else {
            return null;
        }
    }




}
