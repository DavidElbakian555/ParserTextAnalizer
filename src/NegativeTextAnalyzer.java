class NegativeTextAnalyzer extends KeywordAnalyzer {
    private final String[] negativeKeywords = {":(", "=", ":|"};

    public NegativeTextAnalyzer() {
    }

    @Override
    protected String[] getKeywords() {
        return negativeKeywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
