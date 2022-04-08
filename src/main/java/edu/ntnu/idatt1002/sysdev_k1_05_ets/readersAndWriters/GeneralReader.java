package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneralReader {
    private final String DELIMITER = "\n";

    public static ArrayList<String> readFile(File file) throws IOException {
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

    public static String readSpecificLineInFile(File file, int lineNumber) throws IOException{
        lineNumber = Math.abs(lineNumber)-1;
        String line = null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            for(int i = 0; i< lineNumber; i++){
                bufferedReader.readLine();
            }
            line = bufferedReader.readLine();
            return line;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }
}
