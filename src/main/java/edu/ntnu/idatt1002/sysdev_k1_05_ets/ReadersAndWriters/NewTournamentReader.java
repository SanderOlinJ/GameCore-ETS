package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.Utilities.Utilities;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
                "tournamentFiles/previousTournaments/previousTournaments.txt"))){
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
}
