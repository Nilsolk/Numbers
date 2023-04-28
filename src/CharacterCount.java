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

    @Override
    public String getCountOfCharacters() {
        StringBuilder stringBuilder = new StringBuilder();
        String unique = String.valueOf(toUniqueValues(message));
        HashMap<Character, Long> hashMap = getMapOfAllCharacters();

        for (int i = 0; i < unique.length(); i++) {
            Character chr = unique.charAt(i);
            String string = chr + " : " + hashMap.get(chr) + "\n";
            stringBuilder.append(string);
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public StringBuilder toUniqueValues(String message) {
        String[] values = message.replaceAll(" ", "").split("");
        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            if (builder.indexOf(value) == -1) {
                builder.append(value);
            }
        }
        return builder;
    }

    private long countChar(char ch) {
        return message.chars().filter(c -> c == ch).count();
    }
}


interface Counter {
    HashMap<Character, Long> getMapOfAllCharacters();

    String getCountOfCharacters();

    StringBuilder toUniqueValues(String message);


}