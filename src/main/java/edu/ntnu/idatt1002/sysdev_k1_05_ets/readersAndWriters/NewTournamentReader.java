package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewTournamentReader {
    private static final String DELIMITER = "\n";

    public NewTournamentReader(){}


    public static ArrayList<String> readThroughOngoingTournaments() throws IOException{
        ArrayList<String> namesOfOngoingTournaments = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/ongoingTournaments.txt"))){
            if (!scanner.hasNext()){
                throw new IOException("File is empty");
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                line = Utilities.shortenAndReplaceUnnecessarySymbolsInString(line);
                namesOfOngoingTournaments.add(line);
            }
        }
        return namesOfOngoingTournaments;
    }

    public static ArrayList<String> readThroughPreviousTournaments() throws IOException{
        ArrayList<String> namesOfOngoingTournaments = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/previousTournaments/tournamentFileFormat.txt"))){
            if (!scanner.hasNext()){
                throw new IOException("File is empty");
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                line = Utilities.shortenAndReplaceUnnecessarySymbolsInString(line);
                namesOfOngoingTournaments.add(line);
            }
        }
        return namesOfOngoingTournaments;
    }

    public static ArrayList<String> readThroughUpcomingTournaments() throws IOException{
        ArrayList<String> namesOfOngoingTournaments = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt"))){
            if (!scanner.hasNext()){
                throw new IOException("File is empty");
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                line = Utilities.shortenAndReplaceUnnecessarySymbolsInString(line);
                namesOfOngoingTournaments.add(line);
            }
        }
        return namesOfOngoingTournaments;
    }

    /*
    public static boolean maximumAmountOfOngoingTournamentsReached() throws IOException{
        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/ongoingTournaments.txt"))){
            if (!scanner.hasNext()){
                throw new IOException("File is empty");
            }
            ArrayList<String> tournaments = new ArrayList<>();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                tournaments.add(line);
            }
            return tournaments.size() > 5;
        }
    }

    public static boolean maximumAmountOfUpcomingTournamentsReached() throws IOException{
        try (Scanner scanner = new Scanner(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt"))){
            if (!scanner.hasNext()){
                throw new IOException("File is empty");
            }
            ArrayList<String> tournaments = null;
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                tournaments.add(line);
            }
            return tournaments.size() > 10;
        }
    }
     */
}
