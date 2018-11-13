package DeviceTasks.generator;


import DeviceTasks.entities.HeavyTask;
import DeviceTasks.entities.Task;
import DeviceTasks.entities.Type;
import DeviceTasks.utils.RandomNumberGenerator;

import java.math.BigInteger;

public class HeavyTaskGenerator {

    public Task spawnHeavyTask(int id) {

        Task task = new HeavyTask();
        task.setID(id);
        task.setType(Type.HEAVY);
        ((HeavyTask) task).setN(200000);
        //((HeavyTask) task).setN(300000);
        task.setConsumption(new RandomNumberGenerator().generateRandom(21, 30));
        task.setLatitude(new RandomNumberGenerator().generateRandom(41.5, 42.5));
        task.setLongitude(new RandomNumberGenerator().generateRandom(12.6, 13.6));
        return task;
    }
}
