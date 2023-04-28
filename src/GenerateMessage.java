
class GenerateMessage implements Result {
    private final SendingRequest sendingRequest = new SendingRequest();
    private final String result = sendingRequest.generateRequest();

    @Override
    public void countOfSymbols() {
        if (!result.contains("Something went wrong")) {
            CharacterCount characterCount = new CharacterCount(result);
            System.out.println(characterCount.getCountOfCharacters());
        }
    }

    @Override
    public void getMessage() {
        System.out.println(sendingRequest.getUrl());
        System.out.println(result);
    }

    @Override
    public void getAbs() {
        Abs abs = new Abs(result);
        float value = abs.getAverage();
        String averageValues = abs.stringOfAverageSymbols(value);

        System.out.println("average value = " + value);
        System.out.println(averageValues);

    }
}

interface Result {
    void countOfSymbols();

    void getMessage();

    void getAbs();
}

