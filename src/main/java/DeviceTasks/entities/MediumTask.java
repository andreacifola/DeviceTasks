package DeviceTasks.entities;

public class MediumTask extends Task {

    private int number; //numero da trovare
    private long time = 0;  //tempo totale impiegato
    private Integer state = -1; //ci dice a che punto del ciclo siamo, cioè a quale "i" sono arrivato
    private Long currentTime;   //tempo parziale speso per l'esecuzione

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }
}
