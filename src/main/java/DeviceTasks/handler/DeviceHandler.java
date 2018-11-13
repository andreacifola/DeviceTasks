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

    public int getExecutionMode(){
        return device.getExecutionMode();
    }

    public double getPowerUsage(){
        return device.getPower_usage();
    }

    public double getPowerUsageIdle(){
        return device.getPower_usage_idle();
    }

    public double getPowerDownWifi(){
        return device.getPower_download_wifi();
    }

    public double getPowerUploadWifi(){
        return device.getPower_upload_wifi();
    }

    public double getPowerDownData(){
        return device.getPower_dowload_mobiledata();
    }

    public double getPowerUploadData(){
        return device.getPower_upload_mobiledata();
    }

    public int getBandwithWifi(){
        return device.getBandwith_wifi();
    }

    public int getBandwithMobile(){
        return device.getBandwith_mobile();
    }
}
