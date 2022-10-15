package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Tree;

import java.util.List;

public class Json {
    public static String jsonFormatter(List<Tree> diffTree) throws Exception {
        return new ObjectMapper().writeValueAsString(diffTree);
    }
}
