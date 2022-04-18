package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TournamentReaderReworkTest {

    @Test

    void testThatReadTournamentFromFileRuns(){
        String tournamentName = "completeTestFile";
        try {
            NewTournament newTournament = TournamentReaderRework.readTournamentFromFile(tournamentName);
            System.out.println(newTournament);
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThatIsTournamentStillUpcoming(){
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/testFile4.txt");

        try {
            assertTrue(TournamentReaderRework.isTournamentStillUpcoming(file));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThatIsTournamentStillOngoing(){
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/testFile4.txt");

        try {
            assertTrue(TournamentReaderRework.isTournamentStillOngoing(file));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThat(){
        try {

            TournamentReaderRework.readThroughUpcomingTournaments();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

}