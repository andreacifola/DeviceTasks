package DeviceTasks.generator;


import DeviceTasks.entities.LightTask;
import DeviceTasks.entities.Type;
import DeviceTasks.utils.RandomNumberGenerator;
import DeviceTasks.utils.RandomStringSelector;

public class LightTaskGenerator {

    public LightTask spawnLightTask(int id) {

        //String word = new RandomStringSelector().selectRandomString();
        String canto = new RandomStringSelector().selectCantoRandom();

        //LightTask task = new LightTask(word);
        LightTask task = new LightTask(canto);

        task.setID(id);
        task.setType(Type.LIGHT);
        task.setConsumption(new RandomNumberGenerator().generateRandom(1, 7));
        task.setLatitude(new RandomNumberGenerator().generateRandom(41.5, 42.5));
        task.setLongitude(new RandomNumberGenerator().generateRandom(12.6, 13.6));
        return task;
    }
}
