package DeviceTasks.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {

    //private static final AtomicInteger count = new AtomicInteger(0);
    private int ID;
    private Type type;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
