package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);
        List<Tree> diffTree = Tree.buildDiff(firstFileToMap, secondFileToMap);
        return Formatter.format(diffTree, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String stringFile(String filepath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        String stringFromFile = stringFile(filepath);
        return Parser.parse(stringFromFile, filepath);
    }
}
