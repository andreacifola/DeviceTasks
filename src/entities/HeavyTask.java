package entities;

/**
 * Created by andreacifola on 18/09/2018.
 */
public class HeavyTask extends Task{

    private Long n = 45L;
    private Long response;

    public Long getResponse() {
        return response;
    }

    public void setResponse(Long response) {
        this.response = response;
    }
}
