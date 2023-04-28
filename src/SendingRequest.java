import java.io.IOException;
import java.util.Random;

public class SendingRequest implements RequestGenerator {
    private final Random random = new Random();
    private final String url = "http://numbersapi.com/" + random.nextInt() + "/trivia";

    @Override
    public String generateRequest() {
        Request request = new Request();
        String message;
        try {
            message = request.connect(url);
        } catch (IOException e) {
            message = "Something went wrong " + e.getMessage();
        }
        return message;
    }

    public String getUrl() {
        return url;
    }
}

interface RequestGenerator {
    String generateRequest();
}


