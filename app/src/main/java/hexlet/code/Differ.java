package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import static hexlet.code.DiffBuilder.buildDiff;
import static hexlet.code.Parser.parse;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);
        List<Node> diffTree = buildDiff(firstFileToMap, secondFileToMap);
        return Formatter.format(diffTree, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String readFiles(String filepath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    private static String getFormatFile(String formatType) {
        return String.valueOf(Optional.ofNullable(formatType)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(formatType.lastIndexOf(".") + 1)));
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        String stringFromFile = readFiles(filepath);
        return parse(stringFromFile, getFormatFile(filepath));
    }
}
