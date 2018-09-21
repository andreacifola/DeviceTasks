package DeviceTasks.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;


public class RandomStringSelector {

    public String selectRandomString(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(new File("src/main/java/DeviceTasks/words.txt").getAbsoluteFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        assert lines != null;
        return lines.get(rand.nextInt(lines.size()));
    }
}
