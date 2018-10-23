package DeviceTasks.solver;

import DeviceTasks.entities.HeavyTask;

import java.math.BigInteger;

public class HeavyTaskSolver {

    public BigInteger factorial(HeavyTask heavyTask){

        int i;
        int last = heavyTask.getLast();
        int n = heavyTask.getN();

        BigInteger fact = heavyTask.getPartial();  //setto il risultato come il parziale eventuale di una esecuzione precedente
        System.out.println("fact ricevuto : " + fact);
        for(i = last+1; i<=n; i++)
            fact = fact.multiply(BigInteger.valueOf(i));

        return fact;
    }
}
