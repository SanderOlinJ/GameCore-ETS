package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TeamWriterTest {


    @Test
    public void writeFileRun() throws IOException {

        ArrayList<String> members = new ArrayList<>(Arrays.asList("a","a","a"));
        Team team1 = new Team(members, "team1","t1");


        TeamWriter.writeTeamsToFileAndOverwriteIfChanges(team1);
    }
}
