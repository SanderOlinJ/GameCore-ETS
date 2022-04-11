package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TournamentWriterRework {

    private static final String DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";

    public TournamentWriterRework() {}

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
     * Writes tournament basic info to file, no teams or matches
     * Also writes tournament to overview
     * @param status
     * @param tournamentName
     * @param tournamentHost
     * @param date
     * @param description
     * @param game
     * @param platform
     * @param tournamentType
     * @param bestOf
     * @param numberOfTeams
     * @throws IOException
     */
    public static void writeNewTournamentToFileWithBasicInfo(String status, String tournamentName, String tournamentHost,
                                                             LocalDate date, String description, String game, String platform,
                                                             String tournamentType, String bestOf, String numberOfTeams)
            throws IOException {
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);

        description = description.replaceAll("\n", " ");
        if (description.equals("")) {
            description += "No description";
        }
        String tournamentStringFormat = status + DELIMITER + tournamentName + DELIMITER + tournamentHost + DELIMITER +
                date + DELIMITER + description + DELIMITER + game + DELIMITER + platform +
                DELIMITER + tournamentType + DELIMITER + bestOf + DELIMITER + numberOfTeams +
                DELIMITER;

        if (date.isEqual(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(tournamentStringFormat);
                writeTournamentToOngoingOverview(tournamentNameShortened);
            } catch (IOException exception) {
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }

        } else if (date.isAfter(LocalDate.now())) {

            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(tournamentStringFormat);
                writeTournamentToUpcomingOverview(tournamentNameShortened);
            } catch (IOException exception) {
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }
        } else {
            File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(tournamentStringFormat);
                writeTournamentToPreviousOverview(tournamentNameShortened);
            } catch (IOException exception) {
                throw new IOException("Could not write tournament to file: " + exception.getMessage());
            }
        }
    }


    /**
     * Writes tournament name to ongoing overview file
     * @param tournamentNameShortened
     * @throws IOException
     */
    public static void writeTournamentToOngoingOverview(String tournamentNameShortened)
    throws IOException{
        String overviewStringFormat = tournamentNameShortened + DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/ongoingTournaments.txt");
        try (FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(overviewStringFormat);
        } catch (IOException exception){
            throw new IOException("Could not write tournament to ongoing overview");
        }
    }

    /**
     * Writes tournament name to upcoming overview file
     * @param tournamentNameShortened
     * @throws IOException
     */
    public static void writeTournamentToUpcomingOverview(String tournamentNameShortened)
    throws IOException{
        String overviewStringFormat = tournamentNameShortened + DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
        try(FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(overviewStringFormat);
        }catch (IOException exception){
            throw new IOException("Could not write tournament to upcoming overview");
        }
    }
    public static void writeTournamentToPreviousOverview(String tournamentNameShortened)
            throws IOException{
        String overviewStringFormat = tournamentNameShortened + DELIMITER;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/previousTournaments/previousTournaments.txt");
        try(FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(overviewStringFormat);
        }catch (IOException exception){
            throw new IOException("Could not write tournament to previous overview");
        }
    }

    public static void removeTournamentFromOverview(String tournamentNameShortened)
    throws IOException{
        ArrayList<String> ongoingTournaments = TournamentReaderRework.readThroughOngoingTournaments();
        ArrayList<String> upcomingTournaments = TournamentReaderRework.readThroughUpcomingTournaments();
        ArrayList<String> previousTournaments = TournamentReaderRework.readThroughPreviousTournaments();
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
        File newOverview = new File(file.getPath());
        ArrayList<String> overview = GeneralReader.readFile(file);
        overview.removeIf(tournament -> tournament.equals(tournamentNameShortened));
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : overview){
            stringBuilder.append(string).append(DELIMITER);
        }
        if (file.delete()){
            try (FileWriter fileWriter = new FileWriter(newOverview)){
                fileWriter.write(stringBuilder.toString());
            } catch (IOException exception){
                throw new IOException("Could not write new overview to file: " + exception.getMessage());
            }
        }
    }

    public static void writeTeamsToTournamentFile(String tournamentNameShortened, ArrayList<Team> teams)
    throws IOException{
        File file = new File(getPathToTournamentFileAsString(tournamentNameShortened));
        StringBuilder stringBuilder = new StringBuilder();
        for (Team team : teams){
            stringBuilder.append(team.getNameOfTeam()).append(COMMA_DELIMITER);
        }

        try (FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(stringBuilder.toString());
        } catch (IOException exception){
            throw new IOException("Could not write teams to file: " + exception.getMessage());
        }
    }

    private static String getPathToTournamentFileAsString(String tournamentNameShortened)
    throws IOException {

        String location = ifFileExistsAndFindLocation(tournamentNameShortened);

        File file = switch (location){
            case "Ongoing" -> new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
            case "Upcoming" -> new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
            case "Previous" -> new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                    "tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");
            default -> throw new IOException("Could not find tournament file");
        };

        return location;
    }

    public static void editTeamsToTournamentFile(String tournamentNameShortened, ArrayList<Team> teams)
    throws IOException{

        File file = new File(getPathToTournamentFileAsString(tournamentNameShortened));
        ArrayList<String> fileAsString = GeneralReader.readFile(file);
        StringBuilder stringBuilder = new StringBuilder();

        for (Team team : teams){
            stringBuilder.append(team.getNameOfTeam()).append(COMMA_DELIMITER);
        }
        fileAsString.set(10,stringBuilder.toString());

        StringBuilder stringBuilder1 = new StringBuilder();
        for (String str : fileAsString){
            stringBuilder1.append(str).append(DELIMITER);
        }
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(stringBuilder1.toString());
        } catch (IOException exception){
            throw new IOException("Could not write tournament back to file: " + exception.getMessage());
        }
    }

}
