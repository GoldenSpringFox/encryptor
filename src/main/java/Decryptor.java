public class Decryptor {
    // Attributes
    private final FileHandler fileInPath;
    private int key;

    // Constructor
    public Decryptor(int key, String filePath) {
        fileInPath = new FileHandler(filePath);
        this.key = key;
    }

    // Methods
    public CypherResult caesarDecypher() {
        String encryptedText = Cyphers.caesar(-key, fileInPath.getFileText());
        return new CypherResult(key, encryptedText);
    }
}
