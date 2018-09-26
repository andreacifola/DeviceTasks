package DeviceTasks.generator;


import DeviceTasks.entities.LightTask;
import DeviceTasks.entities.Type;
import DeviceTasks.utils.RandomNumberGenerator;
import DeviceTasks.utils.RandomStringSelector;

public class LightTaskGenerator {

    public LightTask spawnLightTask(int id) {

        String word = new RandomStringSelector().selectRandomString();

        LightTask task = new LightTask(word);
        task.setID(id);
        task.setType(Type.LIGHT);
        task.setConsumption(new RandomNumberGenerator().generateRandom(1, 7));
        return task;
    }
}
