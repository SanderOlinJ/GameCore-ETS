package edu.ntnu.idatt1002.sysdev_k1_05_ets;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.team_file_managers.TeamReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TeamReaderTest {
    @Test
    public void readTeam() throws IOException {
        TeamReader TR = new TeamReader();
        System.out.println(TR.convertTournamentFileToText("8_team_file"));
    }

}
