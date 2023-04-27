import java.io.IOException;
import java.util.Random;

public class GetMessage implements Connector {
    private final Random random = new Random();
    private final String url = "http://numbersapi.com/" + random.nextInt() + "/trivia";

    @Override
    public String generateNumberRequest() {
        ConnectionService.Request request = new ConnectionService.Request();
        String message = "";
        try {
            message = request.connect(url);
        } catch (IOException e) {
            message = "Something went wrong " + e.getMessage();
        }
        return message;
    }
}

interface Connector {
    String generateNumberRequest();
}


