package edu.ntnu.idatt1002.sysdev_k1_05_ets.Controllers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateNewTournamentPageControllerTest {

    @Test
    void testThatGetPathToGameImageFileReturnsExpectedResult(){
        String game = "Valorant";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/gameImages/Valorant.png" +
                "", edu.ntnu.idatt1002.sysdev_k1_05_ets.Controllers.CreateNewTournamentPageController.getPathToGameImageFile(game));

        String game2 = "Counter-Strike: Global Offensive";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/Images/gameImages/CounterStrikeGlobalOffensive.png",
                edu.ntnu.idatt1002.sysdev_k1_05_ets.Controllers.CreateNewTournamentPageController.getPathToGameImageFile(game2));
    }

    @Test
    void testThatGetPathToBracketImageFileReturnsExpectedResult(){
        String bracketFormat = "8";
        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/bracketFormats/8.png",
                edu.ntnu.idatt1002.sysdev_k1_05_ets.Controllers.CreateNewTournamentPageController.getPathToBracketImageFile(bracketFormat));
    }
}