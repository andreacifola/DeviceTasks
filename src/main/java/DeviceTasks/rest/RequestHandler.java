package DeviceTasks.rest;

import DeviceTasks.entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHandler {

    private ObjectMapper mapper = new ObjectMapper();

    public int registerTask(String requestUrl,Task task, String payload){
        StringBuffer jsonString = new StringBuffer();
        sendPost(requestUrl,payload,jsonString);
        return Integer.parseInt(jsonString.toString());
    }

    private void sendPost(String requestUrl, String payload, StringBuffer jsonString) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(payload);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public int registerTask(String requestUrl,Task task, String payload){
        StringBuffer jsonString = new StringBuffer();
        sendPost(requestUrl,payload,jsonString);
        return Integer.parseInt(jsonString.toString());
    }

    public LightTask sendLightPostRequest(String requestUrl, String payload) throws IOException {
        StringBuffer jsonString = new StringBuffer();
        sendPost(requestUrl, payload, jsonString);
        return mapper.readValue(jsonString.toString(), LightTask.class);
    }

    public MediumTask sendMediumPostRequest(String requestUrl, String payload) throws IOException {
        StringBuffer jsonString = new StringBuffer();
        sendPost(requestUrl, payload, jsonString);
        return mapper.readValue(jsonString.toString(), MediumTask.class);
    }

    public HeavyTask sendHeavyPostRequest(String requestUrl, String payload) throws IOException {
        StringBuffer jsonString = new StringBuffer();
        sendPost(requestUrl, payload, jsonString);
        return mapper.readValue(jsonString.toString(), HeavyTask.class);
    }

    public String sendPostRequest(String requestUrl, String payload) {
        StringBuffer jsonString = new StringBuffer();
        sendPost(requestUrl, payload, jsonString);
        return jsonString.toString();
    }

    public String sendGetRequest(String requestUrl) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public Task mapJSONToTask(String jsonstring,Type type) throws IOException {
        switch (type){
            case LIGHT:
                return mapper.readValue(jsonstring,LightTask.class);
            case MEDIUM:
                return mapper.readValue(jsonstring,MediumTask.class);
            case HEAVY:
                return mapper.readValue(jsonstring,HeavyTask.class);
        }
        return null;
    }
}
