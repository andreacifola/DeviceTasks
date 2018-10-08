package DeviceTasks.entities;

public class Task {

    //private static final AtomicInteger count = new AtomicInteger(0);
    private Integer ID;
    private Type type;
    private Integer consumption;
    private Double latitude;
    private Double longitude;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
