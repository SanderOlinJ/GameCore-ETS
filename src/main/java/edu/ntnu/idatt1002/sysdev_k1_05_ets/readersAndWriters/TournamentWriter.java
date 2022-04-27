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
     Method checks if the file exists, and if it does, it will return the relative location.
     Used for finding out which folder we are working with,
     and if there is a file already existing with the name you intend to use.
     * @param tournamentNameShortened name of the tournament, shortened.
     * @return String of location
     */
    public static String ifFileExistsAndFindLocation(String tournamentNameShortened) {

        //Method first creates 3 separate files, where the folder location varies.
        File file1 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
        File file2 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
        File file3 = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");

        //It then checks if either of the files exists.
        //If it does, then it will return the location as a String of which folder it is.
        if (file1.exists()) {
            return "Ongoing";
        } else if (file2.exists()) {
            return "Upcoming";
        } else if (file3.exists()) {
            return "Previous";
        } else {
            return "No";
        }
        //There can only be 1 existing file with the specific name at a specific time.
        //Which means that you will not get the wrong location.
    }

    /**
     Takes in all basic tournament attributes as parameters (Everything except teams and matches),
     and then writes the tournament to file, in a custom designed format.
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
     * @throws IOException if data cannot be written to file or upcoming overview.
     */
    public static void writeNewTournamentToFileWithBasicInfo (
            String status, String tournamentName, String tournamentHost, LocalDate date, LocalTime time,
            String description, String game, String platform, String tournamentType,
            int numberOfTeams, int prizePool, String prizePoolCurrency, int entranceFee,
            String entranceFeeCurrency)
            throws IOException {

        //Uses shorten tournament name-method to get a file name for the new tournament.
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);

        //Removes potential delimiters in description, so to avoid future reader errors.
        description = description.replaceAll(NEWLINE_DELIMITER, " ");
        description = description.replaceAll(COMMA_DELIMITER," ");
        //Replaces a potentially empty description with "No description",
        if (description.equals("")) {
            description += "No description";
        }

        //Instantiates the String Builder with the properties we took in as parameters
        StringBuilder tournamentStringFormat = new StringBuilder(status + NEWLINE_DELIMITER + tournamentName +
                NEWLINE_DELIMITER + tournamentHost + NEWLINE_DELIMITER + date + NEWLINE_DELIMITER + time +
                NEWLINE_DELIMITER + description + NEWLINE_DELIMITER + game + NEWLINE_DELIMITER + platform +
                NEWLINE_DELIMITER + tournamentType + NEWLINE_DELIMITER + numberOfTeams + NEWLINE_DELIMITER +
                prizePool + COMMA_DELIMITER + prizePoolCurrency + NEWLINE_DELIMITER + entranceFee +
                COMMA_DELIMITER + entranceFeeCurrency + NEWLINE_DELIMITER);

        /*Method then writes to upcoming overview, as this method
        is only called when creating a tournament, which will only be allowed if the time set
        is in the future.*/
        File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
        try (FileWriter fileWriter = new FileWriter(file)){
            //First write to file
            fileWriter.write(tournamentStringFormat.toString());
            //Then write file name (tournamentNameShortened) to upcoming overview.
            writeTournamentToUpcomingOverview(tournamentNameShortened);
        } catch (IOException exception){
            throw new IOException("Could not write tournament to file: " + exception.getMessage());
        }
    }

    /**
     Takes in the shortened tournament name and writes it into the ongoing overview file.
     This makes it easier to later locate the individual tournament files.
     * @param tournamentNameShortened name of the tournament
     * @throws IOException if tournament name cannot be written to overview
     */
    public static void writeTournamentToOngoingOverview(String tournamentNameShortened)
    throws IOException{
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
    Takes in the shortened tournament name and writes it into the upcoming overview file.
    This makes it easier to later locate the individual tournament files.
     * @param tournamentNameShortened name of the tournament, String
     * @throws IOException if tournament name cannot be written to overview
     */
    public static void writeTournamentToUpcomingOverview(String tournamentNameShortened)
    throws IOException{
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
     Takes in the shortened tournament name and writes it into the previous overview file.
     This makes it easier to later locate the individual tournament files.
     * @param tournamentName name of the tournament, String
     * @throws IOException if tournament name cannot be written to overview
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

    /**
     Method to find which folder (ongoing-, upcoming- or previous tournaments)
     the file of a tournament is located in.
     * @param tournamentName name of the tournament, String
     * @return File path of the tournament
     * @throws IOException if tournament file could not be found
     */
    public static String getPathToTournamentFileAsString(String tournamentName)
    throws IOException {
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);

        //First the method looks for which folder the tournament is located in
        String location = ifFileExistsAndFindLocation(tournamentNameShortened);

        //It then returns the exact location, based on the folder location.
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
     Method writes teams to an already existing tournament file.
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
        //First the method fetches the file path of the tournament
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        File file = new File(getPathToTournamentFileAsString(tournamentNameShortened));

        //The method then reads the file to an arraylist
        ArrayList<String> fileAsListOfStrings = GeneralReader.readFile(file);
        StringBuilder stringBuilder = new StringBuilder();

        //Then the teams are added to a string builder
        for (Team team : teams){
            stringBuilder.append(team.getNameOfTeam()).append(COMMA_DELIMITER);
        }
        //If the arraylist is not of size 13, it means that teams have not been added yet.
        //It then adds another line where the teams are supposed to go
        if (fileAsListOfStrings.size() < 13){
            fileAsListOfStrings.add("");
        }

        //The 12th index is the replaced with the teams.
        //This will also replace the line if teams have already been added to the tournament
        //Which makes this method useful for editing teams as well.
        fileAsListOfStrings.set(12,stringBuilder.toString());

        //The arraylist is then written to a string builder
        StringBuilder stringBuilder1 = new StringBuilder();
        for (String str : fileAsListOfStrings){
            stringBuilder1.append(str).append(NEWLINE_DELIMITER);
        }
        /*If all teams in the tournament were added, (8 teams to an 8-team-bracket),
        then the method will place upcoming matches to the string builder.
        */
        if (teams.size() == Integer.parseInt(fileAsListOfStrings.get(9))){
            for (int i = (Integer.parseInt(fileAsListOfStrings.get(9))) - 1; i > 0; i--) {
                stringBuilder1.append(i).append(COMMA_DELIMITER).append("false,?,?,?,?,?,?")
                        .append(NEWLINE_DELIMITER);
            }
        }
        //The string builder with the tournament is then written back to the tournament file.
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

    /**
     * Parses through the tournament file, and takes the last lines containing the matches information for the tournament
     * and places them in an array containing all the information. Afterwards it iterates through the teams and places
     * them in corresponding matches based on position in array. Every time this method is called it will look for winner of
     * each match, and using the index of the match will place it into the new position. Each power of 2 represents one round further
     * so the index is simply divided by two.
     * @param tournamentName Takes in tournament name to open the file
     * @param inputMatch Takes in a match that is being modified to tournament
     * @throws IOException
     */
    public static void writeMatchesToTournament(String tournamentName, Match inputMatch) throws IOException {

        //Index where teams are listed
        int startIndex = 14;
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        File file = new File(getPathToTournamentFileAsString(tournamentNameShortened));
        ArrayList<String> fileAsList = GeneralReader.readFile(file);
        int bracketSize = Integer.parseInt(GeneralReader.readSpecificLineInFile(file,10));

        String[][] matchesData = new String[bracketSize-1][7];

        //Parses the last number of lines, using bracket size to determine how many
        //and reads all of the lines
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

        //Copies the beginning of the file to preserve it when file is updated
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            stringBuilder.append(fileAsList.get(i)).append(NEWLINE_DELIMITER);
        }

        //Converts the array of matches data to the string builder so it gets stored in the file
        for (String[] Match : matchesData) {
            for (String data : Match) {
                stringBuilder.append(data).append(COMMA_DELIMITER);
            }
            stringBuilder.append(NEWLINE_DELIMITER);
        }
        //Writes the string builder to the file
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException exception) {
            throw new IOException("Could not write tournament back to file: " + exception.getMessage());
        }
    }
}
