package common;

import java.util.Random;

public class Common {
    private final Random random = new Random();
    private final int start = -1000;
    private final int end = -10;
    private final String url = "http://numbersapi.com/" + random.nextInt(start, end) + "/trivia";

    public String getUrl() {
        return url;
    }
}
