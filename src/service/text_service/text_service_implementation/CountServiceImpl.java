package service.text_service.text_service_implementation;

import service.text_service.CountService;

import java.util.HashMap;

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
        for (int i = 0; i < unique.length(); i++) {
            Character chr = unique.charAt(i);
            String string = chr + " : " + hashMap.get(chr) + "\n";
            stringBuilder.append(string);
        }
        return String.valueOf(stringBuilder);
    }
}
