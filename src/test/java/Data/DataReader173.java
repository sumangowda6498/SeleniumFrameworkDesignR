package Data;

import org.apache.commons.io.FileUtils;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader173 {
    public List<HashMap<String,String>> getJsonDataMap() throws IOException {
        //reading json to string
       String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Data//PurchaseOrder_173.json"), StandardCharsets.UTF_8);

    //string to hashMap
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});

        return data;
    }
}
