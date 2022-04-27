package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TournamentWriter {

    private static final String NEWLINE_DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";

    public TournamentWriter() {}

    /**
     * ifFileExistsAndFindLocation()
     * Used to check for duplicates,
     * and location
     * @param tournamentNameShortened
     * @return String of location
     */
    public static String ifFileExistsAndFindLocation(String tournamentNameShortened) {
        File file1 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
        File file2 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
        File file3 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");

        if (file1.exists()) {
            return "Ongoing";
        } else if (file2.exists()) {
            return "Upcoming";
        } else if (file3.exists()) {
            return "Previous";
        } else {
            return "No";
        }
    }

    /**
     Takes in all basic tournament attributes as parameters (Everything except teams and matches).
     Uses shorten tournament name-method to get a file name for the new tournament.
     Replaces a potentially empty description with "No description",
     then checks if the tournament is either an ongoing or upcoming tournament.
     Then it writes the tournament to a file which is placed in either the ongoing or upcoming folder.
     It also uses the writeTournamentToOngoingOverview() or  writeTournamentToUpcomingOverview()
     to write the tournament to an overview file.
     * @param status status of the tournament, e.g. "Not finished"
     * @param tournamentName name ot the tournament, String
     * @param tournamentHost host of the tournament, only "Admin" for now, String
     * @param date date of the tournament, LocalDate
     * @param time time of the tournament, LocalTime
     * @param description description of the tournament, String
     * @param game game played at tournament, String
     * @param platform platform the game is played on, String
     * @param tournamentType type of tournament, only "Brackets" for now, String
     * @param numberOfTeams number of teams playing, only "4", "8" or "16" for now, String
     * @throws IOException
     */
    public static void writeNewTournamentToFileWithBasicInfo(
            String status, String tournamentName, String tournamentHost, LocalDate date, LocalTime time,
            String description, String game, String platform, String tournamentType,
            int numberOfTeams, int prizePool, String prizePoolCurrency, int entranceFee,
            String entranceFeeCurrency)
            throws IOException {

        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);

        description = description.replaceAll(NEWLINE_DELIMITER, " ");
        description = description.replaceAll(COMMA_DELIMITER," ");
        if (description.equals("")) {
            description += "No description";
        }

        StringBuilder tournamentStringFormat = new StringBuilder(status + NEWLINE_DELIMITER + tournamentName + NEWLINE_DELIMITER + tournamentHost + NEWLINE_DELIMITER +
                date + NEWLINE_DELIMITER + time + NEWLINE_DELIMITER + description + NEWLINE_DELIMITER + game + NEWLINE_DELIMITER + platform +
                NEWLINE_DELIMITER + tournamentType + NEWLINE_DELIMITER + numberOfTeams +
                NEWLINE_DELIMITER + prizePool + COMMA_DELIMITER + prizePoolCurrency + NEWLINE_DELIMITER +
                entranceFee + COMMA_DELIMITER + entranceFeeCurrency + NEWLINE_DELIMITER);

        if (date.isEqual(LocalDate.now()) && time.equals(LocalTime.now()) && status.equals("Not finished") ||
                date.isEqual(LocalDate.now()) && time.isBefore(LocalTime.now()) && status.equals("Not finished") ||
                date.isBefore(LocalDate.now()) && status.equals("Not finished")) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(tournamentStringFormat.toString());
                writeTournamentToOngoingOverview(tournamentNameShortened);
            } catch (IOException exception) {
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }

        } else if (date.isAfter(LocalDate.now()) && status.equals("Not finished") ||
                date.isEqual(LocalDate.now()) && time.isAfter(LocalTime.now()) && status.equals("Not finished")) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(tournamentStringFormat.toString());
                writeTournamentToUpcomingOverview(tournamentNameShortened);
            } catch (IOException exception) {
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }
        } else {
            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(tournamentStringFormat.toString());
                writeTournamentToPreviousOverview(tournamentNameShortened);
            } catch (IOException exception) {
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }
        }
    }

    /**
     Takes in the shortened tournament name and writes it into
     the ongoing overview file. This makes it easier to later
     locate the individual tournament files.
     * @param tournamentName name of the tournament, String
     * @throws IOException
     */
    public static void writeTournamentToOngoingOverview(String tournamentName)
    throws IOException{
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        String overviewStringFormat = tournamentNameShortened + NEWLINE_DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/ongoingTournaments.txt");
        try (FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(overviewStringFormat);
        } catch (IOException exception){
            throw new IOException("Could not write tournament to ongoing overview");
        }
    }

    /**
    Takes in the shortened tournament name and writes it into
    the upcoming overview file. This makes it easier to later
    locate the individual tournament files.
     * @param tournamentName name of the tournament, String
     * @throws IOException
     */
    public static void writeTournamentToUpcomingOverview(String tournamentName)
    throws IOException{
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        String overviewStringFormat = tournamentNameShortened + NEWLINE_DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
        try(FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(overviewStringFormat);
        }catch (IOException exception){
            throw new IOException("Could not write tournament to upcoming overview");
        }
    }

    /**
     Takes in the shortened tournament name and writes it into
     the previous overview file. This makes it easier to later
     locate the individual tournament files.
     * @param tournamentName name of the tournament, String
     * @throws IOException
     */
    public static void writeTournamentToPreviousOverview(String tournamentName)
            throws IOException{
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        String overviewStringFormat = tournamentNameShortened + NEWLINE_DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/previousTournaments/previousTournaments.txt");
        try(FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(overviewStringFormat);
        }catch (IOException exception){
            throw new IOException("Could not write tournament to previous overview");
        }
    }

    // FIXME: 24.04.2022: This method may be removed, I'm the author it and I'm not even sure why I have this
    /**
     Method takes in a shortened tournament name as parameter.
     It then uses the ifFileExistsAndFindLocation()-method
     to find which overview file the tournament is in.
     Then reads the overview file to an arraylist. In the arraylist,
     we then remove the tournament and convert the arraylist
     to a String builder. We then write over the overview file, now with 1 less tournament.
     * @param tournamentName name of the tournament, String
     * @throws IOException
     */
    public static void removeTournamentFromOverviewWhenLocationNotKnown(String tournamentName)
    throws IOException{
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        ArrayList<String> ongoingTournaments = TournamentReader.readThroughOngoingTournaments();
        ArrayList<String> upcomingTournaments = TournamentReader.readThroughUpcomingTournaments();
        ArrayList<String> previousTournaments = TournamentReader.readThroughPreviousTournaments();
        String location = "";
        boolean locationFound = false;

        for (String str : ongoingTournaments){
            if (str.equals(tournamentNameShortened)) {
                location = "Ongoing";
                locationFound = true;
                break;
            }
        }
        if (!locationFound){
            for (String str : upcomingTournaments){
                if (str.equals(tournamentNameShortened)){
                    location = "Upcoming";
                    locationFound = true;
                    break;
                }
            }
        }
        if (!locationFound){
            for (String str : previousTournaments){
                if (str.equals(tournamentNameShortened)){
                    location = "Previous";
                    break;
                }
            }
        }
        File file = switch (location){
            case "Ongoing" -> new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/ongoingTournaments/ongoingTournaments.txt");
            case "Upcoming" -> new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
            case "Previous" -> new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/previousTournaments/previousTournaments.txt");
            default -> throw new IOException("File doesn't exist");

        };
        ArrayList<String> overview = GeneralReader.readFile(file);
        overview.removeIf(tournament -> tournament.equals(tournamentNameShortened));
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : overview){
            stringBuilder.append(string).append(NEWLINE_DELIMITER);
        }

        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(stringBuilder.toString());
        } catch (IOException exception){
            throw new IOException("Could not write new overview to file: " + exception.getMessage());
        }
    }

    /**
     Handy method to find which folder (ongoing-, upcoming- or previous tournaments)
     the file of a tournament is located in.
     * @param tournamentName name of the tournament, String
     * @return File path, String
     * @throws IOException
     */
    public static String getPathToTournamentFileAsString(String tournamentName)
    throws IOException {
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);

        String location = ifFileExistsAndFindLocation(tournamentNameShortened);

        return switch (location){
            case "Ongoing" ->"src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt";
            case "Upcoming" -> "src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt";
            case "Previous" -> "src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt";
            default -> throw new IOException("Could not find tournament file");
        };
    }

    /**
     Method takes in an arraylist of teams,
     and a shortened tournament name as parameter, for easily finding file location.
     It writes out the whole file to an arraylist, and adds or replaces index 11 (teams) with the new teams taken in
     as a parameter. It then writes the whole file back to the original file path.
     Can also be used to edit teams if matches has been set, but this functionality has not been implemented.
     * @param tournamentName name of the tournament, String
     * @param teams teams to be added to tournament, ArrayList
     * @throws IOException
     */
    public static void writeTeamsToTournamentFile(String tournamentName, ArrayList<Team> teams)
    throws IOException{

        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        File file = new File(getPathToTournamentFileAsString(tournamentNameShortened));
        ArrayList<String> fileAsListOfStrings = GeneralReader.readFile(file);
        StringBuilder stringBuilder = new StringBuilder();

        for (Team team : teams){
            stringBuilder.append(team.getNameOfTeam()).append(COMMA_DELIMITER);
        }
        if (fileAsListOfStrings.size() <= 12){
            fileAsListOfStrings.add("");
        }
        fileAsListOfStrings.set(12,stringBuilder.toString());

        StringBuilder stringBuilder1 = new StringBuilder();
        for (String str : fileAsListOfStrings){
            stringBuilder1.append(str).append(NEWLINE_DELIMITER);
        }
        if (teams.size() == Integer.parseInt(fileAsListOfStrings.get(9))){
            for (int i = (Integer.parseInt(fileAsListOfStrings.get(9))) - 1; i > 0; i--) {
                stringBuilder1.append(i).append(COMMA_DELIMITER).append("false,?,?,?,?,?,?")
                        .append(NEWLINE_DELIMITER);
            }
        }

        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(stringBuilder1.toString());
        } catch (IOException exception){
            throw new IOException("Could not write tournament back to file: " + exception.getMessage());
        }
    }

    public static void updateTournamentFileLocation()
    throws IOException{
        try {
            ArrayList<String> upcomingTournament = TournamentReader.readThroughUpcomingTournaments();

            for (String tournamentNameShortened : upcomingTournament){
                File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
                //If tournament is no longer upcoming
                if (!TournamentReader.isTournamentStillUpcoming(file)) {
                    ArrayList<String> tournament = GeneralReader.readFile(file);
                    //Remove tournament from upcoming Overview
                    removeTournamentFromUpcomingOverview(tournamentNameShortened);
                    //Write to ongoing overview
                    writeTournamentToOngoingOverview(tournamentNameShortened);
                    //Move entire tournament file to ongoing directory
                    if (file.delete()){
                        File newFile = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                "tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
                        try (FileWriter fileWriter = new FileWriter(newFile)){
                            StringBuilder stringBuilder = new StringBuilder();
                            for (String str : tournament){
                                stringBuilder.append(str).append(NEWLINE_DELIMITER);
                            }
                            fileWriter.write(stringBuilder.toString());
                        } catch (IOException exception){
                            throw new IOException("Could not write to ongoing tournaments: " +
                                    exception.getMessage());
                        }
                    }
                }
            }
        } catch (IOException exception){
            throw new IOException("Could not write upcoming tournament to ongoing tournaments: " +
                    exception.getMessage());
        }
        try {
            ArrayList<String> ongoingTournament = TournamentReader.readThroughOngoingTournaments();

            for (String tournamentNameShortened : ongoingTournament){
                File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                        "tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");

                if (!TournamentReader.isTournamentStillOngoing(file)){
                    ArrayList<String> tournament = GeneralReader.readFile(file);
                    removeTournamentFromOngoingOverview(tournamentNameShortened);
                    writeTournamentToPreviousOverview(tournamentNameShortened);
                    if (file.delete()){
                        File newFile = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                                "tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");
                        try (FileWriter fileWriter = new FileWriter(newFile)){
                            StringBuilder stringBuilder = new StringBuilder();
                            for (String str : tournament){
                                stringBuilder.append(str).append(NEWLINE_DELIMITER);
                            }
                            fileWriter.write(stringBuilder.toString());
                        } catch (IOException exception){
                            throw new IOException("Could not write to previous tournaments: " +
                                    exception.getMessage());
                        }
                    }
                }
            }
        } catch (IOException exception){
            throw new IOException("Could not write ongoing tournament to previous tournaments: " +
                    exception.getMessage());
        }

    }

    public static void removeTournamentFromUpcomingOverview(String tournamentName)
    throws IOException{
        try {
            String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
            ArrayList<String> upcomingTournaments = TournamentReader.readThroughUpcomingTournaments();
            File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
            removeTournamentFromOverview(tournamentNameShortened, upcomingTournaments, file);

        } catch (IOException exception){
            throw new IOException("Could not remove tournament from upcoming overview: "+ exception.getMessage());
        }
    }

    private static void removeTournamentFromOverview(String tournamentName, ArrayList<String> tournaments, File file)
    throws IOException{
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        tournaments.removeIf(s -> s.equals(tournamentNameShortened));
        StringBuilder stringBuilder = new StringBuilder();
        for (String tournament : tournaments){
            stringBuilder.append(tournament).append(NEWLINE_DELIMITER);
        }
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(stringBuilder.toString());
        } catch (IOException exception){
            throw new IOException("Could not write overview back to file: " + exception.getMessage());
        }
    }

    public static void removeTournamentFromOngoingOverview(String tournamentName) throws IOException{
        try {
            String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
            ArrayList<String> ongoingTournaments = TournamentReader.readThroughOngoingTournaments();
            File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/ongoingTournaments/ongoingTournaments.txt");
            removeTournamentFromOverview(tournamentNameShortened, ongoingTournaments, file);

        } catch (IOException exception){
            throw new IOException("Could not remove tournament from upcoming overview: "+ exception.getMessage());
        }
    }

    public static void removeTournamentFromPreviousOverview(String tournamentName) throws IOException{
        try {
            String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
            ArrayList<String> previousTournaments = TournamentReader.readThroughPreviousTournaments();
            File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/previousTournaments/previousTournaments.txt");
            removeTournamentFromOverview(tournamentNameShortened, previousTournaments, file);
        } catch (IOException exception){
            throw new IOException("Could not remove tournament from previous overview: "+ exception.getMessage());
        }
    }

    public static void writeMatchesToTournament(String tournamentName, Match inputMatch) throws IOException {

        int startIndex = 14;
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        File file = new File(getPathToTournamentFileAsString(tournamentNameShortened));
        ArrayList<String> fileAsList = GeneralReader.readFile(file);
        int bracketSize = Integer.parseInt(GeneralReader.readSpecificLineInFile(file,10));

        String[][] matchesData = new String[bracketSize-1][7];

        for (int i = 0; i < bracketSize - 1; i++) {
            matchesData[i] = GeneralReader.readSpecificLineInFile(file, startIndex + i).split(COMMA_DELIMITER);
        }

        String[] teams = GeneralReader.readSpecificLineInFile(file,13).split(COMMA_DELIMITER);


        // Setup
        if (matchesData[0][2].equalsIgnoreCase("?")) {
            for (int i = 0; i < teams.length; i++) {
                if (!Boolean.parseBoolean(matchesData[i / 2][1])) {
                    matchesData[i / 2][2 + i % 2] = teams[i];
                }
            }
        }


        //Takes the input and uses it
        if (inputMatch != null) {
            for (String[] match : matchesData) {
                if (inputMatch.getTeam1().getNameOfTeam().equals(match[2]) &&
                        inputMatch.getTeam2().getNameOfTeam().equals(match[3])){
                    if (inputMatch.getTimeOfMatch() != null){
                        match[4] = inputMatch.getTimeOfMatch().toString();
                        if (inputMatch.isFinished()){
                            match[1] = Boolean.toString(inputMatch.isFinished());
                            match[5] = Integer.toString(inputMatch.getMatchScoreTeam1());
                            match[6] = Integer.toString(inputMatch.getMatchScoreTeam2());
                            match[7] = inputMatch.getVictor().getNameOfTeam();
                        }
                    }
                }
            }
        }
        //Moves winning teams
        for(String[] match : matchesData) {
            if (Boolean.parseBoolean(match[1])){
                int firstMatchIndex = Integer.parseInt(match[0]);
                String winner = match[7];
                for(String[] secondMatch : matchesData) {
                    if (firstMatchIndex/2 == Integer.parseInt(secondMatch[0])){
                        secondMatch[3 - (firstMatchIndex % 2)] = winner;
                    }
                }
            }
        }
        if (Boolean.parseBoolean(matchesData[bracketSize-2][1])){
            fileAsList.set(0,"Finished");
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            stringBuilder.append(fileAsList.get(i)).append(NEWLINE_DELIMITER);
        }

        for (String[] Match : matchesData) {
            for (String data : Match) {
                stringBuilder.append(data).append(COMMA_DELIMITER);
            }
            stringBuilder.append(NEWLINE_DELIMITER);
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException exception) {
            throw new IOException("Could not write tournament back to file: " + exception.getMessage());
        }
    }
}
