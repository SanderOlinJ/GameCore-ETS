package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TournamentWriterTest {

    @Test
    void testThatIfFileExistsAndFindLocationReturnsCorrectLocation() throws IOException{

        File file = new File("src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/tournamentFiles/ongoingTournaments/testFile1.txt");

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("yo");
        fileWriter.close();
        String fileName = "testFile1";
        String fileLocation = TournamentWriter.ifFileExistsAndFindLocation(fileName);

        file.delete();
        assertEquals("Ongoing",fileLocation);
    }

    @Test
    void testThatWriteNewTournamentToFileWithBasicInfoRuns() throws IOException{
        String status = "Not finished";
        String tournamentName = "testFile2";
        String tournamentHost = "Admin";
        LocalDate date = LocalDate.parse("2020-04-18");
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

        TournamentWriter.removeTournamentFromUpcomingOverview("testFile2");
        File file = new File("src/main/resources/" +
                "edu/ntnu/idatt1002/sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/testFile2.txt");
        ArrayList<String> listFromFile = GeneralReader.readFile(file);

        file.delete();
        assertEquals(12, listFromFile.size());
    }

    @Test
    void testThatEveryWriteTournamentToOverviewFileWritesToFiles() throws IOException{

        String fileNameOngoing = "testFileOngoing";
        String fileNameUpcoming = "testFileUpcoming";
        String fileNamePrevious = "testFilePrevious";

        TournamentWriter.writeTournamentToOngoingOverview(fileNameOngoing);
        TournamentWriter.writeTournamentToUpcomingOverview(fileNameUpcoming);
        TournamentWriter.writeTournamentToPreviousOverview(fileNamePrevious);

        File ongoingFile = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/ongoingTournaments/ongoingTournaments.txt");
        File upcomingFile = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/upcomingTournaments/upcomingTournaments.txt");
        File previousFile = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/previousTournaments/previousTournaments.txt");

        ArrayList<String> ongoingTournaments = GeneralReader.readFile(ongoingFile);
        ArrayList<String> upcomingTournament = GeneralReader.readFile(upcomingFile);
        ArrayList<String> previousTournament = GeneralReader.readFile(previousFile);

        boolean tournamentNamesInOverviewFiles = false;
        for (String str1 : ongoingTournaments){
            if (str1.equals(fileNameOngoing)){
                for (String str2 : upcomingTournament){
                    if (str2.equals(fileNameUpcoming)){
                        for (String str3 : previousTournament){
                            if (str3.equals(fileNamePrevious)){
                                tournamentNamesInOverviewFiles = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        TournamentWriter.removeTournamentFromOngoingOverview(fileNameOngoing);
        TournamentWriter.removeTournamentFromUpcomingOverview(fileNameUpcoming);
        TournamentWriter.removeTournamentFromPreviousOverview(fileNamePrevious);

        assertTrue(tournamentNamesInOverviewFiles);
    }

    @Test
    void testThatUpdateTournamentFileLocationRuns() throws IOException{

        TournamentWriter.updateTournamentFileLocation();

    }

    @Test
    void testThatWriteTeamsToTournamentRuns() throws IOException{
        ArrayList<Team> teams = new ArrayList<>();
        String status = "Not finished";
        String tournamentName = "testFile3";
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
        Team team1 = TeamReader.findAndReturnTeamUsingTeamName("FaZe");
        Team team2 = TeamReader.findAndReturnTeamUsingTeamName("Fnatic");
        Team team3 = TeamReader.findAndReturnTeamUsingTeamName("Phase");
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        File testFile = new File("src/main/resources/edu/ntnu/" +
                "idatt1002/sysdev_k1_05_ets/tournamentFiles/upcomingTournaments/testFile3.txt");
        TournamentWriter.writeTeamsToTournamentFile("testFile3",teams);
        ArrayList<String> tournamentRead = GeneralReader.readFile(testFile);

        testFile.delete();

        TournamentWriter.removeTournamentFromUpcomingOverview("testFile3");

        assertEquals(tournamentRead.size(),13);
    }

}