package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Match;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatchReaderTest {

    @Test
    void testThatMatchReaderReadsAMatchWithoutTeams() throws IOException {
        ArrayList<String> matchesAsList = new ArrayList<>();
        String match = "1,false,?,?,?,?,?,?";
        matchesAsList.add(match);

        ArrayList<Match> matches = MatchReader.readMatchesFromArrayList(matchesAsList);
        assertNull(matches.get(0).getTeam1());
        assertNull(matches.get(0).getTeam2());
        assertNull(matches.get(0).getTimeOfMatch());
        assertEquals(0, matches.get(0).getMatchScoreTeam1());
        assertEquals(0, matches.get(0).getMatchScoreTeam2());
    }

    @Test
    void testThatMatchReaderReadsAMatchWithTeamsButNotTimeOrScore() throws IOException{
        ArrayList<String> matchesAsList = new ArrayList<>();
        String match = "2,false,Natus Vincere,G2 Esports,?,?,?,?";
        matchesAsList.add(match);

        ArrayList<Match> matches = MatchReader.readMatchesFromArrayList(matchesAsList);
        assertEquals("Natus Vincere",matches.get(0).getTeam1().getNameOfTeam());
        assertEquals("G2 Esports",matches.get(0).getTeam2().getNameOfTeam());
        assertNull(matches.get(0).getTimeOfMatch());
        assertEquals(0, matches.get(0).getMatchScoreTeam1());
        assertEquals(0, matches.get(0).getMatchScoreTeam2());
    }

    @Test
    void testThatMatchReaderReadsAMatchWithTeamsTimeButNoScore() throws IOException{
        ArrayList<String> matchesAsList = new ArrayList<>();
        String match = "3,false,ENCE,MOUZ,12:00,?,?,?";
        matchesAsList.add(match);

        ArrayList<Match> matches = MatchReader.readMatchesFromArrayList(matchesAsList);
        assertEquals("ENCE",matches.get(0).getTeam1().getNameOfTeam());
        assertEquals("MOUZ",matches.get(0).getTeam2().getNameOfTeam());
        assertEquals(LocalTime.parse("12:00"),matches.get(0).getTimeOfMatch());
        assertEquals(0, matches.get(0).getMatchScoreTeam1());
        assertEquals(0, matches.get(0).getMatchScoreTeam2());
    }

    @Test
    void testThatMatchReaderReadsAMatchWithTeamsTimeScoreAndVictor() throws IOException{
        ArrayList<String> matchesAsList = new ArrayList<>();
        String match = "4,true,Fnatic,FaZe,12:00,3,2,Fnatic";
        matchesAsList.add(match);

        ArrayList<Match> matches = MatchReader.readMatchesFromArrayList(matchesAsList);
        assertEquals("Fnatic",matches.get(0).getTeam1().getNameOfTeam());
        assertEquals("FaZe",matches.get(0).getTeam2().getNameOfTeam());
        assertEquals(LocalTime.parse("12:00"),matches.get(0).getTimeOfMatch());
        assertEquals(3, matches.get(0).getMatchScoreTeam1());
        assertEquals(2, matches.get(0).getMatchScoreTeam2());
        assertEquals("Fnatic",matches.get(0).getVictor().getNameOfTeam());
    }
}