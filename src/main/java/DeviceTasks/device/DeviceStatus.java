package DeviceTasks.device;

public class DeviceStatus {

    private Integer ram;
    private Integer cpu;
    private Integer battery = 100; //percentage
    private Integer storage;
    private Integer currentRam;
    private Integer currentCpu;
    private Float currentBattery;
    private Integer currentStorage;

    private double power_usage = 1.0; //WATTAGE
    private double power_usage_idle = 0.5;
    private double power_download_wifi = 1.4;
    private double power_upload_wifi = 1.6;
    private double power_dowload_mobiledata = 1.6;
    private double power_upload_mobiledata = 1.9;
    private int bandwith_wifi = 1048576; //byte per second - 1Mb/s
    private int bandwith_mobile = 716800;  // 700kb/s


    /** The execution mode states what is the device policy for execution tasks
         value 0 = Power Saving Mode. The offloading algorithm send tasks to middleware only if it's better for enery saving
         value 1 = Resources Saving Mode. Always send tasks to middleware in order to save device resources
         value 2 = Time Saving Mode. Always execute tasks locally in order to save time.
    */
    private int executionMode = 0;


    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getCurrentRam() {
        return currentRam;
    }

    public void setCurrentRam(Integer currentRam) {
        this.currentRam = currentRam;
    }

    public Integer getCurrentCpu() {
        return currentCpu;
    }

    public void setCurrentCpu(Integer currentCpu) {
        this.currentCpu = currentCpu;
    }

    public Float getCurrentBattery() {
        return currentBattery;
    }

    public void setCurrentBattery(Float currentBattery) {
        this.currentBattery = currentBattery;
    }

    public Integer getCurrentStorage() {
        return currentStorage;
    }

    public void setCurrentStorage(Integer currentStorage) {
        this.currentStorage = currentStorage;
    }

    public int getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(int executionMode) {
        this.executionMode = executionMode;
    }

    public double getPower_usage() {
        return power_usage;
    }

    public void setPower_usage(double power_usage) {
        this.power_usage = power_usage;
    }

    public double getPower_usage_idle() {
        return power_usage_idle;
    }

    public void setPower_usage_idle(double power_usage_idle) {
        this.power_usage_idle = power_usage_idle;
    }

    public double getPower_download_wifi() {
        return power_download_wifi;
    }

    public void setPower_download_wifi(double power_download_wifi) {
        this.power_download_wifi = power_download_wifi;
    }

    public double getPower_upload_wifi() {
        return power_upload_wifi;
    }

    public void setPower_upload_wifi(double power_upload_wifi) {
        this.power_upload_wifi = power_upload_wifi;
    }

    public double getPower_dowload_mobiledata() {
        return power_dowload_mobiledata;
    }

    public void setPower_dowload_mobiledata(double power_dowload_mobiledata) {
        this.power_dowload_mobiledata = power_dowload_mobiledata;
    }

    public double getPower_upload_mobiledata() {
        return power_upload_mobiledata;
    }

    public void setPower_upload_mobiledata(double power_upload_mobiledata) {
        this.power_upload_mobiledata = power_upload_mobiledata;
    }

    public int getBandwith_wifi() {
        return bandwith_wifi;
    }

    public void setBandwith_wifi(int bandwith_wifi) {
        this.bandwith_wifi = bandwith_wifi;
    }

    public int getBandwith_mobile() {
        return bandwith_mobile;
    }

    public void setBandwith_mobile(int bandwith_mobile) {
        this.bandwith_mobile = bandwith_mobile;
    }
}
