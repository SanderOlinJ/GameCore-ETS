package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Round;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MatchReader {
    private static final String COMMA_DELIMITER = ",";
    private static final String SCORE_DELIMITER = "-";

    public MatchReader(){}

    public static ArrayList<Match> readMatchesFromArrayList(ArrayList<String> list)
    throws IOException{
        ArrayList<Match> matches = new ArrayList<>();

        for (int i = 14; i < list.size(); i++) {

            String line = list.get(i);
            String[] values = line.split(COMMA_DELIMITER);
            Team team1 = TeamReader.findAndReturnTeamUsingTeamName(values[0]);
            Team team2 = TeamReader.findAndReturnTeamUsingTeamName(values[1]);
            Match match = new Match(team1, team2);

            if (values.length > 2) {
                LocalDate date = LocalDate.parse(values[2]);
                match.setDateOfMatch(date);
                if (values.length > 3) {
                    LocalTime time = LocalTime.parse(values[3]);
                    match.setTimeOfMatch(time);
                    if (values.length > 4) {
                        int matchScoreTeam1 = Integer.parseInt(values[4]);
                        int matchScoreTeam2 = Integer.parseInt(values[5]);
                        match.setMatchScoreTeam1(matchScoreTeam1);
                        match.setMatchScoreTeam2(matchScoreTeam2);
                        ArrayList<Round> rounds = RoundReader.readRoundsFromStringArray(
                                team1, team2, values);
                        if (rounds.size() != 0) {
                            match.setRounds(rounds);
                            match.setFinished(list.get(9).equals("1") && rounds.size() == 1
                                    || list.get(9).equals("3") && matchScoreTeam1 == 2
                                    || list.get(9).equals("3") && matchScoreTeam2 == 2);
                        }
                    }
                }
            }
            matches.add(match);
        }
        return matches;
    }
}
