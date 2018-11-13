package DeviceTasks.powersaving;

import DeviceTasks.handler.DeviceHandler;

public class OffloadDecisor {

    /**
     * This function compare the predicted values for energy consumption both locally and on cloud and returns true if it's better
     * to send the task to the cloud or false on contrary
     * @param type : type of the task
     * @return : true if the task must be sent to the cloud or false
     */

    public Boolean sendTaskToCloud(int type){
        OffloadingEnergyPredictor offloadingEnergyPredictor = new OffloadingEnergyPredictor();
        Double predicted_time = ExecutionTimePredictor.getInstance().predictExecutionTime(type,false);
        Double predicted_local_energy = predicted_time*DeviceHandler.getInstance().getPowerUsage();
        System.out.println("Predicted Local Energy Consumption = "+predicted_local_energy);
        Double predicted_cloud_energy = offloadingEnergyPredictor.predict_energy_consumption(type);
        return predicted_cloud_energy <= predicted_local_energy;
    }


}
