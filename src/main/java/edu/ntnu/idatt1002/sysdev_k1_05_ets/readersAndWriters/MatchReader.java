package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MatchReader {
    private static final String COMMA_DELIMITER = ",";
    private static final String SCORE_DELIMITER = "-";

    public MatchReader() {
    }

    public static ArrayList<Match> readMatchesFromArrayList(ArrayList<String> list)
            throws IOException {
        ArrayList<Match> matches = new ArrayList<>();

        for (int i = 13; i < list.size(); i++) {

            String line = list.get(i);
            String[] values = line.split(COMMA_DELIMITER);
            Match match = new Match();

            if (Boolean.parseBoolean(values[1])) {
                match.setTeam1(TeamReader.findAndReturnTeamUsingTeamName(values[2]));
                match.setTeam2(TeamReader.findAndReturnTeamUsingTeamName(values[3]));
                match.setTimeOfMatch(LocalTime.parse(values[4]));
                match.setMatchScoreTeam1(Integer.parseInt(values[5]));
                match.setMatchScoreTeam2(Integer.parseInt(values[6]));
                match.setFinished(true);
            } else {
                if (!values[2].equals("?") || !values[3].equals("?")) {
                    if (!values[2].equals("?")) {
                        match.setTeam1(TeamReader.findAndReturnTeamUsingTeamName(values[2]));
                    }
                    if (!values[3].equals("?")) {
                        match.setTeam2(TeamReader.findAndReturnTeamUsingTeamName(values[3]));
                    }
                    if (!values[4].equals("?")) {
                        match.setTimeOfMatch(LocalTime.parse(values[4]));
                    }
                }
            }
            matches.add(match);
        }
        return matches;
    }
}

