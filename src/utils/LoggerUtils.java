package utils;

public class LoggerUtils {
    public void log(Object obj) {
        System.out.printf(String.valueOf(obj));
    }

    public static void log(Object... args) {
        for (Object obj : args) {
            System.out.print(obj);
        }
    }
}
