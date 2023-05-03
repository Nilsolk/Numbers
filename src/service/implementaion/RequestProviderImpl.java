package service.implementaion;

import common.Common;
import service.RequestProvider;

import java.io.IOException;

public class RequestProviderImpl implements RequestProvider {
    private final Common common = new Common();

    @Override
    public String provideRequest() {
        ConnectionServiceImpl request = new ConnectionServiceImpl();
        String message;
        try {
            message = request.connect(common.getUrl());
        } catch (IOException e) {
            message = "Something went wrong " + e.getMessage();
        }
        return message;
    }

    @Override
    public String provideUrl() {
        return common.getUrl();
    }
}
