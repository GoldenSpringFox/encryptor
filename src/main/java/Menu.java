import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.lang.Integer;

public class Menu {
    // Attributes
    private String filePath;
    private int modeNumber;
    private final Map<Integer, String> modes = new HashMap<Integer, String>() {{
        put(1, "Encryption");
        put(2, "Decryption");
    }};
    private final Scanner menuScanner;

    // Constructor
    public Menu () {
        menuScanner = new Scanner(System.in);
    }

    // Helping Methods
    private int convertInputToNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        }
        catch (NumberFormatException nfe)
        {
            return -1;
        }
    }

    private void printFormattedCypherResult(CypherResult cypherResult) {
        System.out.println("Key: " + cypherResult.getKey());
        System.out.println("\n~~ Resulting Text ~~\n" + cypherResult.getText());
    }

    // Methods
    public void printEntireMenu () {
        showTitle();
        askToChooseMode();
        askForFilePath();
        showResult();
    }

    public void showTitle () {
        System.out.println("Encoder/Decoder\n---------------");
    }

    public void askToChooseMode () {
        boolean isValidOption;
        do {
            System.out.println("\nPlease choose a mode:");
            for (Map.Entry<Integer, String> entry : modes.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
            System.out.println("\n(enter the option's number): ");
            String modeText = menuScanner.nextLine();
            modeNumber = convertInputToNumber(modeText);
            isValidOption = (modes.get(modeNumber) != null);
            if (!isValidOption) {
                System.out.println("Error! you have not entered a possible option. Please try again:");
            }
        } while (!isValidOption);
    }

    public void askForFilePath () {
        boolean isFile;
        do {
            System.out.println("\nPlease enter your file path:");
            filePath = menuScanner.nextLine();
            isFile = FileHandler.checkIfValidFile(filePath);
        } while(!isFile);
    }

    public void printCypherResult () {
        CypherResult cypherResult;
        switch(modeNumber) {
            case 1:
                Encryptor encryptor = new Encryptor(filePath);
                cypherResult = encryptor.caesarCipherRandomKey();
                printFormattedCypherResult(cypherResult);
                break;
            case 2:
                Decryptor decryptor = new Decryptor(1, filePath);
                cypherResult = decryptor.caesarDecypher();
                printFormattedCypherResult(cypherResult);
                break;
            default:
                System.out.println("The option you chose was not yet implemented");
        }
    }

    public void showResult () {
        System.out.println("\n" + modes.get(modeNumber));
        System.out.println("-------------");
        printCypherResult();
    }
}
