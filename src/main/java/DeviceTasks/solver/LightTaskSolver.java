package DeviceTasks.solver;

import DeviceTasks.entities.LightTask;

import java.io.IOException;

public class LightTaskSolver {

    public String CaesarCode(LightTask lightTask) throws IOException {
        String toEncrypt = lightTask.getToEncrypt();
        String encrypted;
        int loopCount = lightTask.getLoopCount();

        if(loopCount == -1)
            encrypted = "";
        else
            encrypted = lightTask.getEncrypted();

        for (int i = loopCount+1; i < toEncrypt.length(); i++) {
            char letter = toEncrypt.charAt(i);

            if (Character.isLetter(letter)) {
                if(letter == 'x')
                    letter = 'a';
                else if(letter == 'y')
                    letter = 'b';
                else if(letter == 'z')
                    letter = 'c';
                else
                    letter += 3;
                encrypted += letter;
            }
        }
        return encrypted;
    }
}
