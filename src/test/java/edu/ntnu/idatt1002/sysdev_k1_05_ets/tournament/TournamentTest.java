package edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    @Test
    void teamsIsNullInConstructor(){
        ArrayList<Team> teams = new ArrayList<>();
        try{
            Tournament tournament = new Tournament("Upcoming", "MadTournament",
                    "Admin",  LocalDate.parse("2022-04-25"),  LocalTime.parse("16:15:12"),
                    "A bloody insane tournament", "Fortnite", "PS5", "Brackets",
                    4, 10000, "NOK", 0,
                    "NOK", teams);
        }catch(IllegalArgumentException e){
            assertEquals("Teams cannot be empty!", e.getMessage());
        }

    }

    @Test
    void findNextMatchToBePlayedTest(){
        Team team1 = new Team("team1");
        Team team2 = new Team("Team2");
        Team team3 = new Team("Team3");
        Team team4 = new Team("Team4");

        ArrayList<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        ArrayList<Match> matches = new ArrayList<>();
        Match match1 = new Match(team1, team2);
        Match match2 = new Match(team3, team4);
        matches.add(match1);
        matches.add(match2);
        Tournament tournament = new Tournament("Upcoming", "MadTournament",
                    "Admin",  LocalDate.parse("2022-04-25"),  LocalTime.parse("16:15:12"),
                    "A bloody insane tournament", "Fortnite", "PS5", "Brackets",
                     4, 10000, "NOK", 0,
                    "NOK", teams);
        for(Match match : matches){
            match.setFinished(false);
            match.setTimeOfMatch(LocalTime.parse("00:00:00"));
        }

        tournament.setMatches(matches);
        assertEquals(match1, tournament.findNextMatchToBePlayed());
    }

    @Test
    void findNumberOfTeamsLeftTest(){
        Team team1 = new Team("team1");
        Team team2 = new Team("Team2");
        Team team3 = new Team("Team3");
        Team team4 = new Team("Team4");

        ArrayList<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        ArrayList<Match> matches = new ArrayList<>();
        Match match1 = new Match(team1, team2);
        Match match2 = new Match(team3, team4);
        matches.add(match1);
        matches.add(match2);
        Tournament tournament = new Tournament("Upcoming", "MadTournament",
                "Admin",  LocalDate.parse("2022-04-25"),  LocalTime.parse("16:15:12"),
                "A bloody insane tournament", "Fortnite", "PS5", "Brackets",
                 4, 10000, "NOK", 0,
                "NOK", teams);
        for(Match match : matches){
            match.setFinished(false);
            match.setTimeOfMatch(LocalTime.parse("00:00:00"));
        }

        match1.setFinished(true);

        tournament.setMatches(matches);
        assertEquals(3, tournament.findNumberOfTeamsLeft());
    }
}