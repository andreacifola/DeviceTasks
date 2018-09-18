package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

/**
 * Created by andreacifola on 18/09/2018.
 */
public class RandomStringSelector {

    public String selectRandomString(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(new File("/Users/andreacifola/Desktop/Sistemi Distribuiti e Cloud Computing/DeviceTasks/words.txt").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        return lines.get(rand.nextInt(lines.size()));
    }
}
