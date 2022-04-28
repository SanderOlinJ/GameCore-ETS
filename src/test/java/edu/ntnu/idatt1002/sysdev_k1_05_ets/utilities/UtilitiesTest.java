package edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities;

import org.junit.jupiter.api.Test;

import static edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities.getPathToBracketImageFile;
import static edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities.getPathToGameImageFile;
import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void testThatShortenStringRunsAsIntended() {
        String random = "Test!?=]@[]123456789øæå-*/+-.,<>)(/&%¤#!@£$€{[]}";
        random = Utilities.shortenAndReplaceUnnecessarySymbolsInString(random);
        System.out.println(random);
    }

    @Test
    void testThatGetPathToGameImageFileReturnsExpectedResult(){
        String game = "Valorant";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/images/gameImages/Valorant.png" +
                "", getPathToGameImageFile(game));

        String game2 = "Counter-Strike: Global Offensive";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/" +
                        "sysdev_k1_05_ets/images/gameImages/CounterStrikeGlobalOffensive.png",
                getPathToGameImageFile(game2));
    }

    @Test
    void testThatGetPathToBracketImageFileReturnsExpectedResult(){
        String bracketFormat = "Eight_Team_Bracket";
        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/images/" +
                        "bracketFormats/8.png",
                getPathToBracketImageFile(bracketFormat));
    }

}