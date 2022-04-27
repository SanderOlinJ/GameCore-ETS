package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import java.time.LocalTime;

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
     * First constructor taking two teams, their corresponding scores and the time of the match.
     * Throws exception if any of the fields have invalid values, i.e. null.
     * @param team1 the first team
     * @param team2 the second team
     * @param scoreTeam1 the score of the first team
     * @param scoreTeam2 the score of the second team
     * @param timeOfMatch the time of the match
     */
    public Match(Team team1, Team team2, int scoreTeam1, int scoreTeam2, LocalTime timeOfMatch, boolean finished) {
        if (team1 == null){
            throw new IllegalArgumentException("Team 1 cannot be null");
        }
        if (team2 == null){
            throw new IllegalArgumentException("Team 2 cannot be null");
        }
        if (timeOfMatch == null){
            throw new IllegalArgumentException("Time of match cannot be null");
        }
        if (scoreTeam1 < 0){
            throw new IllegalArgumentException("Team 1's score cannot be less than 0");
        }
        if (scoreTeam2 < 0){
            throw new IllegalArgumentException("Team 2's score cannot be less than 0");
        }
        this.team1 = team1;
        this.team2 = team2;
        this.matchScoreTeam1 = scoreTeam1;
        this.matchScoreTeam2 = scoreTeam2;
        this.timeOfMatch = timeOfMatch;
        this.finished = finished;
    }

    /**
     * The second constructor taking two teams
     * Throws exception if either of the participating teams are null.
     * @param team1 the first team
     * @param team2 the second team
     */
    public Match(Team team1, Team team2){
        if (team1 == null){
            throw new IllegalArgumentException("Team 1 cannot be null");
        }
        if (team2 == null){
            throw new IllegalArgumentException("Team 2 cannot be null");
        }
        this.team1 = team1;
        this.team2 = team2;
        this.matchScoreTeam1 = 0;
        this.matchScoreTeam2 = 0;
    }

    /**
     * The third constructor takes in no teams.
     * Is used for instantiating matches where
     * the participating teams have not yet been determined.
     * Used when reading from tournament file,
     * where every upcoming match is listed,
     * even with no teams.
     */
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
     * Sets the score of the first team.
     * Throws exception if the score is less than 0.
     * @param matchScoreTeam1 team 1's score
     */
    public void setMatchScoreTeam1(int matchScoreTeam1) {
        if (matchScoreTeam1 < 0){
            throw new IllegalArgumentException("Team 1's score cannot be less than 0");
        }
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
     * Sets the score of the second team.
     * Throws exception if the score is less than 0.
     * @param matchScoreTeam2 team 2's score
     */
    public void setMatchScoreTeam2(int matchScoreTeam2) {
        if (matchScoreTeam2 < 0){
            throw new IllegalArgumentException("Team 2's score cannot be less than 0");
        }
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
     * Sets the time of the match.
     * Throws exception if the time is null
     * @param timeOfMatch time of the match
     */
    public void setTimeOfMatch(LocalTime timeOfMatch) {
        if (timeOfMatch == null){
            throw new IllegalArgumentException("Time of match cannot be null");
        }
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

    /**
     * Sets the second team participating in the tournament.
     * Throws exception if the team is null.
     * @param team2 second team participating in the match
     */
    public void setTeam2(Team team2){
        if (team2 == null){
            throw new IllegalArgumentException("Team 2 cannot be null");
        }
        this.team2 = team2;
    }

    /**
     * Sets the first team participating in the tournament.
     * Throws exception if the team is null.
     * @param team1 second team participating in the match
     */
    public void setTeam1(Team team1) {
        if (team1 == null){
            throw new IllegalArgumentException("Team 1 cannot be null");
        }
        this.team1 = team1;
    }


    /**
     * Returns the team with the highest score,
     * only if the match is finished.
     * @return team with the highest score, the victor
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

    /**
    * Returns the team with the lowest score,
    * only if the match is finished.
    * @return team with the lowest score, the lost
    */
    public Team getLoser(){
        if (finished){
            if (matchScoreTeam1 < matchScoreTeam2){
                return team1;
            }
            return team2;
        }
        return null;
    }
}
