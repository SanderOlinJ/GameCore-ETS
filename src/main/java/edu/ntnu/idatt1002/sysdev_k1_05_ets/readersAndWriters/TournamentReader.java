package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for reading tournament file to tournament objects, as well as managing file location.
 */
public class TournamentReader {

    private static final String COMMA_DELIMITER = ",";

    public TournamentReader(){}

    /**
     * Reads all available info from tournament file to tournament
     * Method can read tournament even without teams and matches listed.
     * Method only reads for teams if file size suggests so, and will only read for matches
     * if teams have been added.
     * @param tournamentName name of the tournament
     * @return tournament, if the tournament exists.
     * @throws IOException if tournament file does not exist, or if file could not be read
     */
    public static Tournament readTournamentFromFile(String tournamentName)
    throws IOException {

        //Method first retrieves the tournament file location
        String tournamentNameShortened = Utilities.shortenAndReplaceUnnecessarySymbolsInString(tournamentName);
        String location = TournamentWriter.ifFileExistsAndFindLocation(tournamentNameShortened);

        File file = switch (location) {
            case "Ongoing" -> new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
            case "Upcoming" -> new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
            case "Previous" -> new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");
            default -> throw new IOException("File doesn't exist");
        };

        //The file is then read to a list
        ArrayList<String> tournamentInfo = new ArrayList<>();
        try {
            try(Scanner scanner = new Scanner(file)){
                while (scanner.hasNext()){
                    tournamentInfo.add(scanner.nextLine());
                }
            }
        } catch (IOException exception){
            throw new IOException("Could not read from file");
        }

        //We then assign each of the tournament attributes their respective values.
        String status = tournamentInfo.get(0);
        String nameOfTournament = tournamentInfo.get(1);
        String tournamentHost = tournamentInfo.get(2);
        LocalDate date = LocalDate.parse(tournamentInfo.get(3));
        LocalTime time = LocalTime.parse(tournamentInfo.get(4));
        String description = tournamentInfo.get(5);
        String game = tournamentInfo.get(6);
        String platform = tournamentInfo.get(7);
        String tournamentType = tournamentInfo.get(8);
        int numberOfTeams = Integer.parseInt(tournamentInfo.get(9));

        String prizePoolLine = tournamentInfo.get(10);
        String[] prizePoolValues = prizePoolLine.split(COMMA_DELIMITER);
        int prizePool = Integer.parseInt(prizePoolValues[0]);
        String prizePoolCurrency = prizePoolValues[1];

        String entranceFeeLine = tournamentInfo.get(11);
        String[] entranceFeeValues = entranceFeeLine.split(COMMA_DELIMITER);
        int entranceFee = Integer.parseInt(entranceFeeValues[0]);
        String entranceFeeCurrency = entranceFeeValues[1];

        //The tournament object is then instantiated with its properties.
        Tournament tournament = new Tournament(status, nameOfTournament,tournamentHost,
                date,time,description,game,platform,tournamentType,numberOfTeams,
                prizePool, prizePoolCurrency, entranceFee, entranceFeeCurrency);

        /*
        If the arraylist is larger than 12, it means that teams have been added to the tournament file
        Method then splits up the index 12 line in list, and passes the values (the team names)
        to TeamReader, which in return gives us the fully detailed teams from the all_Teams.csv file.
        */
        if (tournamentInfo.size() > 12) {
            ArrayList<Team> teams = new ArrayList<>();
            String line = tournamentInfo.get(12);
            String[] values = line.split(COMMA_DELIMITER);
            for (String value : values) {
                Team team = TeamReader.findAndReturnTeamUsingTeamName(value);
                teams.add(team);
            }
            tournament.setTeams(teams);

            /*
            If the arraylist is larger than 13, it means that all teams have been added to the tournament
            and that the matches have been written, even if no matches have been played.
            We then pass the arraylist to MatchReader, which in return gives us Match objects.
             */
            if (tournamentInfo.size() > 13){
                ArrayList<Match> matches = MatchReader.readMatchesFromArrayList(tournamentInfo);
                tournament.setMatches(matches);
            }

        }
        return tournament;
    }

