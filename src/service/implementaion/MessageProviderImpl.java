package service.implementaion;

import service.MessageProvider;
import service.RequestProvider;
import service.text_service.text_service_implementation.AverageServiceImpl;
import service.text_service.text_service_implementation.CountServiceImpl;
import utils.CharactersMapUtils;
import utils.UniqueValuesUtils;

import java.util.HashMap;

public class MessageProviderImpl implements MessageProvider {
    private final CharactersMapUtils mapUtils = new CharactersMapUtils();
    private final UniqueValuesUtils valuesUtils = new UniqueValuesUtils();
    private final RequestProvider result = new RequestProviderImpl();
    private final String str = result.provideRequest();
    private final HashMap<Character, Long> hashMap = mapUtils.getCharactersMap(str);
    private final String unique = valuesUtils.toUniqueValues(str);
    private final AverageServiceImpl averageService = new AverageServiceImpl(hashMap, unique);

    @Override
    public String countOfSymbols() {
        CountServiceImpl countService = new CountServiceImpl(hashMap, unique);
        return countService.getCountOfCharacters() + "\n";
    }

    @Override
    public String getMessage() {
        return result.provideUrl() + "\n" + result.provideRequest() + "\n";
    }

    @Override
    public String getAverage() {
        return averageService.getAverage() + "\n";
    }

    @Override
    public String getAverageCharacters() {
        return averageService.stringOfAverageSymbols(averageService.getAverage()) + "\n";
    }
}
