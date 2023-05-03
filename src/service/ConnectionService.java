package service;

import java.io.IOException;

public interface ConnectionService {
    String connect(String url) throws IOException;
}
