import java.util.HashMap;

class CharacterCount implements Counter {
    private final String message;

    CharacterCount(String message) {
        this.message = message.replaceAll(" ", "");
    }

    @Override
    public HashMap<Character, Long> getMapOfAllCharacters() {
        HashMap<Character, Long> symbolsValueMap = new HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            long count = countChar(message.charAt(i));
            symbolsValueMap.put(message.charAt(i), count);
        }
        return symbolsValueMap;
    }

    private long countChar(char ch) {
        return message.chars().filter(c -> c == ch).count();
    }
}


interface Counter {
    HashMap<Character, Long> getMapOfAllCharacters();
}