package service.implementaion;

import service.PrinterService;
import utils.LoggerUtils;

public class PrintServiceImpl implements PrinterService {
    private final LoggerUtils loggerUtils = new LoggerUtils();
    private final MessageProviderImpl messageProvider = new MessageProviderImpl();

    @Override
    public void print() {
        if (messageProvider.getMessage().contains("Something went wrong ")) {
            loggerUtils.log(messageProvider.getMessage());
        } else {
            String message = messageProvider.getMessage();
            String count = messageProvider.countOfSymbols();
            String average = messageProvider.getAverage();
            String averageCharacters = messageProvider.getAverageCharacters();

            LoggerUtils.log(message,count,average,averageCharacters);
        }
    }
}
