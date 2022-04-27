package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class used for general reading purposes
 */
public class GeneralReader {

    /**
     Method reads a file to list.
     * @param file file to be read to list
     * @return list of file contents
     * @throws IOException if file is empty
     */
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

    /**
     Method used for reading a specific line in a file
     * @param file file to be read
     * @param lineNumber at which line the method should read
     * @return the content at the line as a string
     * @throws IOException if file could not be read.
     */
    public static String readSpecificLineInFile(File file, int lineNumber) throws IOException{
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

            //Method first reads up to the last line before the line in interest
            lineNumber = Math.abs(lineNumber)-1;
            String line;
            for(int i = 0; i< lineNumber; i++){
                bufferedReader.readLine();
            }

            //Method then returns the line in interest
            line = bufferedReader.readLine();
            return line;
        }
        catch (IOException exception){
            throw new IOException("Could not read through file: " + exception.getMessage());
        }
    }

    /**
     Method reads through the games.txt file and checks if there is a game there corresponding to the input game name.
     * @param gameName name of the game
     * @return true if there is a game in the file with that name, false if not
     * @throws IOException if file could not be read.
     */
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

    /**
     Method reads through the platforms.txt file and checks if there is a platform
     there corresponding to the input platform name.
     * @param platformName name of the platform
     * @return true if there is a platform in the file with that name, false if not
     * @throws IOException if file could not be read.
     */
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
