package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class NewTournamentWriter {

    private static final String DELIMITER = "\n";

    public NewTournamentWriter() {
    }


    public static void writeTournamentToFileWithoutTeams(
            String tournamentName, String tournamentHost, LocalDate date, String description, String game,
            String platform, String tournamentType, String numberOfTeams) throws IOException {

        description = description.replaceAll("\n", " ");
        if (description.equals("")) {
            description += "No description";
        }

        String tournamentShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/" + tournamentShortened + ".txt")) {
            String str = tournamentName + DELIMITER + tournamentHost + DELIMITER +
                    date + DELIMITER + description + DELIMITER + game + DELIMITER + platform +
                    DELIMITER + tournamentType + DELIMITER + numberOfTeams +
                    DELIMITER;
            fileWriter.write(str);
        }
    }

    public static void writeTeamsToTournament(String tournamentName, ArrayList<Team> teams) throws IOException {
        String tournamentShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/" + tournamentShortened + ".txt", true)) {

            StringBuilder str = new StringBuilder();
            for (Team team : teams) {
                str.append(team.getNameOfTeam()).append(DELIMITER);
            }
            fileWriter.write(str.toString());
        }
    }

    public static void writeTournamentToOngoingOverviewFile(String tournamentName) throws IOException {
        String tournamentShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        boolean alreadyRegistered = false;
        try {
            ArrayList<String> tournaments = NewTournamentReader.readThroughOngoingTournaments();
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
                    "tournamentFiles/ongoingTournaments/ongoingTournaments.txt", true)) {
                fileWriter.write(tournamentShortened + "\n");
            } catch (IOException exception) {
                throw new IOException("Unable to write tournament to file: " + exception.getMessage());
            }
        }
    }


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
                    "tournamentFiles/previousTournaments/previousTournaments.txt", true)) {
                fileWriter.write(tournamentShortened + "\n");
            } catch (IOException exception) {
                throw new IOException("Unable to write tournament to file: " + exception.getMessage());
            }
        }
    }


    public static void writeTournamentToUpcomingOverviewFile(String tournamentName) throws IOException {
        String tournamentShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        boolean alreadyRegistered = false;
        try {
            ArrayList<String> tournaments = NewTournamentReader.readThroughUpcomingTournaments();
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
                    "tournamentFiles/upcomingTournaments/upcomingTournaments.txt", true)) {
                fileWriter.write(tournamentShortened + "\n");
            } catch (IOException exception) {
                throw new IOException("Unable to write tournament to file: " + exception.getMessage());
            }
        }
    }
}
