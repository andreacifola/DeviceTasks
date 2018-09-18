package generator;

import entities.HeavyTask;
import entities.Task;
import entities.Type;

public class HeavyTaskGenerator {

    public Task spawnHeavyTask(int id) {

        Task task = new HeavyTask();
        task.setType(Type.HEAVY);
        task.setID(id);
        return task;
    }
}
