import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Abs implements Computations {
    private final String message;
    private HashMap<Character, Long> hashMapOfSymbols;
    private String uniqueCharactersString;

    public Abs(String message) {
        this.message = message;
    }

    @Override
    public float getAverage() {
        CharacterCount characterCount = new CharacterCount(message);
        hashMapOfSymbols = characterCount.getMapOfAllCharacters();
        uniqueCharactersString = String.valueOf(characterCount.toUniqueValues(message));

        int sum = 0;
        for (int i = 0; i < uniqueCharactersString.length(); i++) {
            sum += hashMapOfSymbols.get(uniqueCharactersString.charAt(i));
        }
        return (float) sum / hashMapOfSymbols.size();
    }

    @Override
    public String stringOfAverageSymbols(float average) {
        int result = Math.round(average);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uniqueCharactersString.length(); i++) {
            char symbol = uniqueCharactersString.charAt(i);
            if (hashMapOfSymbols.get(symbol) == result) {
                builder.append(symbol);
            }
        }
        return toUTF8(String.valueOf(builder));
    }

    private String toUTF8(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            String chr = String.valueOf(string.charAt(i));
            byte[] bytes = chr.getBytes(StandardCharsets.UTF_8);

            String utfString = chr + "(" + fromArrayToSting(bytes) + ") ";
            stringBuilder.append(utfString);
        }
        return String.valueOf(stringBuilder);
    }

    private String fromArrayToSting(byte[] bytes) {
        StringBuilder str = new StringBuilder();
        for (byte b : bytes) {
            str.append(b);
        }
        return str.toString();
    }
}

interface Computations {
    float getAverage();

    String stringOfAverageSymbols(float average);
}
