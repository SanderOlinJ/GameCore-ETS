package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Round;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.util.ArrayList;

public class RoundReader {
    private static final String SCORE_DELIMITER = "-";


    public RoundReader(){}

    public static ArrayList<Round> readRoundsFromStringArray(Team team1, Team team2,String[] values){
        ArrayList<Round> rounds = new ArrayList<>();

        String[] roundOneScore = values[6].split(SCORE_DELIMITER);
        int roundOneScoreTeam1 = Integer.parseInt(roundOneScore[0]);
        int roundOneScoreTeam2 = Integer.parseInt(roundOneScore[1]);
        Round roundOne = new Round(team1, team2, roundOneScoreTeam1, roundOneScoreTeam2);
        rounds.add(roundOne);

        if (values.length > 7){
            String[] roundTwoScore = values[7].split(SCORE_DELIMITER);
            int roundTwoScoreTeam1 = Integer.parseInt(roundTwoScore[0]);
            int roundTwoScoreTeam2 = Integer.parseInt(roundTwoScore[1]);
            Round roundTwo = new Round(team1, team2, roundTwoScoreTeam1, roundTwoScoreTeam2);
            rounds.add(roundTwo);

            if (values.length > 8){
                String[] roundThreeScore = values[8].split(SCORE_DELIMITER);
                int roundThreeScoreTeam1 = Integer.parseInt(roundThreeScore[0]);
                int roundThreeScoreTeam2 = Integer.parseInt(roundThreeScore[1]);
                Round roundThree = new Round(team1, team2, roundThreeScoreTeam1, roundThreeScoreTeam2);
                rounds.add(roundThree);
            }
        }
        return rounds;
    }
}
