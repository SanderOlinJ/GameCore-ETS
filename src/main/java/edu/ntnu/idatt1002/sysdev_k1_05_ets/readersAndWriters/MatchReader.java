package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Class for reading Matches from tournament file.
 */
public class MatchReader {
    private static final String COMMA_DELIMITER = ",";

    public MatchReader() {
    }

    /**
     Method reads matches from a tournament file-to-list.
     * @param list list containing all tournament data
     * @return list of matches in tournament.
     * @throws IOException if teams could not be found
     */
    public static ArrayList<Match> readMatchesFromArrayList(ArrayList<String> list)
            throws IOException {
        ArrayList<Match> matches = new ArrayList<>();

        //Method starts by iterating through the arraylist, which is index 13 in a tournament file to list.
        for (String line : list) {

            //Each line is the split up into values.
            String[] values = line.split(COMMA_DELIMITER);

            /*
            The match is then instantiated, even without teams, as every Match in the list is already written,
            even the final match.
             */
            Match match = new Match();

            /*
            If the first value (if finished or not) is true, then every following value is defined,
            We can then add each value to the Match object
             */
            if (Boolean.parseBoolean(values[1])) {
                match.setTeam1(TeamReader.findAndReturnTeamUsingTeamName(values[2]));
                match.setTeam2(TeamReader.findAndReturnTeamUsingTeamName(values[3]));
                match.setTimeOfMatch(LocalTime.parse(values[4]));
                match.setMatchScoreTeam1(Integer.parseInt(values[5]));
                match.setMatchScoreTeam2(Integer.parseInt(values[6]));
                match.setFinished(true);
            } else {

                /*
                If the first value is false (not finished), then we have to parse through each value
                to see if they are defined.
                 */
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

