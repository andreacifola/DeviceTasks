package DeviceTasks.generator;


import DeviceTasks.entities.Task;

public class TaskGenerator {

    public Task generateTask(int i, int id){

        switch (i){
            case 0:
                //GENERATE LIGHT TASK
                return new LightTaskGenerator().spawnLightTask(id);
            case 1:
                //GENERATE MEDIUM TASK
                return new MediumTaskGenerator().spawnMediumTask(id);
            case 2:
                //GENERATE HEAVY TASK
                return new HeavyTaskGenerator().spawnHeavyTask(id);
        }
        return null;
    }
}