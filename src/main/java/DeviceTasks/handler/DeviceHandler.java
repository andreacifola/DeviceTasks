package DeviceTasks.handler;

import DeviceTasks.device.DeviceStatus;

public class DeviceHandler {

    private DeviceStatus device;

    private static DeviceHandler ourInstance = new DeviceHandler();

    public static DeviceHandler getInstance() {
        return ourInstance;
    }

    private DeviceHandler() {
        this.device = new DeviceStatus();
    }

    public Boolean checkPowerSaving(){
        if (device.getPowerSaving())
            return true;
        if (device.getBattery() <= 20){
            //enter power saving
            return true;
        }else {
            return false;
        }
    }

    public void setForcedPowerSaving(){
        device.setPowerSaving(true);
        System.out.println("Entering Power Saving mode");
    }
}
