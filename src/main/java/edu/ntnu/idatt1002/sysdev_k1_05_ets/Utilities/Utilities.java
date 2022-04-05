package edu.ntnu.idatt1002.sysdev_k1_05_ets.Utilities;

public class Utilities {

    public static String shortenAndReplaceUnnecessarySymbolsInString(String str){
        str = str.replaceAll("\\s","");
        str = str.replaceAll(":","");
        str = str.replaceAll("-","");
        return str;
    }
}
