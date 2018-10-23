package DeviceTasks;

import DeviceTasks.entities.*;
import DeviceTasks.generator.TaskGenerator;
import DeviceTasks.handler.DeviceHandler;
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

            //controlla lo stato attuale della batteria e verifica se operare in power saving mode
            //Boolean powerSaving = DeviceHandler.getInstance().checkPowerSaving();
            int randNum = randomNumberGenerator.generateRandom(MIN_RAND,MAX_RAND);

            //Impongo un task specifico
            randNum = 1;

            Task newTask = taskGenerator.generateTask(randNum,id);

            //TEST
            randNum = 0;

            switch (randNum){
                case 0:
                    LightTask lightTask = (LightTask) newTask;
                    payload = jsonBuilder.LightTaskToJSON(lightTask);
                    //if power saving mode decide if using middleware or local computation

                    requestUrl="http://localhost:8080/light/register";
                    int i = requestHandler.registerTask(requestUrl,lightTask,payload);
                    //System.out.println("Valore di ritorno : "+i);
                    requestUrl="http://localhost:8080/light/"+i;
                    res = requestHandler.sendGetRequest(requestUrl);
                    LightTask result = (LightTask) requestHandler.mapJSONToTask(res,Type.LIGHT);
                    System.out.println("Risposta dal server : "+result.getID()+" encrypted : "+result.getEncrypted());
                    break;

                case 1:
                    MediumTask mediumTask = (MediumTask) newTask;
                    payload = jsonBuilder.MediumTaskToJSON(mediumTask);
                    requestUrl="http://localhost:8080/medium/register";
                    int j = requestHandler.registerTask(requestUrl,mediumTask,payload);
                    //System.out.println("Valore di ritorno : "+j);
                    requestUrl="http://localhost:8080/medium/"+j;
                    res = requestHandler.sendGetRequest(requestUrl);
                    MediumTask result1 = (MediumTask) requestHandler.mapJSONToTask(res,Type.MEDIUM);
                    System.out.println("Risposta dal server : "+result1.getID()+" time : "+result1.getTime());
                    break;

                case 2:
                    HeavyTask heavyTask = (HeavyTask) newTask;
                    payload = jsonBuilder.HeavyTaskToJSON(heavyTask);
                    requestUrl="http://localhost:8080/heavy/register";
                    int k = requestHandler.registerTask(requestUrl,heavyTask,payload);
                    //System.out.println("Valore di ritorno : "+k);
                    requestUrl="http://localhost:8080/heavy/"+k;
                    res = requestHandler.sendGetRequest(requestUrl);
                    HeavyTask result2 = (HeavyTask) requestHandler.mapJSONToTask(res,Type.HEAVY);
                    System.out.println("Risposta dal server : " + result2.getID() + " response : " +
                            result2.getResponse());
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
