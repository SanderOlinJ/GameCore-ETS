package edu.ntnu.idatt1002.sysdev_k1_05_ets.Tournament;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;
import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    @Test
    void getVictorTest(){
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Match match = new Match(team1, team2);

        match.setMatchScoreTeam1(1);
        match.setMatchScoreTeam2(2);

        assertEquals(team2, match.getVictor());
    }

    @Test
    void getTimeOfMatchTest(){
        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Match match = new Match(team1, team2);

        match.setTimeOfMatch(LocalTime.parse("00:00:00"));

        assertEquals(LocalTime.parse("00:00:00"), match.getTimeOfMatch());
    }
}