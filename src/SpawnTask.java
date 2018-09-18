import entities.LightTask;
import entities.Task;
import generator.TaskGenerator;
import rest.RequestHandler;
import utils.JsonBuilder;
import utils.RandomNumberGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class SpawnTask {

    private static int MIN_RAND = 0;
    private static int MAX_RAND = 2;

    public static void main(String[] args) throws InterruptedException,Exception {

        int id=0;
        ArrayList<Task> taskList = new ArrayList<>();
        TaskGenerator taskGenerator = new TaskGenerator();
        JsonBuilder jsonBuilder = new JsonBuilder();
        RequestHandler requestHandler = new RequestHandler();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        System.out.println("Spawning Tasks...");

        /*
        while (true){
            int randNum = randomNumberGenerator.generateRandom(MIN_RAND,MAX_RAND);
            Task newTask = taskGenerator.generateTask(randNum,id);
            taskList.add(newTask);
            ++id;
            System.out.println("Task n° "+newTask.getID() + ", type = "+ newTask.getType());
            Thread.sleep(randomNumberGenerator.generateRandom(1000,5000));
        }*/

        LightTask newTask = (LightTask) taskGenerator.generateTask(0,id);

        String payload = jsonBuilder.LightTaskToJSON(newTask);
        String requestUrl="http://localhost:8080/light";
        String res = requestHandler.sendPostRequest(requestUrl, payload);
        System.out.println(res);


    }

    private static void printTaskList(ArrayList<Task> list){
        for(int i=0;i<list.size();i++){
            System.out.println("Task n° "+list.get(i).getID() + ", type = "+ list.get(i).getType());
        }
    }

}
