package utils;

import java.util.HashMap;
import java.util.stream.IntStream;

public class CharactersMapUtils {
    public HashMap<Character, Long> getCharactersMap(String message) {
        HashMap<Character, Long> symbolsValueMap = new HashMap<>();
        message = message.replaceAll(" ", "");

        String finalMessage = message;
        IntStream.range(0, message.length()).forEach(i -> {
            char ch = finalMessage.charAt(i);
            long count = finalMessage.chars().filter(c -> c == ch).count();
            symbolsValueMap.put(finalMessage.charAt(i), count);
        });
        return symbolsValueMap;
    }
}
