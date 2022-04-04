package edu.ntnu.idatt1002.sysdev_k1_05_ets.ReadersAndWriters;

import edu.ntnu.idatt1002.sysdev_k1_05_ets.tournament.Team;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameReader {

    private final String DELIMITER = "\n";

    public static ArrayList<String> readFile(File file) throws IOException{
        ArrayList<String> returnList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)){
            if (!scanner.hasNext()){
                throw new IOException("File is empty");
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                returnList.add(line);
            }
        }
        return returnList;
    }
}
