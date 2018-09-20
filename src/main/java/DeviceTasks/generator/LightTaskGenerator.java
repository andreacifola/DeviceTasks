package DeviceTasks.generator;


import DeviceTasks.entities.LightTask;
import DeviceTasks.entities.Type;
import DeviceTasks.utils.RandomStringSelector;

public class LightTaskGenerator {

    public LightTask spawnLightTask(int id) {

        String word = new RandomStringSelector().selectRandomString();

        LightTask task = new LightTask(word);
        task.setType(Type.LIGHT);
        task.setID(id);
        return task;
    }
}
