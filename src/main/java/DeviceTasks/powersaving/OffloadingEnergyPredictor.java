package DeviceTasks.powersaving;

import DeviceTasks.handler.DeviceHandler;

public class OffloadingEnergyPredictor {

    /**
     * This function is used to predict the energy consumption if the task is sent to the cloud. The energy consumption is
     * divided in 3 parts : the energy consumed for sending data to the middleware, the energy consumed for waiting for the response
     * and the energy consumed for downloading the response.
     * @param type : task type
     * @return : energy consumption
     */

    public double predict_energy_consumption(int type){
        float data = 0;
        Double exec_time_cloud = ExecutionTimePredictor.getInstance().predictExecutionTime(type,true);
        //Calcola l'energia per inviare dati
        switch (type){
            case 0:
                data = 100;
                break;
            case 1:
                data = 250;
                break;
            case 2:
                data = 500;
                break;
        }
        double sending_time = data/DeviceHandler.getInstance().getBandwithMobile();
        double energy_sending = sending_time*DeviceHandler.getInstance().getPowerUploadData();
        //calcola energia idle
        double energy_waiting = exec_time_cloud * DeviceHandler.getInstance().getPowerUsageIdle();
        //calcola energia per scaricare dati
        double dowloading_time = data/DeviceHandler.getInstance().getBandwithMobile();
        double energy_dowloading = dowloading_time*DeviceHandler.getInstance().getPowerDownData();
        System.out.println("Predicted Cloud consumption = "+ (energy_sending+energy_waiting+energy_dowloading));
        return energy_sending+energy_waiting+energy_dowloading;
    }
}
