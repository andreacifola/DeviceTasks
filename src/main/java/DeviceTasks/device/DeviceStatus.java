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

    private Boolean powerSaving;


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

    public Boolean getPowerSaving() {
        return powerSaving;
    }

    public void setPowerSaving(Boolean powerSaving) {
        this.powerSaving = powerSaving;
    }

}
