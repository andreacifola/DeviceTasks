package DeviceTasks.generator;


import DeviceTasks.entities.MediumTask;
import DeviceTasks.entities.Task;
import DeviceTasks.entities.Type;
import DeviceTasks.utils.RandomNumberGenerator;

public class MediumTaskGenerator {

    public Task spawnMediumTask(int id) {
        Task task = new MediumTask();
        int randNum = new RandomNumberGenerator().Generate5Digits();
        ((MediumTask) task).setNumber(randNum);
        task.setType(Type.MEDIUM);
        task.setID(id);
        return task;
    }
}
