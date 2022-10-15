package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<Tree> diffTree, String formatFrom) throws JsonProcessingException {
        switch (formatFrom) {
            case "plain":
                return Plain.plainFormatter(diffTree);
            case "json":
                return Json.jsonFormatter(diffTree);
            default:
                return Stylish.stylishFormatter(diffTree);
        }
    }
}
