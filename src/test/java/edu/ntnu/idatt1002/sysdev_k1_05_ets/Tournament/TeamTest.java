package edu.ntnu.idatt1002.sysdev_k1_05_ets.Tournament;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void initializeTeamWithoutMembersThreeParamaters(){
        try{
            ArrayList<String> members = new ArrayList<>();
            Team team = new Team(members, "CG", "CoolGuys");
        }catch (IllegalArgumentException e){
            assertEquals("Team members are required", e.getMessage());
        }
    }

    @Test
    void initializeTeamWithoutTeamAbbreviationTwoParamaters(){
        try{
            Team team = new Team("CoolGuys", "");
        }catch (IllegalArgumentException e){
            assertEquals("Team name abbreviation is required", e.getMessage());
        }
    }

    @Test
    void initializeTeamWithoutTeamNameOneParameters(){
        try{
            Team team = new Team("");
        }catch (IllegalArgumentException e){
            assertEquals("Team name is required!", e.getMessage());
        }
    }

    @Test
    void getNameOfTeam(){
        ArrayList<String> members = new ArrayList<>();
        members.add("Nutperson");

        Team team = new Team(members, "Nutpeople", "NP");

        assertEquals("Nutpeople", team.getNameOfTeam());
    }
}