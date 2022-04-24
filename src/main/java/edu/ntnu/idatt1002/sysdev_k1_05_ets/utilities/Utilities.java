package edu.ntnu.idatt1002.sysdev_k1_05_ets.utilities;

import java.io.File;

public class Utilities {

    public static String shortenAndReplaceUnnecessarySymbolsInString(String str){
        return str.replaceAll("[^A-Za-z0-9]","");
    }

    public static int getNextPowerOf2(int value){
        int highestOneBit = Integer.highestOneBit(value);
        if (value == highestOneBit) {
            return value;
        }
        return highestOneBit << 1;
    }

    public static String getPathToGameImageFile(String gameAsString){
        gameAsString = shortenAndReplaceUnnecessarySymbolsInString(gameAsString);
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/gameImages/%s",
                gameAsString) + ".png";
    }

    public static String getPathToBracketImageFile(String bracketFormatAsString){
        return String.format("file:src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/Images/bracketFormats/%s",
                bracketFormatAsString) + ".png";
    }

}
