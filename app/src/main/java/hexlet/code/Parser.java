package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String formatType) throws Exception {
        ObjectMapper objectMapper;

        if (formatType.equalsIgnoreCase("json")) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }
}
