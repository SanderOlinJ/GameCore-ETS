package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class NewTournamentWriter {

    private static final String DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";

    public NewTournamentWriter() {}


    public static void writeOngoingOrUpcomingTournamentToFileWithoutTeams(String status, String tournamentName, String tournamentHost,
                                                         LocalDate date, String description, String game,
                                                         String platform, String tournamentType, String bestOf,
                                                         String numberOfTeams) throws IOException {

        description = description.replaceAll("\n", " ");
        if (description.equals("")) {
            description += "No description";
        }

        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);

        String str = status + DELIMITER + tournamentName + DELIMITER + tournamentHost + DELIMITER +
                date + DELIMITER + description + DELIMITER + game + DELIMITER + platform +
                DELIMITER + tournamentType + DELIMITER + bestOf + DELIMITER + numberOfTeams +
                DELIMITER;
        if (date.isEqual(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");

            if (file.exists()){
                throw new IOException("There is already a tournament file under this name");
            }
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(str);
                writeTournamentToOngoingOverviewFile(tournamentNameShortened);
            } catch (IOException exception){
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }

        } else if (date.isAfter(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");

            if (file.exists()){
                throw new IOException("There is already a tournament file under this name");
            }
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(str);
                writeTournamentToUpcomingOverviewFile(tournamentNameShortened);
            } catch (IOException exception){
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }
        }
    }

    public static void writeTeamsToTournament(String tournamentName, LocalDate date, String numberOfTeams ,
                                              ArrayList<Team> teams) throws IOException {

        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        int totalNumberOfTeams = Integer.parseInt(numberOfTeams);
        StringBuilder str = new StringBuilder();

        if (teams.size() > totalNumberOfTeams){
            throw new IllegalArgumentException("This tournament is supposed to have " + numberOfTeams +
                    "competing, not " + teams.size());
        }

        if (date.isEqual(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");

            if (!file.exists()){
                throw new IOException("There is no tournament file under this name");
            }
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                writeTeamToStringInFormatOfTournamentFile(teams, str, fileWriter);
                writeTournamentToOngoingOverviewFile(tournamentNameShortened);
            } catch (IOException exception){
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }

        }

        if (date.isAfter(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");

            if (!file.exists()){
                throw new IOException("There is no tournament file under this name");
            }
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                writeTeamToStringInFormatOfTournamentFile(teams, str, fileWriter);
                writeTournamentToUpcomingOverviewFile(tournamentNameShortened);
            } catch (IOException exception){
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }

        }

    }

    private static void writeTeamToStringInFormatOfTournamentFile(ArrayList<Team> teams, StringBuilder str,
                                                                  FileWriter fileWriter) throws IOException {
        for (Team team : teams){
            str.append(team.getNameOfTeam()).append(COMMA_DELIMITER).append(team.getNameAbbr());
            team.getMembers().forEach(s -> str.append(COMMA_DELIMITER).append(s));
            str.append(DELIMITER);
        }
        fileWriter.write(str.toString());
    }


    public static void writeTournamentToOngoingOverviewFile(String tournamentNameShortened) throws IOException{
        String str = tournamentNameShortened + DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/ongoingTournaments.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write(str);
        } catch (IOException exception){
            throw new IOException("Could not write tournament to ongoing overview file: " + exception.getMessage());
        }
    }

    public static void writeTournamentToUpcomingOverviewFile(String tournamentNameShortened) throws IOException{
        String str = tournamentNameShortened + DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write(str);
        } catch (IOException exception){
            throw new IOException("Could not write tournament to upcoming overview file: " + exception.getMessage());
        }
    }

    public static boolean removeTournamentFromUpcomingTournaments(String tournamentNameShortened) throws IOException{
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
        try {
            ArrayList<String> tournaments = NewTournamentReader.readThroughUpcomingTournaments();
            if (tournaments.remove(tournamentNameShortened)){
                try (FileWriter fileWriter = new FileWriter(file)){
                    for (String tournament : tournaments){
                        fileWriter.write(tournament + DELIMITER);
                    }
                } catch (IOException exception){
                    throw new IOException("Could not write tournaments back to file");
                }
                return true;
            } else {
                return false;
            }
        } catch (IOException exception){
            throw new IOException("Could not read from upcoming tournaments: "+ exception.getMessage());
        }
    }

    /*
    public static void writeTournamentToPreviousOverviewFile(String tournamentName) throws IOException {
        String tournamentShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        boolean alreadyRegistered = false;
        try {
            ArrayList<String> tournaments = NewTournamentReader.readThroughPreviousTournaments();
            for (String tournament : tournaments) {
                if (tournament.equals(tournamentShortened)) {
                    alreadyRegistered = true;
                    break;
                }
            }
        } catch (IOException exception) {
            exception.getMessage();
        } finally {
            if (alreadyRegistered) {
                throw new IOException("Tournament is already registered in this file");
            }
            try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/previousTournaments/tournamentFileFormat.txt", true)) {
                fileWriter.write(tournamentShortened + "\n");
            } catch (IOException exception) {
                throw new IOException("Unable to write tournament to file: " + exception.getMessage());
            }
        }
    }
     */
}
