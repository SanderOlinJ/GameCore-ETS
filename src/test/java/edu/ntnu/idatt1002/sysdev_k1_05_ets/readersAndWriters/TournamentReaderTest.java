package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TournamentReaderTest {

    @Test

    void testThatReadTournamentFromFileRuns() throws IOException{
        String tournamentName = "Ongoing Tournament";
        Tournament tournament = TournamentReader.readTournamentFromFile(tournamentName);
        System.out.println(tournament);

    }

    @Test
    void testThatIsTournamentStillUpcomingRuns(){
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/UpcomingTournament.txt");

        try {
            assertTrue(TournamentReader.isTournamentStillUpcoming(file));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThatIsTournamentStillOngoing(){
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/OngoingTournament.txt");

        try {
            assertTrue(TournamentReader.isTournamentStillOngoing(file));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}