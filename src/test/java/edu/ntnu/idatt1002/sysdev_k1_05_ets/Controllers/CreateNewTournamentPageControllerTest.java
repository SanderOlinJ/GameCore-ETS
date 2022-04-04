package edu.ntnu.idatt1002.sysdev_k1_05_ets.Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateNewTournamentPageControllerTest {

    @Test
    void testThatGetPathToImageFileReturnsExpectedResult(){
        String game = "Apex Legends";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/gameImages/ApexLegends.png" +
                "", CreateNewTournamentPageController.getPathToImageFile(game));

        String game2 = "Call of Duty: Modern Warfare 2";

        assertEquals("file:src/main/resources/edu/ntnu/idatt1002/" +
                "sysdev_k1_05_ets/Images/gameImages/CallofDutyModernWarfare2.png",
                CreateNewTournamentPageController.getPathToImageFile(game2));
    }

}