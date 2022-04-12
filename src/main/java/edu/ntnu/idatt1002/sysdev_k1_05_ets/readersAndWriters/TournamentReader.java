package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TournamentReader {
    private static final String DELIMITER = ",";

    public TournamentReader(){}

    public Tournament readTournament(File file) throws IOException {
        ArrayList<Team> teams = new ArrayList<Team>();
        String tournamentName = "";
        String gameName = "";
        try(Scanner scanner = new Scanner(file)){
            if (!scanner.hasNext()){throw new IOException("File is empty");}
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] values = line.split(DELIMITER);
                tournamentName = values[0];
                for (int i = 1; i < values.length; i++){
                    teams.add(new Team(values[i], values[i].substring(0,3)));
                }
            }
        }
        return new Tournament(teams, tournamentName, gameName, teams.size());
    }
}
