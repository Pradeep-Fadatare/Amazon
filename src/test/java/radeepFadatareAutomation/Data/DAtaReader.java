package radeepFadatareAutomation.Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DAtaReader {

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
//        Reading Data from Json
        String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\radeepFadatareAutomation\\Data\\PurchaseOrder.json"), StandardCharsets.UTF_8);

//        String to hash Map
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
}
