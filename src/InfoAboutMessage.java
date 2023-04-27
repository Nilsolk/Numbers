import java.util.HashMap;

interface InfoAboutMessage {
    HashMap<Character, Long> getInfo();
    long countChar(char ch);

    class Base implements InfoAboutMessage {
        private final String message;

        Base(String message) {
            this.message = message.replaceAll(" ", "");
        }

        @Override
        public HashMap<Character, Long> getInfo() {
            HashMap<Character, Long> symbolsValueMap = new HashMap<>();
            for (int i = 0; i < message.length(); i++) {
                long count = countChar(message.charAt(i));
                symbolsValueMap.put(message.charAt(i), count);
            }
            return symbolsValueMap;
        }

        @Override
        public long countChar(char ch) {
            return message.chars().filter(c -> c == ch).count();
        }
    }
}
