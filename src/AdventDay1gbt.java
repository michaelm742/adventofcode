import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventDay1gbt{

    public static void main(String[] args) {
        String filePath = "C:\\Users\\michaelm\\OneDrive - NominetUK.onmicrosoft.com\\Documents\\inputday1.txt"; // Replace with the actual path to your document

        try {
            int sum = calculateSum(filePath);
            System.out.println("The sum of all values is: " + sum);
        } catch (IOException e) {
            System.err.println("Error reading the document: " + e.getMessage());
        }
    }

    private static int calculateSum(String filePath) throws IOException {
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int value = extractValue(line);
                sum += value;
            }
        }

        return sum;
    }

    private static int extractValue(String line) {
        // Find the first and last digits in the line
        char firstDigit = '0';
        char lastDigit = '0';

        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                if (firstDigit == '0') {
                    firstDigit = c;
                }
                lastDigit = c;
            }
        }

        // Combine the first and last digits to form a two-digit number
        int value = Integer.parseInt(String.valueOf(firstDigit) + String.valueOf(lastDigit));

        return value;
    }
}
