package hexlet.code.formatters;

import hexlet.code.Node;
import java.util.List;

public class Plain {

    public static String plainFormatter(List<Node> diffTree) {
        StringBuilder diffBuilder = new StringBuilder();

        for (Node pair : diffTree) {
            String key = pair.getKey();
            Object sValue = pair.getStartingValue();
            Object fValue = pair.getFinalValue();
            String typeOfChange = pair.getTypeOfChange();

            String thisKey = "Property '" + key + "'";

            switch (typeOfChange) {

                case "removed":
                    diffBuilder.append(thisKey).append(" was removed").append("\n");
                    break;
                case "added":
                    diffBuilder.append(thisKey).append(" was added with value: ")
                            .append(getValueAsString(fValue)).append("\n");
                    break;
                case "changed":
                    diffBuilder.append(thisKey).append(" was updated. From ")
                            .append(getValueAsString(sValue)).append(" to ")
                            .append(getValueAsString(fValue)).append("\n");
                    break;
                default:
                    break;
            }
        }
        return diffBuilder.toString().trim();
    }

    private static String getValueAsString(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return "null";
        } else if (!(value instanceof Integer) && !(value instanceof Boolean)) {
            return "[complex value]";
        }
        return value.toString();
    }
}
