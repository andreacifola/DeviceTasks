package DeviceTasks.generator;

import DeviceTasks.entities.MediumTask;
import DeviceTasks.entities.Task;
import DeviceTasks.entities.Type;
import DeviceTasks.utils.RandomNumberGenerator;

public class MediumTaskGenerator {

    public Task spawnMediumTask(int id) {
        Task task = new MediumTask();

        int randNum = new RandomNumberGenerator().Generate5Digits();
        ((MediumTask) task).setNumber(randNum); //setto il numero da trovare con un numero randomico
        task.setID(id);
        task.setType(Type.MEDIUM);
        task.setConsumption(new RandomNumberGenerator().generateRandom(8, 20));
        task.setLatitude(new RandomNumberGenerator().generateRandom(41.5, 42.5));
        task.setLongitude(new RandomNumberGenerator().generateRandom(12.6, 13.6));
        return task;
    }
}
