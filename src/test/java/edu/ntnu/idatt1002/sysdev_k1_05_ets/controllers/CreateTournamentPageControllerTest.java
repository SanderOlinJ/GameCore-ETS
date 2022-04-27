package edu.ntnu.idatt1002.sysdev_k1_05_ets.controllers;


import static edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateTournamentPageControllerTest {

    @Test
    void testThatGetPathToGameImageFileReturnsExpectedResult(){
        String game = "Valorant";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/gameImages/Valorant.png" +
                "", getPathToGameImageFile(game));

        String game2 = "Counter-Strike: Global Offensive";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/Images/gameImages/CounterStrikeGlobalOffensive.png",
                getPathToGameImageFile(game2));
    }

    @Test
    void testThatGetPathToBracketImageFileReturnsExpectedResult(){
        String bracketFormat = "Eight_Team_Bracket";
        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/" +
                        "bracketFormats/Eight_Team_Bracket.png",
                getPathToBracketImageFile(bracketFormat));
    }
}