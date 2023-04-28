package service.text_service.text_service_implementation;

import service.text_service.AverageService;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class AverageServiceImpl implements AverageService {
    private final HashMap<Character, Long> hashMapOfSymbols;
    private final String uniqueCharactersString;

    public AverageServiceImpl(HashMap<Character, Long> hashMapOfSymbols, String uniqueCharactersString) {
        this.hashMapOfSymbols = hashMapOfSymbols;
        this.uniqueCharactersString = uniqueCharactersString;
    }

    @Override
    public float getAverage() {
        int sum = 0;
        for (int i = 0; i < uniqueCharactersString.length(); i++) {
            char value = uniqueCharactersString.charAt(i);
            sum += hashMapOfSymbols.get(value);
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
