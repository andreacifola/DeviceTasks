package entities;

/**
 * Created by andreacifola on 18/09/2018.
 */
public class LightTask extends Task {

    private String toEncrypt;
    private String encrypted;

    public LightTask(String string){
        this.toEncrypt = string;
    }

    public String getToEncrypt() {
        return toEncrypt;
    }

    public void setToEncrypt(String toEncrypt) {
        this.toEncrypt = toEncrypt;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }
}
