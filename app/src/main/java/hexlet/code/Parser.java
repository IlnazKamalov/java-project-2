package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String formatType, String filepath) throws Exception {
        ObjectMapper objectMapper;

        if (filepath.contains(".json")) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(formatType, new TypeReference<>() {
        });
    }
}
