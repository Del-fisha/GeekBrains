package exam;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteData {
    public static void writeData(String data) {
        String fileName = data.split(" ")[0].toUpperCase() + ".txt";
        try {
            if (Files.exists(Paths.get(fileName))) Files.write(Paths.get(fileName), ("\n" + data).getBytes(),
                    StandardOpenOption.APPEND);
            else {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(data);
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
