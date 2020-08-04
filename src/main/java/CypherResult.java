public class CypherResult {
    // Attributes
    private final int key;
    private final String text;

    // Constructor
    public CypherResult (int key, String text) {
        this.key = key;
        this.text = text;
    }

    // Getters
    public int getKey() {
        return key;
    }

    public String getText() {
        return text;
    }
}
