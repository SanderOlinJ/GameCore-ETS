package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TournamentReaderTest {

    @Test

    void testThatReadTournamentFromFileRuns(){
        String tournamentName = "Test4";
        try {
            Tournament tournament = TournamentReader.readTournamentFromFile(tournamentName);
            System.out.println(tournament);
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThatIsTournamentStillUpcoming(){
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/testFile4.txt");

        try {
            assertTrue(TournamentReader.isTournamentStillUpcoming(file));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThatIsTournamentStillOngoing(){
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/testFile4.txt");

        try {
            assertTrue(TournamentReader.isTournamentStillOngoing(file));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThat(){
        try {
            TournamentReader.readThroughUpcomingTournaments();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

}