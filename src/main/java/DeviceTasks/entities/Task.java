package DeviceTasks.entities;

public class Task {

    //private static final AtomicInteger count = new AtomicInteger(0);
    private Integer ID;
    private Type type;
    private Integer consumption;

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
}
