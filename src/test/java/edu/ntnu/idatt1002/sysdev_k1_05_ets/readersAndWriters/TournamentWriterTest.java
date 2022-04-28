package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TournamentWriterTest {

    @Test
    void testThatIfFileExistsAndFindLocationReturnsCorrectLocation(){
        String fileName = "OngoingTournament";

        assertEquals("Ongoing", TournamentWriter.ifFileExistsAndFindLocation(fileName));
    }

    @Test
    void testThatWriteNewTournamentToFileWithBasicInfoRuns() throws IOException{
        String status = "Not finished";
        String tournamentName = "Test";
        String tournamentHost = "Admin";
        LocalDate date = LocalDate.parse("2030-04-18");
        LocalTime time = LocalTime.parse("00:00");
        String description = "";
        String game = "Valorant";
        String platform = "PC";
        String tournamentType = "Brackets";
        int numberOfTeams = 4;
        int prizePool = 0;
        String prizePoolCurrency = "null";
        int entranceFee = 0;
        String entranceFeeCurrency = "null";

        TournamentWriter.writeNewTournamentToFileWithBasicInfo(status, tournamentName, tournamentHost,
                date, time, description, game, platform, tournamentType, numberOfTeams,
                prizePool, prizePoolCurrency, entranceFee, entranceFeeCurrency);
    }

    @Test
    void testThatEveryWriteTournamentToOverviewFileRun(){

        String fileNameOngoing = "testFileOngoing";
        String fileNameUpcoming = "testFileUpcoming";
        String fileNamePrevious = "testFilePrevious";
        try {
            TournamentWriter.writeTournamentToOngoingOverview(fileNameOngoing);
            TournamentWriter.writeTournamentToUpcomingOverview(fileNameUpcoming);
            TournamentWriter.writeTournamentToPreviousOverview(fileNamePrevious);
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    @Test
    void testThatUpdateTournamentFileLocationRuns() throws IOException{

        TournamentWriter.updateTournamentFileLocation();

    }

    @Test
    void testThatWriteTeamsToTournamentRuns() throws IOException{
        ArrayList<Team> teams = new ArrayList<>();
        Team team1 = TeamReader.findAndReturnTeamUsingTeamName("FaZe");
        Team team2 = TeamReader.findAndReturnTeamUsingTeamName("Fnatic");
        Team team3 = TeamReader.findAndReturnTeamUsingTeamName("Phase");
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        TournamentWriter.writeTeamsToTournamentFile("Test4",teams);
    }

}