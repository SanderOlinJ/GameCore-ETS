package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;



import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class GameReaderTest {

    @Test
    void testOne() throws IOException {
        ArrayList<String> games = new ArrayList<>();
        games = GameReader.readFile(new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/gameFiles/games.txt"));
        assertEquals(25 ,games.size());
    }
}
