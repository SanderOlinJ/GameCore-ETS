package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TeamReaderTest {

    @Test
    void testThatIsThereAlreadyATeamWithSameTeamMembersRuns() throws IOException{
        ArrayList<String> players = new ArrayList<>();
        players.add("Pr0nax");
        players.add("JW");
        players.add("Flusha");
        players.add("Olofmeister");
        players.add("Krimz");
        Team team = new Team(players,"Bruh","br");

        System.out.println(TeamReader.isThereAlreadyATeamWithSameTeamMembers(team));
    }
}
