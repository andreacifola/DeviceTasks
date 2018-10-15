package DeviceTasks.solver;

import DeviceTasks.entities.LightTask;

import java.io.IOException;

public class LightTaskSolver {

    public String CaesarCode(LightTask lightTask) throws IOException {
        String encrypted = "";
        String toEncrypt = lightTask.getToEncrypt();
        for (int i = 0; i < toEncrypt.length(); i++) {
            char letter = toEncrypt.charAt(i);
            if (Character.isLetter(letter)) {
                letter += 3;
                encrypted += letter;
            }
        }
        return encrypted;
    }

}
