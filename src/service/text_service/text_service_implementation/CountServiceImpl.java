package service.text_service.text_service_implementation;

import service.text_service.CountService;

import java.util.HashMap;
import java.util.stream.IntStream;

public class CountServiceImpl implements CountService {
    private final HashMap<Character, Long> hashMap;
    private final String unique;

    public CountServiceImpl(HashMap<Character, Long> hashMap, String unique) {
        this.hashMap = hashMap;
        this.unique = unique;
    }

    @Override
    public String getCountOfCharacters() {
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, unique.length()).forEach(i -> {
            Character chr = unique.charAt(i);
            String string = chr + " : " + hashMap.get(chr) + "\n";
            stringBuilder.append(string);
        });

        return String.valueOf(stringBuilder);
    }
}
