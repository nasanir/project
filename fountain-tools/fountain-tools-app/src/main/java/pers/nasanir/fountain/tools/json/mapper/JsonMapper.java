package pers.nasanir.fountain.tools.json.mapper;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonMapper {
    public static Object json2Obj(Object obj, String json) {
        if (obj != null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(json, obj.getClass());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String obj2Json(Object obj) {
        if (obj != null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsString(obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
