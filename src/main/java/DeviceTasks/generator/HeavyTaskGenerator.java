package DeviceTasks.generator;


import DeviceTasks.entities.HeavyTask;
import DeviceTasks.entities.Task;
import DeviceTasks.entities.Type;
import DeviceTasks.utils.RandomNumberGenerator;

public class HeavyTaskGenerator {

    public Task spawnHeavyTask(int id) {

        Task task = new HeavyTask();
        task.setID(id);
        task.setType(Type.HEAVY);
        task.setConsumption(new RandomNumberGenerator().generateRandom(21, 30));
        return task;
    }
}
