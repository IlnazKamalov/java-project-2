package hexlet.code;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;

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

    protected static Node createDifference(Map<String, Object> map1, Map<String, Object> map2, String key) {
        Object map1key = map1.get(key);
        Object map2key = map2.get(key);

        if (!map2.containsKey(key)) {
            return new Node("removed", key, map1key, map2key);
        } else if (!map1.containsKey(key)) {
            return new Node("added", key, map1key, map2key);
        } else if (Objects.equals(map1key, map2key)) {
            return new Node("unchanged", key, map1key, map2key);
        } else {
            return new Node("changed", key, map1key, map2key);
        }
    }
}
