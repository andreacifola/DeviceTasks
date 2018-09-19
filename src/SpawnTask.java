import entities.HeavyTask;
import entities.LightTask;
import entities.MediumTask;
import entities.Task;
import generator.TaskGenerator;
import rest.RequestHandler;
import utils.JsonBuilder;
import utils.RandomNumberGenerator;

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
                    res = requestHandler.sendPostRequest(requestUrl, payload);
                    System.out.println(res);
                    break;

                case 1:
                    MediumTask mediumTask = (MediumTask) newTask;
                    payload = jsonBuilder.MediumTaskToJSON(mediumTask);
                    requestUrl="http://localhost:8080/medium";
                    res = requestHandler.sendPostRequest(requestUrl, payload);
                    System.out.println(res);
                    break;

                case 2:
                    HeavyTask heavyTask = (HeavyTask) newTask;
                    payload = jsonBuilder.HeavyTaskToJSON(heavyTask);
                    requestUrl="http://localhost:8080/heavy";
                    res = requestHandler.sendPostRequest(requestUrl, payload);
                    System.out.println(res);
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
