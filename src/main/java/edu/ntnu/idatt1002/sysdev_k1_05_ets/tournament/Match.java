package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Class for describing a match between two teams taking part in the tournament
 */

public class Match {

    private int matchScoreTeam1;
    private int matchScoreTeam2;
    private Team team1;
    private Team team2;
    private LocalTime timeOfMatch;
    private boolean finished;

    /**
     * First constructor taking two teams, their corresponding scores and the time of the match
     * @param team1 the first team
     * @param team2 the second team
     * @param scoreTeam1 the score of the first team
     * @param scoreTeam2 the score of the second team
     * @param timeOfMatch the time of the match
     */
    public Match(Team team1, Team team2, int scoreTeam1, int scoreTeam2, LocalTime timeOfMatch, boolean finished) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchScoreTeam1 = scoreTeam1;
        this.matchScoreTeam2 = scoreTeam2;
        this.timeOfMatch = timeOfMatch;
        this.finished = finished;
    }

    /**
     * The second constructor taking two teams
     * @param team1 the first team
     * @param team2 the second team
     */
    public Match(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        this.matchScoreTeam1 = 0;
        this.matchScoreTeam2 = 0;
    }

    public Match(Team team1){
        this.team1 = team1;
        this.matchScoreTeam1 = 0;
        this.matchScoreTeam2 = 0;
    }

    public Match(){
        this.matchScoreTeam1 = 0;
        this.matchScoreTeam2 = 0;
    }

    /**
     * Returns the first team
     * @return the first team
     */

    public Team getTeam1() {
        return team1;
    }

    /**
     * Returns the score of the first team
     * @return score of first team
     */
    public int getMatchScoreTeam1() {
        return matchScoreTeam1;
    }

    /**
     * Sets the score of the first team
     * @param matchScoreTeam1
     */
    public void setMatchScoreTeam1(int matchScoreTeam1) {
        this.matchScoreTeam1 = matchScoreTeam1;
    }

    /**
     * Returns the score of the second team
     * @return score of the second team
     */
    public int getMatchScoreTeam2() {
        return matchScoreTeam2;
    }

    /**
     * Sets the score of the second team
     * @param matchScoreTeam2
     */
    public void setMatchScoreTeam2(int matchScoreTeam2) {
        this.matchScoreTeam2 = matchScoreTeam2;
    }

    /**
     * Returns the second team
     * @return second team
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * Returns the time of the match
     * @return
     */
    public LocalTime getTimeOfMatch() {
        return timeOfMatch;
    }

    /**
     * Sets the time of the match
     * @param timeOfMatch
     */
    public void setTimeOfMatch(LocalTime timeOfMatch) {
        this.timeOfMatch = timeOfMatch;
    }

    /**
     * Returns true or false depending on whether the match is finished
     * @return true or false
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Sets the finished-variable to either true or false
     * @param finished true or false
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam(Team team){
        if (this.team1 == null){
            setTeam1(team);
        } else {
            setTeam2(team);
        }
    }

    /**
     * Returns the team with the highest score
     * @return team with hightest score
     */
    public Team getVictor(){
        if (finished) {
            if (matchScoreTeam1 > matchScoreTeam2) {
                return team1;
            }
            return team2;
        }
        return null;
    }

    /**
     * Returns information about the match
     * @return score of both the teams, both the teams, time of match and the boolean value
     * of the finished-variable as a string
     */
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
