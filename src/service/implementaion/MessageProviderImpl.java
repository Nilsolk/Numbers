package service.implementaion;

import service.MessageProvider;
import service.RequestProvider;
import service.text_service.AverageService;
import service.text_service.text_service_implementation.AverageServiceImpl;
import service.text_service.text_service_implementation.CountServiceImpl;
import utils.CharactersMapUtils;
import utils.UniqueValuesUtils;

import java.util.HashMap;

public class MessageProviderImpl implements MessageProvider {
    private final CharactersMapUtils mapUtils = new CharactersMapUtils();
    private final UniqueValuesUtils valuesUtils = new UniqueValuesUtils();
    private final RequestProvider requestProvider = new RequestProviderImpl();
    private final String result = requestProvider.provideRequest();
    private final HashMap<Character, Long> hashMap = mapUtils.getCharactersMap(result);
    private final String unique = valuesUtils.toUniqueValues(result);
    private final AverageService averageService = new AverageServiceImpl(hashMap, unique);

    @Override
    public String countOfSymbols() {
        CountServiceImpl countService = new CountServiceImpl(hashMap, unique);
        return countService.getCountOfCharacters() + "\n";
    }

    @Override
    public String getMessage() {
        return "link: " + requestProvider.provideUrl() + "\n" + "Message: " + result + "\n";
    }

    @Override
    public String getAverage() {
        return "Average = " + averageService.getAverage() + "\n";
    }

    @Override
    public String getAverageCharacters() {
        String str = averageService.stringOfAverageSymbols(averageService.getAverage());
        if (str.isEmpty()) {
            str = averageService.stringOfAverageSymbols(averageService.getAverage() + 1);
        }
        return "Characters: " + str + "\n";
    }
}
