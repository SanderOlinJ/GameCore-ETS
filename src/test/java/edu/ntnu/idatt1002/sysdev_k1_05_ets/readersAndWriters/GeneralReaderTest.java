package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;



import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities.getPathToBracketImageFile;
import static edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities.Utilities.getPathToGameImageFile;
import static org.junit.jupiter.api.Assertions.*;


public class GeneralReaderTest {

    @Test
    void testThatReadFileRunsAndReturnsCorrectValue() throws IOException {
        ArrayList<String> games = GeneralReader
                .readFile(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/games.txt"));
        assertEquals(3 ,games.size());
    }

    @Test
    void testThatReadSpecificLineInFileRunsAndReturnsCorrectValue() throws IOException{
        String game = GeneralReader.readSpecificLineInFile(
                new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/games.txt"),3);
        assertEquals("League of Legends",game);
    }

    @Test
    void testThatIsGameInLibraryRunsAndReturnsCorrectValues() throws IOException{
        String gameInLibrary = "Valorant";
        String gameNotInLibrary = "Minecraft";

        assertTrue(GeneralReader.isGameInLibrary(gameInLibrary));
        assertFalse(GeneralReader.isGameInLibrary(gameNotInLibrary));
    }
}
