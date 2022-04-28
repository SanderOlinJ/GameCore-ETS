package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class TeamReaderTest {


    @Test
    void testReadTeamsFromAllTeamsFileRunsAndReturnsCorrectAmountOfTeams() throws IOException{

        ArrayList<Team> allTeams = TeamReader.readTeamsFromAllTeamsFile();

        assertEquals(25, allTeams.size());
    }

    @Test
    void testThatFindAndReturnTeamUsingTeamNameReturnsCorrectTeamWithCorrectValues() throws IOException{
        ArrayList<String> members = new ArrayList<>();
        members.add("rain");
        members.add("broky");
        members.add("Twistzz");
        members.add("karrigan");
        members.add("ropz");

        Team team = new Team("FaZe","FaZe");
        team.setMembers(members);

        Team teamFromFile = TeamReader.findAndReturnTeamUsingTeamName("FaZe");

        assertEquals(team, teamFromFile);
    }

    @Test
    void testThatFindAndReturnTeamUsingTeamNameThrowsExceptionIfTeamNotFound(){

        assertThrows(IOException.class, () -> TeamReader.findAndReturnTeamUsingTeamName("Non-existing team"));
    }

    @Test
    void testThatIsThereAlreadyATeamWithSameTeamNameMethodReturnsCorrectValue() throws IOException{

        Team team = new Team("FaZe","FakeAb");
        assertTrue(TeamReader.isThereAlreadyATeamWithSameTeamName(team));

        Team completelyNewTeam = new Team("Not in file");
        assertFalse(TeamReader.isThereAlreadyATeamWithSameTeamName(completelyNewTeam));
    }

    @Test
    void testThatIsThereAlreadyATeamWithSameTeamNameAbbreviationMethodReturnsCorrectValue() throws IOException{

        Team team = new Team("Non-existing team name","Fnatic");
        assertTrue(TeamReader.isThereAlreadyATeamWithSameTeamNameAbbreviation(team));

        Team completelyNewTeam = new Team("Random name", "Random");
        assertFalse(TeamReader.isThereAlreadyATeamWithSameTeamNameAbbreviation(completelyNewTeam));
    }

    @Test
    void testThatIsThereAlreadyATeamWithSameTeamMembersMethodReturnsCorrectValue() throws IOException{
        ArrayList<String> players = new ArrayList<>();
        players.add("Pr0nax");
        players.add("JW");
        players.add("Flusha");
        players.add("Olofmeister");
        players.add("Krimz");
        Team team = new Team(players,"RandomName","Random");
        assertTrue(TeamReader.isThereAlreadyATeamWithSameTeamMembers(team));

        players.remove("Flusha");
        assertFalse(TeamReader.isThereAlreadyATeamWithSameTeamMembers(team));
    }

    @Test
    void testThatWasThereChangesMadeToTeamMethodReturnsCorrectValues() throws IOException{

        Team teamFromFile = TeamReader.findAndReturnTeamUsingTeamName("Fnatic");
        teamFromFile.getMembers().remove(2);
        assertTrue(TeamReader.wasThereChangesMadeToTeam(teamFromFile));

        Team anotherTeamFromFile = TeamReader.findAndReturnTeamUsingTeamName("FaZe");
        assertFalse(TeamReader.wasThereChangesMadeToTeam(anotherTeamFromFile));
    }

    @Test
    void testThatIsThisANewTeamMethodReturnsTrueIfNewTeamContainsSomeMembersButNotAllFromPreviousTeam()
    throws IOException{
        ArrayList<String> players = new ArrayList<>();
        players.add("JW");
        players.add("Flusha");
        players.add("Olofmeister");
        players.add("Krimz");
        Team team = new Team(players,"RandomName","Random");

        assertTrue(TeamReader.isThisANewTeam(team));
    }

    @Test
    void testThatIsThisANewTeamMethodReturnsFalseIfNewTeamContainsDataThatAnotherTeamAlreadyPossess()
    throws IOException{
        ArrayList<String> players = new ArrayList<>();
        players.add("New Player 1");
        players.add("New Player 2");
        players.add("New Player 3");
        players.add("New Player 4");
        Team team = new Team(players,"RandomName","G2");

        assertFalse(TeamReader.isThisANewTeam(team));
    }

}
