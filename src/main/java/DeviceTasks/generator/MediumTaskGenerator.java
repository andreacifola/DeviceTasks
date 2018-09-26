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
        task.setID(id);
        task.setType(Type.MEDIUM);
        task.setConsumption(new RandomNumberGenerator().generateRandom(8, 20));
        return task;
    }
}
