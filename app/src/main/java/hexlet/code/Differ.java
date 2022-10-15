package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);
        List<Tree> diffTree = Tree.buildDiff(firstFileToMap, secondFileToMap);
        return Formatter.format(diffTree, format);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String stringFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public static Map<String, Object> getData(String filepath) throws IOException {
        String stringFromFile = stringFile(filepath);
        return Parser.parse(stringFromFile, filepath);
    }
}
