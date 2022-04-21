package edu.ntnu.idatt1002.sysdev_k1_05_ets.Tournament;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Round;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    @Test
    void getScoreTeam1Test(){
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Round round = new Round(team1, team2, 5, 2);

        assertEquals(round.getScoreTeam1(), 5);
    }
    @Test
    void getScoreTeam2Test(){
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Round round = new Round(team1, team2, 5, 2);

        assertEquals(round.getScoreTeam2(), 2);
    }
}