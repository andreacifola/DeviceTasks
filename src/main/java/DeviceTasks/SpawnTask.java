package DeviceTasks;

import DeviceTasks.entities.*;
import DeviceTasks.generator.TaskGenerator;
import DeviceTasks.handler.DeviceHandler;
import DeviceTasks.powersaving.ExecutionTimePredictor;
import DeviceTasks.powersaving.OffloadDecisor;
import DeviceTasks.rest.RequestHandler;
import DeviceTasks.solver.HeavyTaskSolver;
import DeviceTasks.solver.LightTaskSolver;
import DeviceTasks.solver.MediumTaskSolver;
import DeviceTasks.utils.JsonBuilder;
import DeviceTasks.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Objects;

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
        OffloadDecisor offloadDecisor = new OffloadDecisor();

        System.out.println("Spawning Tasks...");

        while (true){

            //Check the execution mode
            int executionMode = DeviceHandler.getInstance().getExecutionMode();
            int randNum = randomNumberGenerator.generateRandom(MIN_RAND,MAX_RAND);
            Task newTask = taskGenerator.generateTask(randNum,id);
            boolean offload = false;

            switch (randNum){
                case 0:
                    LightTask lightTask = (LightTask) newTask;

                    if (executionMode==0){
                        offload = offloadDecisor.sendTaskToCloud(0);
                    }else if (executionMode == 1){
                        offload = true;
                    }
                    if (offload){
                        //send to cloud
                        long start_time = System.nanoTime();

                        payload = jsonBuilder.LightTaskToJSON(lightTask);
                        requestUrl="http://localhost:8080/light/register";
                        int i = requestHandler.registerTask(requestUrl,lightTask,payload);
                        //System.out.println("Valore di ritorno : "+i);
                        requestUrl="http://localhost:8080/light/"+i;
                        res = requestHandler.sendGetRequest(requestUrl);

                        long end_time = System.nanoTime(); //TEST ONLY
                        long exec_time = end_time - start_time; //TEST ONLY
                        double exec_time_seconds = (double)exec_time/ 1_000_000_000.0; //TEST ONLY
                        System.out.println("Real exec time = "+exec_time_seconds*0.5); //TEST ONLY
                        ExecutionTimePredictor.getInstance().addLightCloudExecTime(exec_time_seconds*0.5);
                        LightTask result = (LightTask) requestHandler.mapJSONToTask(res,Type.LIGHT);
                        String canto = result.getEncrypted();
                        canto = canto.replace("aa", "\n");
                        result.setEncrypted(canto);
                        //System.out.println("Risposta dal server : "+result.getID()+" encrypted : "+result.getEncrypted());
                    }else {
                        //Execute task on device
                        System.out.println("Esecuzione del task in locale");
                        LightTaskSolver lightTaskSolver = new LightTaskSolver();
                        //Calculate Local execution time
                        long start_time = System.nanoTime();
                        String cesar = lightTaskSolver.CaesarCode(lightTask);
                        long end_time = System.nanoTime();
                        long exec_time = end_time - start_time;
                        double exec_time_seconds = (double)exec_time/ 1_000_000_000.0;
                        ExecutionTimePredictor.getInstance().addLightExecTime(exec_time_seconds);
                        lightTask.setEncrypted(cesar);
                    }
                    payload = jsonBuilder.LightTaskToJSON(lightTask);
                    requestUrl="http://localhost:8080/light/register";
                    int i = requestHandler.registerTask(requestUrl,lightTask,payload);
                    //System.out.println("Valore di ritorno : "+i);

                    if (i != -100) {
                        requestUrl = "http://localhost:8080/light/" + i;
                        res = requestHandler.sendGetRequest(requestUrl);
                        LightTask result = (LightTask) requestHandler.mapJSONToTask(res, Type.LIGHT);

                        String canto = result.getEncrypted();
                        canto = canto.replace("aa", "\n");
                        result.setEncrypted(canto);
                        System.out.println("Risposta dal server : " + result.getID() + " encrypted : " + result.getEncrypted());
                        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("\nIL MIDDLEWARE NON È PIÙ DISPONIBILE");
                        return;
                    }
                    break;

                case 1:
                    MediumTask mediumTask = (MediumTask) newTask;

                    if (executionMode==0){
                        offload = offloadDecisor.sendTaskToCloud(1);
                    }else if (executionMode == 1){
                        offload = true;
                    }

                    if (offload){
                        //Send to cloud
                        payload = jsonBuilder.MediumTaskToJSON(mediumTask);
                        requestUrl="http://localhost:8080/medium/register";
                        int j = requestHandler.registerTask(requestUrl,mediumTask,payload);

                        requestUrl="http://localhost:8080/medium/"+j;

                        long start_time = System.nanoTime(); //TEST ONLY
                        res = requestHandler.sendGetRequest(requestUrl);
                        long end_time = System.nanoTime(); //TEST ONLY
                        long exec_time = end_time - start_time; //TEST ONLY
                        double exec_time_seconds = (double)exec_time/ 1_000_000_000.0; //TEST ONLY
                        System.out.println("Real exec time = "+(exec_time_seconds*0.5)); //TEST ONLY
                        ExecutionTimePredictor.getInstance().addMediumCloudExecTime(exec_time_seconds*0.5);
                        MediumTask result1 = (MediumTask) requestHandler.mapJSONToTask(res,Type.MEDIUM);
                        System.out.println("Risposta dal server : "+result1.getID()+" time : "+result1.getTime());
                    }else {
                        //Execute task on device
                        System.out.println("Esecuzione del task in locale");
                        MediumTaskSolver mediumTaskSolver = new MediumTaskSolver();
                        long start_time = System.nanoTime();
                        Long count_res = mediumTaskSolver.count(mediumTask);
                        long end_time = System.nanoTime();
                        long exec_time = end_time - start_time;
                        double exec_time_seconds = (double)exec_time/ 1_000_000_000.0;
                        ExecutionTimePredictor.getInstance().addMediumExecTime(exec_time_seconds);
                    }
                    payload = jsonBuilder.MediumTaskToJSON(mediumTask);
                    requestUrl="http://localhost:8080/medium/register";
                    int j = requestHandler.registerTask(requestUrl,mediumTask,payload);
                    //System.out.println("Valore di ritorno : "+j);
                    if (j != -100) {
                        requestUrl = "http://localhost:8080/medium/" + j;
                        res = requestHandler.sendGetRequest(requestUrl);
                        MediumTask result1 = (MediumTask) requestHandler.mapJSONToTask(res, Type.MEDIUM);
                        System.out.println("Risposta dal server : " + result1.getID() + " time : " + result1.getTime());
                        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("\nIL MIDDLEWARE NON È PIÙ DISPONIBILE");
                        return;
                    }
                    break;
                case 2:
                    HeavyTask heavyTask = (HeavyTask) newTask;
                    if (executionMode==0){
                        offload = offloadDecisor.sendTaskToCloud(2);
                    }else if (executionMode == 1) {
                        offload = true;
                    }
                    if (offload){
                        //SEND TO CLOUD

                        payload = jsonBuilder.HeavyTaskToJSON(heavyTask);
                        requestUrl="http://localhost:8080/heavy/register";
                        int k = requestHandler.registerTask(requestUrl,heavyTask,payload);
                        requestUrl="http://localhost:8080/heavy/"+k;
                        long start_time = System.nanoTime(); //TEST ONLY
                        res = requestHandler.sendGetRequest(requestUrl);
                        long end_time = System.nanoTime(); //TEST ONLY
                        long exec_time = end_time - start_time; //TEST ONLY
                        double exec_time_seconds = (double)exec_time/ 1_000_000_000.0; //TEST ONLY
                        System.out.println("Real exec time = "+exec_time_seconds*0.5); //TEST ONLY
                        ExecutionTimePredictor.getInstance().addHeavyCloudExecTime(exec_time_seconds*0.5);
                        HeavyTask result2 = (HeavyTask) requestHandler.mapJSONToTask(res,Type.HEAVY);
                        System.out.println("Risposta dal server : " + result2.getID() + " response : "
                                + result2.getResponse());
                    }else {
                        System.out.println("Esecuzione del task in locale");
                        HeavyTaskSolver heavyTaskSolver = new HeavyTaskSolver();
                        long start_time = System.nanoTime();
                        heavyTaskSolver.factorial(heavyTask);
                        long end_time = System.nanoTime();
                        long exec_time = end_time - start_time;
                        double exec_time_seconds = (double)exec_time/ 1_000_000_000.0;
                        ExecutionTimePredictor.getInstance().addHeavyExecTime(exec_time_seconds);
                    }
                    payload = jsonBuilder.HeavyTaskToJSON(heavyTask);
                    requestUrl="http://localhost:8080/heavy/register";
                    int k = requestHandler.registerTask(requestUrl,heavyTask,payload);
                    //System.out.println("Valore di ritorno : "+k);

                    if (k != -100) {
                        requestUrl = "http://localhost:8080/heavy/" + k;
                        res = requestHandler.sendGetRequest(requestUrl);
                        HeavyTask result2 = (HeavyTask) requestHandler.mapJSONToTask(res, Type.HEAVY);
                        System.out.println("Risposta dal server : " + result2.getID() + " response : "
                                + result2.getResponse());
                        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("\nIL MIDDLEWARE NON È PIÙ DISPONIBILE");
                        return;
                    }
                    break;
            }
            taskList.add(newTask);
            ++id;
            Thread.sleep(randomNumberGenerator.generateRandom(1000,5000));
        }
    }

}
