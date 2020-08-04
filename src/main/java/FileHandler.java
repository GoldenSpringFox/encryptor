import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {
    // Attributes
    private final String filePath;
    private final String fileText;

    // Constructor
    public FileHandler(String filePath) {
        this.filePath = filePath;
        fileText = readFileSafely(filePath);
    }

    // Getters
    public String getFilePath() {
        return filePath;
    }

    public String getFileText() {
        return fileText;
    }

    // Class Methods
    public static boolean checkIfValidFile(String filePath) {
        File f = new File(filePath);
        if (!f.isFile()) {
            System.out.println("The path you doesn't lead to a valid file...");
            return false;
        }
        return true;
    }

    // Object Methods
    public String readFileSafely (String filePath) {
        try {
            Scanner fileReader = new Scanner(new File(filePath));
            StringBuilder fileDataTemp = new StringBuilder();
            while (fileReader.hasNextLine()) {
                fileDataTemp.append(fileReader.nextLine());
                fileDataTemp.append('\n');
            }
            return fileDataTemp.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
