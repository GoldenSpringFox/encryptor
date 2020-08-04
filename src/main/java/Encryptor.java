import java.lang.Math;

public class Encryptor {
    // Attributes
    private final FileHandler fileInPath;

    // Constructor
    public Encryptor(String filePath) {
        fileInPath = new FileHandler(filePath);
    }

    // Methods
    public CypherResult caesarCipherRandomKey() {
        int key = (int)(Math.random()*(Cyphers.LETTER_COUNT-1) + 1);
        String encryptedText = Cyphers.caesar(key, fileInPath.getFileText());
        return new CypherResult(key, encryptedText);
    }

}
