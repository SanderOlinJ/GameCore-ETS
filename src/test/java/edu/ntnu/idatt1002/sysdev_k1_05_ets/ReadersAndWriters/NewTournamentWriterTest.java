package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NewTournamentWriterTest {

    @Test
    void testThatNewWriteTournamentToFileWithoutTeamsRuns() throws IOException {
        String tournamentName = "Valorant Tournament";
        String tournamentHost = "Admin";
        String description = "Yo what's up?";
        String game = "Valorant";
        String platform = "PC / Mac / Linux";
        String tournamentType = "Brackets";
        String totalNumberOfTeams = "8";

        NewTournamentWriter.writeTournamentToFileWithoutTeams(tournamentName, tournamentHost, description,
                game, platform, tournamentType, totalNumberOfTeams);
    }

    @Test
    void testThatWriteTeamsToTournamentRuns() throws IOException {
        String tournamentName = "Valorant Tournament";
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(new Team("Sander"));
        teams.add(new Team("Joakim"));
        teams.add(new Team("Beka"));

        NewTournamentWriter.writeTeamsToTournament(tournamentName, teams);
    }
}