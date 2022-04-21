package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TournamentWriterReworkTest {

    @Test
    void testThatIfFileExistsAndFindLocationReturnsCorrectLocation(){
        String fileName = "testFile1";

        assertEquals("Previous",TournamentWriterRework.ifFileExistsAndFindLocation(fileName));
    }

    @Test
    void testThatWriteNewTournamentToFileWithBasicInfoRuns(){
        String status = "Not finished";
        String tournamentName = "Test 15";
        String tournamentHost = "Admin";
        LocalDate date = LocalDate.parse("2022-04-18");
        LocalTime time = LocalTime.parse("00:05");
        String description = "";
        String game = "Valorant";
        String platform = "PC / Mac / Linux";
        String tournamentType = "Brackets";
        String numberOfTeams = "4";
        String prizePool = "0";
        String prizePoolCurrency = "null";
        String entranceFee = "0";
        String entranceFeeCurrency = "null";

        try {
            TournamentWriterRework.writeNewTournamentToFileWithBasicInfo(status, tournamentName, tournamentHost,
                    date, time, description, game, platform, tournamentType, numberOfTeams,
                    prizePool, prizePoolCurrency, entranceFee, entranceFeeCurrency);
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testThatEveryWriteTournamentToOverviewFileRun(){
        String fileNameOngoing = "testFileOngoing";
        String fileNameUpcoming = "testFileUpcoming";
        String fileNamePrevious = "testFilePrevious";
        try {
            TournamentWriterRework.writeTournamentToOngoingOverview(fileNameOngoing);
            TournamentWriterRework.writeTournamentToUpcomingOverview(fileNameUpcoming);
            TournamentWriterRework.writeTournamentToPreviousOverview(fileNamePrevious);
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThatRemoveTournamentFromOverview(){
        String fileNameOngoing = "testFileOngoing";

        try{
            TournamentWriterRework.removeTournamentFromOverviewWhenLocationNotKnown(fileNameOngoing);
        } catch (IOException exception){
            System.out.println(exception.getMessage());
            fail();
        }
    }

    @Test
    void testThatUpdateTournamentFileLocationRuns(){
        try {
            TournamentWriterRework.updateTournamentFileLocation();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

}