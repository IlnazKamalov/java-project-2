package hexlet.code;

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
}
