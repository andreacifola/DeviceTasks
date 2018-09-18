package generator;

import entities.HeavyTask;
import entities.Task;
import entities.Type;

/**
 * Created by andreacifola on 18/09/2018.
 */
public class HeavyTaskGenerator {

    public Task spawnHeavyTask(int id) {

        Task task = new HeavyTask();
        task.setType(Type.HEAVY);
        task.setID(id);
        return task;
    }
}
