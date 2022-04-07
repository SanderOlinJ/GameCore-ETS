package edu.ntnu.idatt1002.sysdev_k1_05_ets.readersAndWriters;

import javafx.scene.control.Label;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TournamentWriter {
    private static final String NEWLINE = "\n";
    private static final String DELIMITER = ",";

    public TournamentWriter(){}

    public static void writeFile(ArrayList<Label> listOfTeams, String tournamentName, String file)throws IOException {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/edu/ntnu/idatt1002/sysdev_k1_05_ets/" +
                "tournamentFiles/" + file + ".csv",true)){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tournamentName).append(DELIMITER);
            try {
                for (Label label : listOfTeams){
                    stringBuilder.append(label.getText()).append(DELIMITER);
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.append(NEWLINE);
                fileWriter.write(stringBuilder.toString());
            }catch (IOException e){
                throw new IOException("Cannot write tournament to file" + e.getMessage());
            }
        }
    }
}
