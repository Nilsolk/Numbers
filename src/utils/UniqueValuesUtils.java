package utils;

public class UniqueValuesUtils {
    public String toUniqueValues(String message) {
        String[] values = message.replaceAll(" ", "").split("");
        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            if (builder.indexOf(value) == -1) {
                builder.append(value);
            }
        }
        return String.valueOf(builder);
    }
}
