package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

public class Round {
    private int scoreTeam1;
    private int scoreTeam2;
    private final Team team1;
    private final Team team2;

    public Round(Team team1, Team team2, int scoreTeam1, int scoreTeam2){
        this.team1 = team1;
        this.team2 = team2;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }
}
