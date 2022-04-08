package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NewTournamentWriterTest {

    @Test
    void testThatNewWriteTournamentToFileWithoutTeamsRuns() throws IOException {
        String status = "Not finished";
        String tournamentName = "Valorant Tournament";
        String tournamentHost = "Admin";
        String description = "Yo what's up?";
        String game = "Valorant";
        String platform = "PC / Mac / Linux";
        String tournamentType = "Brackets";
        String bestOf = "3";
        String totalNumberOfTeams = "8";
        LocalDate date = LocalDate.now();

        NewTournamentWriter.writeOngoingOrUpcomingTournamentToFileWithoutTeams(status, tournamentName, tournamentHost, date,
                description, game, platform, tournamentType, bestOf, totalNumberOfTeams);
    }

    @Test
    void testThatWriteTournamentToFileWithoutTeamsWritesToCorrectLocation() throws IOException{
        String status = "Not finished";
        String tournamentName = "League of Legends Tournament";
        String tournamentHost = "Admin";
        String description = "Yo what's up?";
        String game = "Valorant";
        String platform = "PC / Mac / Linux";
        String tournamentType = "Brackets";
        String bestOf = "3";
        String totalNumberOfTeams = "8";
        LocalDate date = LocalDate.now();

        NewTournamentWriter.writeOngoingOrUpcomingTournamentToFileWithoutTeams(status, tournamentName, tournamentHost, date,
                description, game, platform, tournamentType, bestOf, totalNumberOfTeams);

        assertTrue(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/tournamentFiles" +
                "/ongoingTournaments/LeagueofLegendsTournament.txt").exists());
    }
/*
    @Test
    void testThatWriteTeamsToTournamentRuns() throws IOException {
        String tournamentName = "Valorant Tournament";
        String numberOfTeams = "8";
        LocalDate date = LocalDate.now();
        ArrayList<String> teams = new ArrayList<>();
        teams.add("Sander");
        teams.add("Joakim");
        teams.add("Beka");

        NewTournamentWriter.writeTeamsToTournament(tournamentName,date,numberOfTeams, teams);
    }

 */

    @Test
    void testThatRemoveTournamentFromUpcomingTournamentsRuns() throws IOException{
        String tournamentNameShortened = "ValorantTourny";
        String tournaments = """
                LeagueofLegendsTourny
                ValorantTourny
                CSGOTourny
                """;
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(tournaments);
        }

        assertTrue(NewTournamentWriter.removeTournamentFromUpcomingTournaments(tournamentNameShortened));
    }

    @Test
    void testThatUpdateTournamentsRuns() throws IOException{

        NewTournamentWriter.updateTournaments();

    }
}