    /**
     * Method for reading through the ongoing overview and returning tournament names in the file.
     * @return List of tournament names in overview.
     * @throws FileNotFoundException if file does not exist
     */
    public static ArrayList<String> readThroughOngoingTournaments() throws FileNotFoundException {
        ArrayList<String> namesOfOngoingTournaments = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/ongoingTournaments.txt"))){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                namesOfOngoingTournaments.add(line);
            }
        }
        return namesOfOngoingTournaments;
    }

    /**
     * Method for reading through the previous overview and returning tournament names in the file.
     * @return List of tournament names in overview.
     * @throws FileNotFoundException if file does not exist
     */
    public static ArrayList<String> readThroughPreviousTournaments() throws FileNotFoundException{
        ArrayList<String> namesOfOngoingTournaments = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/previousTournaments/previousTournaments.txt"))){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                namesOfOngoingTournaments.add(line);
            }
        }
        return namesOfOngoingTournaments;
    }

    /**
     * Method for reading through the upcoming overview and returning tournament names in the file.
     * @return List of tournament names in overview.
     * @throws FileNotFoundException if file does not exist
     */
    public static ArrayList<String> readThroughUpcomingTournaments() throws FileNotFoundException {
        ArrayList<String> namesOfOngoingTournaments = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt"))){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                namesOfOngoingTournaments.add(line);
            }
        }
        return namesOfOngoingTournaments;
    }

    /**
     * Method checks if the given tournament is still an "upcoming" tournament
     * @param file file of the potentially upcoming tournament
     * @return true if still upcoming, false if not
     * @throws IOException if file could not be read
     */
    public static boolean isTournamentStillUpcoming(File file) throws IOException{
        try {
            //Retrieves the vital information for what decides an upcoming tournament
            String status = GeneralReader.readSpecificLineInFile(file,1);
            LocalDate date = LocalDate.parse(GeneralReader.readSpecificLineInFile(file,4));
            LocalTime time = LocalTime.parse(GeneralReader.readSpecificLineInFile(file, 5));

            return date.isAfter(LocalDate.now()) && status.equals("Not finished") ||
                    date.isEqual(LocalDate.now()) && time.isAfter(LocalTime.now()) && status.equals("Not finished");
        } catch (IOException exception){
            throw new IOException("Could not read through file: " + exception.getMessage());
        }
    }

    /**
     * Method checks if the given tournament is still an "ongoing" tournament
     * @param file file of the potentially ongoing tournament
     * @return true if still ongoing, false if not
     * @throws IOException if file could not be read
     */
    public static boolean isTournamentStillOngoing(File file) throws IOException{
        try {
            //Retrieves the vital information for what decides an ongoing tournament
            String status = GeneralReader.readSpecificLineInFile(file,1);
            LocalDate date = LocalDate.parse(GeneralReader.readSpecificLineInFile(file,4));
            LocalTime time = LocalTime.parse(GeneralReader.readSpecificLineInFile(file,5));

            return date.isEqual(LocalDate.now()) && time.equals(LocalTime.now()) && status.equals("Not finished") ||
                    date.isEqual(LocalDate.now()) && time.isBefore(LocalTime.now()) && status.equals("Not finished") ||
                    date.isBefore(LocalDate.now()) && status.equals("Not finished");
        } catch (IOException exception){
            throw new IOException("Could not read through file: " + exception.getMessage());
        }
    }

    /**
     * Method for reading all tournaments in the ongoing overview to a list of tournaments
     * @param n Number of tournaments from the ongoing overview that you want returned,
     *          if 0, it will return all
     * @return List of ongoing tournaments
     * @throws IOException if overview file could not be read.
     */
    public static ArrayList<Tournament> readAllOngoingTournamentsToList(int n)
    throws IOException{

        ArrayList<Tournament> ongoingTournaments = new ArrayList<>();
        try {
            //Method reads all ongoing tournaments' names
            ArrayList<String> tournaments = readThroughOngoingTournaments();
            if (n == 0){
                n = tournaments.size();
            }
            /*
            Then retrieves each tournament as object.
            Number based on input value, it will return all if 0.
            */
            for (int i = 0; i < tournaments.size() && i < n; i++){
                ongoingTournaments.add(readTournamentFromFile(tournaments.get(i)));
            }
        } catch (IOException exception){
            throw new IOException("Could not fetch ongoing tournaments: " + exception.getMessage());
        }

        return ongoingTournaments;
    }

    /**
     * Method for reading all tournaments in the upcoming overview to a list of tournaments
     * @param n Number of tournaments from the upcoming overview that you want returned,
     *          if 0, it will return all
     * @return List of upcoming tournaments
     * @throws IOException if overview file could not be read.
     */
    public static ArrayList<Tournament> readAllUpcomingTournamentsToList(int n)
            throws IOException{

        ArrayList<Tournament> upcomingTournaments = new ArrayList<>();
        try {
            //Method reads all upcoming tournaments' names
            ArrayList<String> tournaments = readThroughUpcomingTournaments();
            if (n == 0){
                n = tournaments.size();
            }
            /*
            Then retrieves each tournament as object.
            Number based on input value, it will return all if 0.
            */
            for (int i = 0; i < tournaments.size() && i < n; i++){
                upcomingTournaments.add(readTournamentFromFile(tournaments.get(i)));
            }
        } catch (IOException exception){
            throw new IOException("Could not fetch upcoming tournaments: " + exception.getMessage());
        }

        return upcomingTournaments;
    }

    /**
     * Method for reading all tournaments in the previous overview to a list of tournaments
     * @param n Number of tournaments from the previous overview that you want returned,
     *          if 0, it will return all
     * @return List of previous tournaments
     * @throws IOException if overview file could not be read.
     */
    public static ArrayList<Tournament> readAllPreviousTournamentsToList(int n)
            throws IOException{

        ArrayList<Tournament> previousTournaments = new ArrayList<>();
        try {
            //Method reads all previous tournaments' names
            ArrayList<String> tournaments = readThroughPreviousTournaments();
            if (n == 0){
                n = tournaments.size();
            }
            /*
            Then retrieves each tournament as object.
            Number based on input value, it will return all if 0.
            */
            for (int i = 0; i < tournaments.size() && i < n; i++){
                previousTournaments.add(readTournamentFromFile(tournaments.get(i)));
            }
        } catch (IOException exception){
            throw new IOException("Could not fetch previous tournaments: " + exception.getMessage());
        }

        return previousTournaments;
    }

}
