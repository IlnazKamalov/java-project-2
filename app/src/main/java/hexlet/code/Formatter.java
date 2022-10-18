package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<Node> diffTree, String formatFrom) throws Exception {
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
