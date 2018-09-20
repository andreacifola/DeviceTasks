package DeviceTasks.generator;


import DeviceTasks.entities.HeavyTask;
import DeviceTasks.entities.Task;
import DeviceTasks.entities.Type;

public class HeavyTaskGenerator {

    public Task spawnHeavyTask(int id) {

        Task task = new HeavyTask();
        task.setType(Type.HEAVY);
        task.setID(id);
        return task;
    }
}
