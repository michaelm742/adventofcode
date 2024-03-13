import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventDay1gbt2 {

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
        Map<String, Integer> spelledDigits = initializeSpelledDigits();
        int firstDigit = 0;  // Initialize to a non-zero value
        int lastDigit = 0;   // Initialize to a non-zero value

        // Use a regular expression to find matches for spelled-out digits and digits
        Matcher matcher = Pattern.compile("\\b(?:one|two|three|four|five|six|seven|eight|nine|[1-9])\\b").matcher(line);

        while (matcher.find()) {
            String match = matcher.group();
            if (spelledDigits.containsKey(match)) {
                int digit = spelledDigits.get(match);
                if (firstDigit == 0) {
                    firstDigit = digit;
                } else {
                    lastDigit = digit;
                    break; // Stop after finding the second digit
                }
            } else if (match.matches("[1-9]")) {
                // If a single digit is present in the line, use it as the first or last digit
                if (firstDigit == 0) {
                    firstDigit = Integer.parseInt(match);
                } else {
                    lastDigit = Integer.parseInt(match);
                    break; // Stop after finding the second digit
                }
            }
        }



        // Combine the first and last digits to form a two-digit number
        int value = firstDigit * 10 + lastDigit;

        return value;
    }

    private static Map<String, Integer> initializeSpelledDigits() {
        Map<String, Integer> spelledDigits = new HashMap<>();
        spelledDigits.put("one", 1);
        spelledDigits.put("two", 2);
        spelledDigits.put("three", 3);
        spelledDigits.put("four", 4);
        spelledDigits.put("five", 5);
        spelledDigits.put("six", 6);
        spelledDigits.put("seven", 7);
        spelledDigits.put("eight", 8);
        spelledDigits.put("nine", 9);
        return spelledDigits;
    }
}
