package md.maib.app.maib.json;


import md.maib.app.maib.entity.Client;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    public List<Client> getClient(String json){
        ObjectMapper mapper = new ObjectMapper();
        List<Client> methodList = new ArrayList<>();
        try{
            methodList = Arrays.asList(mapper.readValue(json, Client[].class));
        } catch (IOException e) {
            System.out.println(e);
        }
        return methodList;
    }
}
