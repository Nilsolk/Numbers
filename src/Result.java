import java.util.*;

class GenerateMessage implements Result {
    private final SendingRequest sendingRequest = new SendingRequest();
    private final String result = sendingRequest.generateRequest();

    @Override
    public void countOfSymbols() {
        if (result.contains("numbersapi.com")) {
            String[] arrOfInformation = result.split("\n");
            String message = arrOfInformation[1];

            CharacterCount characterCount = new CharacterCount(message);
            HashMap<Character, Long> hashMap = characterCount.getMapOfAllCharacters();
            String uniqueValuesString = String.valueOf(toUniqueValues(message));

            for (int i = 0; i < uniqueValuesString.length(); i++) {
                Character chr = uniqueValuesString.charAt(i);
                System.out.println(chr + " : " + hashMap.get(chr));
            }
        }
    }

    private StringBuilder toUniqueValues(String message) {
        String[] values = message.replaceAll(" ", "").split("");
        StringBuilder builder = new StringBuilder();
        for (String value : values) {
            if (builder.indexOf(value) == -1) {
                builder.append(value);
            }
        }
        return builder;
    }


    @Override
    public void getMessage() {
        System.out.println(result);
    }

    @Override
    public void getAbs() {

    }
}

interface Result {
    void countOfSymbols();

    void getMessage();

    void getAbs();
}

