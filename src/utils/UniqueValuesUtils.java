package utils;

import java.util.Arrays;

public class UniqueValuesUtils {
    public String toUniqueValues(String message) {
        String[] values = message.replaceAll(" ", "").split("");
        StringBuilder builder = new StringBuilder();

        Arrays.stream(values)
                .filter(it -> builder.indexOf(it) == -1)
                .forEach(builder::append);
        return String.valueOf(builder);
    }
}
