package generator;

import entities.LightTask;
import entities.Task;
import entities.Type;
import utils.RandomStringSelector;

/**
 * Created by andreacifola on 18/09/2018.
 */
public class LightTaskGenerator {

    public LightTask spawnLightTask(int id) {

        String word = new RandomStringSelector().selectRandomString();

        LightTask task = new LightTask(word);
        task.setType(Type.LIGHT);
        task.setID(id);
        return task;
    }
}
