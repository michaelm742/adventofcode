import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AdventDay4 {

    public static void main(String[] args) {
        String cardData = "C:\\Users\\michaelm\\OneDrive - NominetUK.onmicrosoft.com\\Documents\\adventofcode\\" +
                "inputday4.txt";
        try {
            int sum = addEachLine(cardData);
            System.out.println("The total number of points is: " + sum);
        } catch (IOException e) {
            System.err.println("Error reading the document: " + e.getMessage());
        }
    }
    private static int addEachLine(String cardData) throws IOException {
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(cardData))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double value = calculatePoints(line);
                sum += value;
            }
        }
        return sum;
    }
    private static double calculatePoints(String line) {
        // Split the input string based on ":" and "|"
        String[] parts = line.split(":|\\|");

        // Extract numbers from both sides of the divider
        String[] leftNumbers = parts[1].trim().split("\\s+");
        String[] rightNumbers = parts[2].trim().split("\\s+");

        // Convert the arrays to sets for easy comparison
        Set<String> leftSet = new HashSet<>(Arrays.asList(leftNumbers));
        Set<String> rightSet = new HashSet<>(Arrays.asList(rightNumbers));

        // Count the number of matches
        int matchCount = 0;
        for (String number : leftSet) {
            if (rightSet.contains(number)) {
                matchCount++;
            }
        }
        if (matchCount <= 1)
        {
            double pointValue = matchCount;
            return pointValue;
        }
        else {
            double pointValue = Math.pow(2, (matchCount-1));
            return pointValue;
        }


    }
    }

