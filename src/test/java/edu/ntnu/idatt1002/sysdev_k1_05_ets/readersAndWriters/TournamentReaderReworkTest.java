package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.NewTournament;
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
            System.out.println(newTournament.toString());
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

}