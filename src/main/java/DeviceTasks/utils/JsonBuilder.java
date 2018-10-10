package DeviceTasks.utils;


import DeviceTasks.entities.HeavyTask;
import DeviceTasks.entities.LightTask;
import DeviceTasks.entities.MediumTask;

public class JsonBuilder {

    public String LightTaskToJSON(LightTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() +
                "\", \"consumption\" : " + task.getConsumption() + ", \"toEncrypt\": \"" + task.getToEncrypt() +
                "\", \"latitude\" : \"" + task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\"}";
        System.out.println(payload);
        return payload;
    }

    public String MediumTaskToJSON(MediumTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() +
                "\", \"consumption\" : " + task.getConsumption() + ", \"number\": \"" + task.getNumber() +
                "\", \"latitude\" : \"" + task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\"}";
        System.out.println(payload);
        return payload;
    }

    public String HeavyTaskToJSON(HeavyTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() + "\" ,"+
                " \"n\" : \""+ task.getN()+"\", \"partial\" : \""+task.getPartial()+"\", \"last\" : \""+task.getLast()+
                "\", \"consumption\" : " + task.getConsumption() + ", \"response\" : \"\"" +
                ", \"latitude\" : \"" + task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\"}";
        System.out.println(payload);
        return payload;
    }
}
