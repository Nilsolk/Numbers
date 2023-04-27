import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Request implements ConnectionService {
    @Override
    public String connect(String url) throws IOException {
        URL link = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String message;
        StringBuilder response = new StringBuilder();

        while ((message = in.readLine()) != null) {
            response.append(message);
        }
        in.close();
        return response.toString();
    }
}

interface ConnectionService {
    String connect(String url) throws IOException;
}
