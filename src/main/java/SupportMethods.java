import java.io.File;

public class SupportMethods {
    public static int convertInputToNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        }
        catch (NumberFormatException nfe)
        {
            return -1;
        }
    }

    public static boolean checkIfValidFile(String filePath) {
        File f = new File(filePath);
        if (!f.isFile()) {
            System.out.println("The path you doesn't lead to a valid file...");
            return false;
        }
        return true;
    }
}
