package utils;

import entities.LightTask;

public class JsonBuilder {

    public String LightTaskToJSON(LightTask task){
        String payload="{\"Task\": { \"id\" :"+task.getID()+", \"type\" : \""+task.getType()+"\", \"toEncrypt\": \""+task.getToEncrypt()+"\"}}";
        System.out.println(payload);
        return payload;
    }
}
