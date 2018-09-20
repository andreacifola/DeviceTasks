package DeviceTasks.utils;


import DeviceTasks.entities.HeavyTask;
import DeviceTasks.entities.LightTask;
import DeviceTasks.entities.MediumTask;

public class JsonBuilder {

    public String LightTaskToJSON(LightTask task){
        String payload="{ \"id\" : \""+task.getID()+"\" , \"type\" : \""+task.getType()+"\", \"toEncrypt\": \""+task.getToEncrypt()+"\"}";
        System.out.println(payload);
        return payload;
    }

    public String MediumTaskToJSON(MediumTask task){
        String payload="{ \"id\" : \""+task.getID()+"\" , \"type\" : \""+task.getType()+"\", \"number\": \""+task.getNumber()+"\"}";
        System.out.println(payload);
        return payload;
    }

    public String HeavyTaskToJSON(HeavyTask task){
        String payload="{ \"id\" : \""+task.getID()+"\" , \"type\" : \""+task.getType()+"\", \"response\" : \"\"}";
        System.out.println(payload);
        return payload;
    }
}
