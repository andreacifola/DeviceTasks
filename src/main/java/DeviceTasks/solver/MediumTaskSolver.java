package DeviceTasks.solver;

import DeviceTasks.entities.MediumTask;

import java.io.IOException;

public class MediumTaskSolver {
/*
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
*/
    public long count(MediumTask mediumTask) throws IOException {
        int i;

        //recupero il tempo che eventualmente può essere legato ad una esecuzione precedente
        Long time = mediumTask.getCurrentTime();

        Long start = System.currentTimeMillis();

        for (i = mediumTask.getState()+1; i < 1000000; i++) {

            if (mediumTask.getNumber() == i)
                break;
        }

        //lo aggiorno con il tempo della esecuzione attuale
        time = time + System.currentTimeMillis() - start;

        return time;
    }
}
