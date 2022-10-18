package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

public class Stylish {

    public static String stylishFormatter(List<Node> diffTree) {
        StringBuilder diffBuilder = new StringBuilder("{\n");
        String space = " ";

        for (Node pair : diffTree) {
            String key = pair.getKey();
            Object startingValue = pair.getStartingValue();
            Object finalValue = pair.getFinalValue();
            String typeOfChange = pair.getTypeOfChange();

            switch (typeOfChange) {

                case "removed":
                    diffBuilder.append(space.repeat(2) + "- " + key + ": " + startingValue + "\n");
                    break;

                case "added":
                    diffBuilder.append(space.repeat(2) + "+ " + key + ": " + finalValue + "\n");
                    break;

                case "unchanged":
                    diffBuilder.append(space.repeat(2).repeat(2) + key + ": " + startingValue + "\n");
                    break;

                case "changed":
                    diffBuilder.append(space.repeat(2) + "- " + key + ": " + startingValue + "\n"
                            + space.repeat(2) + "+ " + key + ": " + finalValue + "\n");
                    break;

                default: break;
            }
        }
        diffBuilder.append("}");
        return diffBuilder.toString();
    }
}
