package hexlet.code;

import java.util.Map;
import java.util.Objects;

public class Node {

    private final String typeOfChange;
    private final String key;
    private final Object startingValue;
    private final Object finalValue;

    public Node(String type, String thisKey, Object startV, Object finalV) {
        this.typeOfChange = type;
        this.key = thisKey;
        this.startingValue = startV;
        this.finalValue = finalV;
    }

    public final String getTypeOfChange() {
        return typeOfChange;
    }

    public final String getKey() {
        return key;
    }

    public final Object getStartingValue() {
        return startingValue;
    }

    public final Object getFinalValue() {
        return finalValue;
    }

    static Node createDifference(Map<String, Object> map1, Map<String, Object> map2, String key) {
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
