package DeviceTasks;


import DeviceTasks.entities.HeavyTask;
import DeviceTasks.entities.LightTask;
import DeviceTasks.entities.MediumTask;
import DeviceTasks.entities.Task;
import DeviceTasks.generator.TaskGenerator;
import DeviceTasks.rest.RequestHandler;
import DeviceTasks.utils.JsonBuilder;
import DeviceTasks.utils.RandomNumberGenerator;

import java.util.ArrayList;


public class SpawnTask {

    private static int MIN_RAND = 0;
    private static int MAX_RAND = 2;

    public static void main(String[] args) throws Exception {

        int id=0;
        String payload;
        String requestUrl;
        String res;
        ArrayList<Task> taskList = new ArrayList<>();
        TaskGenerator taskGenerator = new TaskGenerator();
        JsonBuilder jsonBuilder = new JsonBuilder();
        RequestHandler requestHandler = new RequestHandler();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        System.out.println("Spawning Tasks...");

        while (true){
            int randNum = randomNumberGenerator.generateRandom(MIN_RAND,MAX_RAND);
            Task newTask = taskGenerator.generateTask(randNum,id);
            switch (randNum){
                case 0:
                    LightTask lightTask = (LightTask) newTask;
                    payload = jsonBuilder.LightTaskToJSON(lightTask);
                    requestUrl="http://localhost:8080/light";
                    LightTask respl = requestHandler.sendLightPostRequest(requestUrl, payload);
                    System.out.println("Risposta dal server : id "+respl.getID() + " tipo : "+respl.getType() + "encrypted : "+respl.getEncrypted() );
                    break;

                case 1:
                    MediumTask mediumTask = (MediumTask) newTask;
                    payload = jsonBuilder.MediumTaskToJSON(mediumTask);
                    requestUrl="http://localhost:8080/medium";
                    MediumTask respm = requestHandler.sendMediumPostRequest(requestUrl, payload);
                    System.out.println("Risposta dal server : id "+respm.getID() + " tipo : "+respm.getType()+" time : "+respm.getTime());
                    break;

                case 2:
                    HeavyTask heavyTask = (HeavyTask) newTask;
                    payload = jsonBuilder.HeavyTaskToJSON(heavyTask);
                    requestUrl="http://localhost:8080/heavy";
                    HeavyTask resph = requestHandler.sendHeavyPostRequest(requestUrl, payload);
                    System.out.println("Risposta dal server : id "+resph.getID() + " tipo : "+resph.getType()+" resp : "+resph.getResponse());
                    break;
            }

            taskList.add(newTask);
            ++id;
            Thread.sleep(randomNumberGenerator.generateRandom(1000,5000));
        }

    }

    private static void printTaskList(ArrayList<Task> list){
        for(int i=0;i<list.size();i++){
            System.out.println("Task n° "+list.get(i).getID() + ", type = "+ list.get(i).getType());
        }
    }

}
