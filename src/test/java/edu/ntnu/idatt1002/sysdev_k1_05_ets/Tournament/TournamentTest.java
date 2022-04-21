package edu.ntnu.idatt1002.sysdev_k1_05_ets.Tournament;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Tournament;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {
    @Test
    void numberOfTeamsIsZeroInConstructor(){
        try{
            ArrayList<Team> teams = new ArrayList<Team>();

            Tournament tournament = new Tournament(teams, "Fuckboys", "CS", 0);
        }catch(IllegalArgumentException e){
            assertEquals("Minimum number of teams = 2", e.getMessage());
        }
    }

    @Test
    void getTeamByNameTest() {
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Tournament tournament = new Tournament("FightClub");

        tournament.addTeam(team1);
        tournament.addTeam(team2);

        assertEquals(team1, tournament.getTeamByName("Team1"));
    }

    @Test
    void getTeamByAbbrTest(){
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        team1.setNameAbbr("T1");
        team2.setNameAbbr("T2");

        Tournament tournament = new Tournament("Dankeygirls");

        tournament.addTeam(team1);
        tournament.addTeam(team2);

        assertEquals(team2, tournament.getTeamByAbbr("T2"));
    }
}