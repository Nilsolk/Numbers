package utils;

import java.util.Arrays;

public class LoggerUtils {
    public void log(Object obj) {
        System.out.printf(String.valueOf(obj));
    }

    public static void log(Object... args) {
        Arrays.stream(args).forEach(System.out::println);
    }
}
