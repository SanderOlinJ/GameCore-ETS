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
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            lineNumber = Math.abs(lineNumber)-1;
            String line;
            for(int i = 0; i< lineNumber; i++){
                bufferedReader.readLine();
            }
            line = bufferedReader.readLine();
            return line;
        }
        catch (IOException exception){
            throw new IOException("Could not read through file: " + exception.getMessage());
        }
    }

    public static boolean isGameInLibrary(String gameName)
    throws IOException{
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/games.txt");
        ArrayList<String> games = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                games.add(scanner.nextLine());
            }
            for (String game : games){
                if (game.equals(gameName)){
                    return true;
                }
            }
            return false;
        } catch (IOException exception){
            throw new IOException("Could not read through game file: " + exception.getMessage());
        }
    }

    public static boolean isPlatformInLibrary(String platformName)
    throws IOException{
        File file = new File("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/platforms.txt");
        ArrayList<String> platforms = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                platforms.add(scanner.nextLine());
            }
            for (String platform : platforms){
                if (platform.equals(platformName)){
                    return true;
                }
            }
            return false;
        } catch (IOException exception){
            throw new IOException("Could not read through platform file: " + exception.getMessage());
        }
    }
}
