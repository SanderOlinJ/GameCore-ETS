package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class NewTournamentWriter {

    private static final String DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";

    public NewTournamentWriter() {}


    /**
     * Method for checking if a file exists under the input tournament name
     * Used to when creating a new tournament, so that the user doesn't create a tournament file
     * with the same name as an already existing file.
     * @param tournamentNameShortened Name of tournament, since tournament files are saved under their name
     * @return true if a file exists, false if not
     */
    public static String doesFileWithSameNameAlreadyExist(String tournamentNameShortened){
        File file1 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
        File file2 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
        File file3 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");


        if (file1.exists()){
            return "Ongoing";
        } else if (file2.exists()){
            return "Upcoming";
        } else if (file3.exists()){
            return "Previous";
        }else {
            return "No";
        }
    }

    /**
     * Method for writing a newly created tournament to file,
     * also writes the tournament name to an overview file.
     * @param status Tournament status, if it's ongoing, upcoming or previous
     * @param tournamentName Name of the tournament, used for making file name
     * @param tournamentHost Host of the tournament
     * @param date Date of the tournament
     * @param description User's description of the tournament
     * @param game Game to be played at tournament
     * @param platform What platform the game is played on
     * @param tournamentType Type of tournament (Only brackets for now)
     * @param bestOf Best of how many rounds (1 or 3 for now)
     * @param numberOfTeams Total number of teams participating (4, 8 or 16 for now)
     * @throws IOException
     */
    public static void writeTournamentBasicInfoToFile(
            String status, String tournamentName, String tournamentHost, LocalDate date, String description,
            String game, String platform, String tournamentType, String bestOf,
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

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(str);
                writeTournamentToOngoingOverviewFile(tournamentNameShortened);
            } catch (IOException exception){
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }

        } else if (date.isAfter(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(str);
                writeTournamentToUpcomingOverviewFile(tournamentNameShortened);
            } catch (IOException exception){
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }
        }
    }

    public static void editTournamentWithoutTeamsAndWriteBackToFileWhileRemovingOldFile(File originalFile,
            String status, String tournamentName, String tournamentHost, LocalDate date, String description,
            String game, String platform, String tournamentType, String bestOf, String numberOfTeams){
        try {
            writeTournamentBasicInfoToFile(status, tournamentName, tournamentHost, date, description, game,
                    platform, tournamentType, bestOf, numberOfTeams);
        } catch (IOException exception){
            exception.getMessage();
        }

        originalFile.delete();


    }
/*
    public static boolean removeTournamentFile(String tournamentNameShortened, File file){
        String doesFileExist = doesFileWithSameNameAlreadyExist(tournamentNameShortened);
        if (doesFileExist.equals("Ongoing")){
            File removeFile = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");

            removeFile.delete();
        }
    }
    */
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
            } catch (IOException exception){
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }

        }

        else if (date.isAfter(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");

            if (!file.exists()){
                throw new IOException("There is no tournament file under this name");
            }
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                writeTeamToStringInFormatOfTournamentFile(teams, str, fileWriter);
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

    public static void updateTournaments() throws IOException{
        LocalDate date = LocalDate.now();
        try {
            ArrayList<String> ongoingTournaments = NewTournamentReader.readThroughOngoingTournaments();
            ArrayList<String> upcomingTournament = NewTournamentReader.readThroughUpcomingTournaments();
            ArrayList<String> previousTournament = NewTournamentReader.readThroughPreviousTournaments();

            for (String tournamentNameShortened : upcomingTournament){
                File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
                //If tournament is no longer upcoming
                if (!NewTournamentReader.isTournamentUpcoming(file)) {
                    //Remove tournament from upcoming Overview
                    removeTournamentFromUpcomingTournaments(tournamentNameShortened);
                    //Write to ongoing overview
                    writeTournamentToOngoingOverviewFile(tournamentNameShortened);
                    //Move entire tournament file to ongoing directory
                    moveFileFromUpcomingToOngoing(tournamentNameShortened);

                }
            }
            /*
            for (String tournamentNameShortened : ongoingTournaments){
                new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");

            }

             */
        } catch (IOException exception){
            throw new IOException("Could not read through all tournaments overview files: " + exception.getMessage());
        }

    }

    public static void moveFileFromUpcomingToOngoing(String tournamentNameShortened) throws IOException{
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
        try {
            ArrayList<String> tournamentFile = GeneralReader.readFile(file);
            if (file.delete()){
                File newFile = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
                try (FileWriter fileWriter = new FileWriter(newFile)){
                    for (String str : tournamentFile){
                        fileWriter.write(str);
                    }
                } catch (IOException exception){
                    throw new IOException("File could not be written to new location: " + exception.getMessage());
                }
            }
        }catch (IOException exception){
            throw new IOException("File could not be read: " + exception.getMessage());
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
