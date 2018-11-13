package DeviceTasks.powersaving;

import DeviceTasks.database.DatabaseHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExecutionTimePredictor {

    private final String lightTaskDB = "lighttasktimes";
    private final String mediumtTaskDB = "mediumtasktimes";
    private final String heavyTaskDB = "heavytasktimes";

    private final String lightTaskDB_cloud = "lighttasktimes_cloud";
    private final String mediumtTaskDB_cloud = "mediumtasktimes_cloud";
    private final String heavyTaskDB_cloud = "heavytasktimes_cloud";

    private ArrayList<Double> lightExecTimes = new ArrayList<>();
    private ArrayList<Double> mediumExecTimes = new ArrayList<>();
    private ArrayList<Double> heavyExecTimes = new ArrayList<>();

    private ArrayList<Double> lightCloudExecTimes = new ArrayList<>();
    private ArrayList<Double> mediumCloudExecTimes = new ArrayList<>();
    private ArrayList<Double> heavyCloudExecTimes = new ArrayList<>();

    private Double mediumLightTaskExecTime;
    private Double mediumMediumTaskExecTime;
    private Double mediumHeavyTaskExecTime;

    private Double mediumLightTaskExecTime_cloud;
    private Double mediumMediumTaskExecTime_cloud;
    private Double mediumHeavyTaskExecTime_cloud;


    private static ExecutionTimePredictor ourInstance;

    static {
        try {
            ourInstance = new ExecutionTimePredictor();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ExecutionTimePredictor getInstance() {
        return ourInstance;
    }

    private ExecutionTimePredictor() throws SQLException, ClassNotFoundException {
        init_all_lists();
    }

    public void addLightExecTime(Double execTime){
        this.lightExecTimes.add(execTime);
    }

    public void addLightCloudExecTime(Double execTime){
        this.lightCloudExecTimes.add(execTime);
    }

    public void addMediumExecTime(Double execTime){
        this.mediumExecTimes.add(execTime);
    }

    public void addMediumCloudExecTime(Double execTime){
        this.mediumCloudExecTimes.add(execTime);
    }

    public void addHeavyExecTime(Double execTime){
        this.heavyExecTimes.add(execTime);
    }

    public void addHeavyCloudExecTime(Double execTime){
        this.heavyCloudExecTimes.add(execTime);
    }

    public ArrayList<Double> getLightExecTimes() {
        return lightExecTimes;
    }

    public ArrayList<Double> getMediumExecTimes() {
        return mediumExecTimes;
    }

    public ArrayList<Double> getHeavyExecTimes() {
        return heavyExecTimes;
    }

    public ArrayList<Double> getLightCloudExecTimes() {
        return lightCloudExecTimes;
    }

    public void setLightCloudExecTimes(ArrayList<Double> lightCloudExecTimes) {
        this.lightCloudExecTimes = lightCloudExecTimes;
    }

    public ArrayList<Double> getMediumCloudExecTimes() {
        return mediumCloudExecTimes;
    }

    public void setMediumCloudExecTimes(ArrayList<Double> mediumCloudExecTimes) {
        this.mediumCloudExecTimes = mediumCloudExecTimes;
    }

    public ArrayList<Double> getHeavyCloudExecTimes() {
        return heavyCloudExecTimes;
    }

    public void setHeavyCloudExecTimes(ArrayList<Double> heavyCloudExecTimes) {
        this.heavyCloudExecTimes = heavyCloudExecTimes;
    }

    /**
     * This function predict the next execution time for a task.
     * @param type : type of the task (light/medium/heavy)
     * @param cloud : if true the prediction is made for cloud time, if false the prediction is mad for local times
     * @return : predicted next exection time
     */

    public Double predictExecutionTime(int type, boolean cloud){

        ArrayList<Double> times = null;
        Double mediumValue = null;

        switch (type){
            case 0:
                //LIGHT TASK
                if (cloud){
                    times = lightCloudExecTimes;
                    mediumValue = mediumLightTaskExecTime_cloud;
                } else {
                    times = lightExecTimes;
                    mediumValue = mediumLightTaskExecTime;
                }
                break;
            case 1:
                //MEDIUM TASK
                if (cloud){
                    times = mediumCloudExecTimes;
                    mediumValue = mediumMediumTaskExecTime_cloud;
                }else{
                    times = mediumExecTimes;
                    mediumValue = mediumMediumTaskExecTime;
                }
                break;
            case 2:
                //HEAVY TASK
                if (cloud){
                    times = heavyCloudExecTimes;
                    mediumValue = mediumHeavyTaskExecTime_cloud;
                }else {
                    times = heavyExecTimes;
                    mediumValue = mediumHeavyTaskExecTime;
                }
                break;
        }

        Double res = calculateTime(times,mediumValue);
        if (res != null) return res;
        return 0D;
    }

    /**
     * Calculate the predicted time of the next task from the time of the last executed task and from the medium value
     * previously calculated
     * @param times : Arraylist of times of all executions
     * @param mediumValue : medium value of execution time
     * @return : next predicted execution time
     */

    private Double calculateTime(ArrayList<Double> times, Double mediumValue) {
        if (times.size() ==0 || times.size() ==1){
            System.out.println("Dati insufficienti per la predizione!");
        }
        else {
            Double t1 = times.get(times.size()-1);
            Double res = (t1+mediumValue)/2;
            return res;
        }
        return null;
    }

    /**
     * Calculate the medium value of an array of doubles
     * @param list : array of times
     * @return : medium value of the array
     */
    private Double calculateMediumTime(ArrayList<Double> list){
        double sum = 0;
        if (list.size()==0){
            return 0D;
        }
        int i = 0;
        for (; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum/i;
    }

    /**
     * This function is used to initialize all the list used for making predictions of execution times and energy consumed.
     * The times used for the predictions are taken from a database and represent times of previous executions.
     */

    public void init_all_lists() throws ClassNotFoundException, SQLException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Connection connection = databaseHandler.connect();

        // INIT LISTS FOR LOCAL ENERGY PREDICTION
        this.lightExecTimes = databaseHandler.getTasksFromDB(lightTaskDB,connection);
        this.mediumLightTaskExecTime = calculateMediumTime(lightExecTimes);
        this.mediumExecTimes = databaseHandler.getTasksFromDB(mediumtTaskDB,connection);
        this.mediumMediumTaskExecTime = calculateMediumTime(mediumExecTimes);
        this.heavyExecTimes = databaseHandler.getTasksFromDB(heavyTaskDB,connection);
        this.mediumHeavyTaskExecTime = calculateMediumTime(heavyExecTimes);

        // INIT LISTS FOR CLOUD ENERGY PREDICTION
        this.lightCloudExecTimes = databaseHandler.getTasksFromDB(lightTaskDB_cloud,connection);
        this.mediumLightTaskExecTime_cloud = calculateMediumTime(lightCloudExecTimes);
        this.mediumCloudExecTimes = databaseHandler.getTasksFromDB(mediumtTaskDB_cloud,connection);
        this.mediumMediumTaskExecTime_cloud = calculateMediumTime(mediumCloudExecTimes);
        this.heavyCloudExecTimes = databaseHandler.getTasksFromDB(heavyTaskDB_cloud,connection);
        this.mediumHeavyTaskExecTime_cloud = calculateMediumTime(heavyCloudExecTimes);

        System.out.println("Lists Initialized!");
    }


}
