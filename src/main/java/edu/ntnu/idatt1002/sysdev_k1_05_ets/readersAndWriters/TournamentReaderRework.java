package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TournamentReaderRework {

    private static final String DELIMITER = "\n";
    private static final String COMMA_DELIMITER = ",";

    public TournamentReaderRework(){}

    /**
     * Reads all info from tournament file to tournament
     * Including teams and matches.
     * @param tournamentNameShortened
     * @return
     * @throws IOException
     */
    public static NewTournament readTournamentFromFile(String tournamentNameShortened)
    throws IOException {
        String location = TournamentWriterRework.ifFileExistsAndFindLocation(tournamentNameShortened);

        File file = switch (location) {
            case "No" -> throw new IOException("File doesn't exist");
            case "Ongoing" -> new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/" + tournamentNameShortened + ".txt");
            case "Upcoming" -> new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/" + tournamentNameShortened + ".txt");
            case "Previous" -> new File("src/main/resources/edu/ntnu/idatt1002/" +
                    "sysdev_k1_05_ets/tournamentFiles/previousTournaments/" + tournamentNameShortened + ".txt");
            default -> null;
        };
        ArrayList<String> tournamentInfo = new ArrayList<>();
        try {
            assert file != null;
            try(Scanner scanner = new Scanner(file)){
                while (scanner.hasNext()){
                    tournamentInfo.add(scanner.nextLine());
                }
            }
        } catch (IOException exception){
            throw new IOException("Could not read from file");
        }

        String status = tournamentInfo.get(0);
        String tournamentName = tournamentInfo.get(1);
        String tournamentHost = tournamentInfo.get(2);
        LocalDate date = LocalDate.parse(tournamentInfo.get(3));
        LocalTime time = LocalTime.parse(tournamentInfo.get(4));
        String description = tournamentInfo.get(5);
        String game = tournamentInfo.get(6);
        String platform = tournamentInfo.get(7);
        String tournamentType = tournamentInfo.get(8);
        String bestOf =tournamentInfo.get(9);
        String numberOfTeams = tournamentInfo.get(10);

        String prizePoolLine = tournamentInfo.get(11);
        String[] prizePoolValues = prizePoolLine.split(COMMA_DELIMITER);
        String prizePool = prizePoolValues[0];
        String prizePoolCurrency = prizePoolValues[1];

        String entranceFeeLine = tournamentInfo.get(12);
        String[] entranceFeeValues = entranceFeeLine.split(COMMA_DELIMITER);
        String entranceFee = entranceFeeValues[0];
        String entranceFeeCurrency = entranceFeeValues[1];

        NewTournament tournament = new NewTournament(status, tournamentName,tournamentHost,
                date,time,description,game,platform,tournamentType,bestOf,numberOfTeams,
                prizePool, prizePoolCurrency, entranceFee, entranceFeeCurrency);

        if (tournamentInfo.size() > 13) {
            ArrayList<Team> teams = new ArrayList<>();
            String line = tournamentInfo.get(11);
            String[] values = line.split(COMMA_DELIMITER);
            for (String value : values) {
                Team team = TeamReader.findAndReturnTeamUsingTeamName(value);
                teams.add(team);
            }
            tournament.setTeams(teams);

            if (tournamentInfo.size() > 14){
                ArrayList<Match> matches = MatchReader.readMatchesFromArrayList(tournamentInfo);
                tournament.setMatches(matches);
            }

        }

        return tournament;
    }

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

    public static boolean isTournamentStillUpcoming(File file) throws IOException{
        try {
            String status = GeneralReader.readSpecificLineInFile(file,1);
            LocalDate date = LocalDate.parse(GeneralReader.readSpecificLineInFile(file,4));
            LocalTime time = LocalTime.parse(GeneralReader.readSpecificLineInFile(file, 5));

            return date.isAfter(LocalDate.now()) && status.equals("Not finished") ||
                    date.isEqual(LocalDate.now()) && time.isAfter(LocalTime.now()) && status.equals("Not finished");
        } catch (IOException exception){
            throw new IOException("Could not read through file: " + exception.getMessage());
        }
    }

    public static boolean isTournamentStillOngoing(File file) throws IOException{
        try {
            String status = GeneralReader.readSpecificLineInFile(file,1);
            LocalDate date = LocalDate.parse(GeneralReader.readSpecificLineInFile(file,4));
            LocalTime time = LocalTime.parse(GeneralReader.readSpecificLineInFile(file,5));

            return date.isEqual(LocalDate.now()) && time.equals(LocalTime.now()) && status.equals("Not finished") ||
                    date.isEqual(LocalDate.now()) && time.isBefore(LocalTime.now()) && status.equals("Not finished") ||
                    date.isBefore(LocalDate.now()) && status.equals("Not finished");
        } catch (IOException exception){
            throw new IOException("Coudl not read through file: " + exception.getMessage());
        }
    }


    public static ArrayList<NewTournament> showOngoingTournamentsAtMainPage()
    throws IOException{
        ArrayList<NewTournament> ongoingTournaments = new ArrayList<>();
        try {
            ArrayList<String> tournaments = readThroughOngoingTournaments();
            for (int i = 0; i < tournaments.size() && i < 2; i++){
                ongoingTournaments.add(readTournamentFromFile(tournaments.get(i)));
            }
        } catch (IOException exception){
            throw new IOException("Could not fetch ongoing tournaments: " + exception.getMessage());
        }

        return ongoingTournaments;
    }

    public static ArrayList<NewTournament> showUpcomingTournamentsAtMainPage()
            throws IOException{
        ArrayList<NewTournament> upcomingTournaments = new ArrayList<>();
        try {
            ArrayList<String> tournaments = readThroughUpcomingTournaments();
            for (int i = 0; i < tournaments.size() && i < 2; i++){
                upcomingTournaments.add(readTournamentFromFile(tournaments.get(i)));
            }
        } catch (IOException exception){
            throw new IOException("Could not fetch upcoming tournaments: " + exception.getMessage());
        }

        return upcomingTournaments;
    }

    public static ArrayList<NewTournament> showPreviousTournamentsAtMainPage()
            throws IOException{
        ArrayList<NewTournament> previousTournaments = new ArrayList<>();
        try {
            ArrayList<String> tournaments = readThroughPreviousTournaments();
            for (int i = 0; i < tournaments.size() && i < 2; i++){
                previousTournaments.add(readTournamentFromFile(tournaments.get(i)));
            }
        } catch (IOException exception){
            throw new IOException("Could not fetch previous tournaments: " + exception.getMessage());
        }

        return previousTournaments;
    }

}
