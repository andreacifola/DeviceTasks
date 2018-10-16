package DeviceTasks.utils;


import DeviceTasks.entities.HeavyTask;
import DeviceTasks.entities.LightTask;
import DeviceTasks.entities.MediumTask;

public class JsonBuilder {

    public String LightTaskToJSON(LightTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() +
                "\", \"consumption\" : " + task.getConsumption() + ", \"toEncrypt\": \"" + task.getToEncrypt() +
                "\", \"latitude\" : \"" + task.getLatitude() + "\", \"loopCount\" : \"" + task.getLoopCount() + "\"," +
                " \"longitude\" : \"" + task.getLongitude() + "\"}";
        System.out.println(payload);
        return payload;
    }

    public String MediumTaskToJSON(MediumTask task){
        /*
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() + "\", \"number\": \"" +
                task.getNumber() + "\", \"consumption\" : " + task.getConsumption() + ", \"latitude\" : \"" +
                task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\", \"state\" : " +
                task.getState() + "}";
        */
        String payload="{ \"id\" : \"" + task.getID() + "\" ,\"state\" : \"" + task.getState() + "\", " +
                "\"type\" : \"" + task.getType() + "\", \"time\" : \"" + task.getTime() + "\", " +
                " \"currentTime\" : \"" + task.getCurrentTime() + "\"," +
                "\"number\": \"" + task.getNumber() + "\", \"consumption\" : \"" + task.getConsumption() + "\"," +
                "\"latitude\" : \"" + task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\"," +
                "\"state\" : \"" + task.getState() + "\"}";
        System.out.println(payload);
        return payload;
    }

    public String HeavyTaskToJSON(HeavyTask task){
        String payload="{ \"id\" : \"" + task.getID() + "\" , \"type\" : \"" + task.getType() + "\" ,"+
                " \"n\" : \""+ task.getN()+"\", \"partial\" : \""+task.getPartial()+"\", \"last\" : \""+task.getLast()+
                "\", \"consumption\" : \"" + task.getConsumption() + "\", \"response\" : \"" + task.getResponse() + "\", " +
                "" +
                "\"latitude\" : \"" + task.getLatitude() + "\", \"longitude\" : \"" + task.getLongitude() + "\"}";
        System.out.println(payload);
        return payload;
    }
}
