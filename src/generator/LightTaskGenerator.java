package generator;

import entities.LightTask;
import entities.Task;
import entities.Type;
import utils.RandomStringSelector;

public class LightTaskGenerator {

    public Task spawnLightTask(int id) {

        String word = new RandomStringSelector().selectRandomString();

        Task task = new LightTask(word);
        task.setType(Type.LIGHT);
        task.setID(id);
        return task;
    }
}
