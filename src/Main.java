public class Main {
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {
        String[] spamKeywords = {"спам", "купите сейчас", "получите скидку", "бонус"};
        TextAnalyzer[] analyzers = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(40)
        };

        String[] texts = {
                "Это нормальный комментарий.",
                "Получите бонус 30%",
                "Плохая статья :(",
                "Этот комментарий слишком длинный, чтобы его можно было считать обычным комментарием, поскольку он превышает максимально допустимую длину."
        };

        for (String text : texts) {
            System.out.println("Text: " + text);
            System.out.println("Label: " + checkLabels(analyzers, text));
            System.out.println();
        }
    }
}