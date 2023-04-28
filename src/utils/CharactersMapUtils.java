package utils;

import java.util.HashMap;

public class CharactersMapUtils {
    public HashMap<Character, Long> getCharactersMap(String message) {
        HashMap<Character, Long> symbolsValueMap = new HashMap<>();
        message = message.replaceAll(" ", "");
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            long count = message.chars().filter(c -> c == ch).count();
            symbolsValueMap.put(message.charAt(i), count);
        }
        return symbolsValueMap;
    }
}
