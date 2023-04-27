import java.util.*;

interface Result {
    void countOfSymbols();

    void getMessage();


    class Base implements Result {
        private final GetMessage getMessage = new GetMessage();
        private final String result = getMessage.generateNumberRequest();

        @Override
        public void countOfSymbols() {
            if (result.contains("numbersapi.com")) {
                String[] arrOfInformation = result.split("\n");
                String message = arrOfInformation[1];

                InfoAboutMessage.Base infoAboutMessage = new InfoAboutMessage.Base(message);
                HashMap<Character, Long> hashMap = infoAboutMessage.getInfo();
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
    }
}

