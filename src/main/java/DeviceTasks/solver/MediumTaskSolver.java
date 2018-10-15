package DeviceTasks.solver;

import DeviceTasks.entities.MediumTask;

import java.io.IOException;

public class MediumTaskSolver {

    public long count(MediumTask task) throws IOException {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (task.getNumber() == i)
                break;
        }
        Long time = System.currentTimeMillis() - start;
        System.out.println("mediumTask completato in " + time + " msec");
        return time;
    }
}
