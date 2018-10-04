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

    public String selectCantoRandom() {
        DivineComedy divineComedy = new DivineComedy();
        Random random = new Random();
        String canto="";

        int Low = 1;
        int High = 6;

        //sceglie un numero random tra 1 e 5
        int randomCanto = random.nextInt(High - Low) + Low;
        if (randomCanto == 1)
            canto = divineComedy.getCanto1();
        if (randomCanto == 2)
            canto = divineComedy.getCanto2();
        if (randomCanto == 3)
            canto = divineComedy.getCanto3();
        if (randomCanto == 4)
            canto = divineComedy.getCanto4();
        if (randomCanto == 5)
            canto = divineComedy.getCanto5();
        return canto;
    }
}
