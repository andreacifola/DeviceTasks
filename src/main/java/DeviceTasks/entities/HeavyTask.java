package DeviceTasks.entities;

import java.math.BigInteger;

public class HeavyTask extends Task{
    /*
    * l'heavy task consiste nel calcolo dei fattoriali di numeri. In particolare il task diventa heavy per
    * numero molto grandi: es. per n=300000 il tempo impiegato è di ca. 1 min
    */

    private int n;
    private BigInteger partial;
    private BigInteger response;
    private int last = 0;

    public BigInteger getResponse() {
        return response;
    }

    public void setResponse(BigInteger response) {
        this.response = response;
    }

    public int getN(){ return n; }

    public void setN(int n){
        this.n = n;
    }

    public BigInteger getPartial() {
        return partial;
    }

    public void setPartial(BigInteger partial) {
        this.partial = partial;
    }

    public int getLast() {
        return last;
    }
    public void setLast(int last) {
        this.last = last;
    }
}
