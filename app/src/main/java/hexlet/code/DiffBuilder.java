package hexlet.code;



import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

import static hexlet.code.Node.createDifference;

public class DiffBuilder {
    public static List<Node> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        List<Node> allDifferences = new ArrayList<>();

        for (String key : allKeys) {
            allDifferences.add(createDifference(map1, map2, key));
        }
        return allDifferences;
    }
}
