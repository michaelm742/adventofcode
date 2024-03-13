import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AdventDay4b {

    public static void main(String[] args) {
        String cardData = "C:\\Users\\michaelm\\OneDrive - NominetUK.onmicrosoft.com\\Documents\\adventofcode\\" +
                "testinputday4.txt";
        try {
            int sum = addEachLine(cardData);
            System.out.println("The total number of cards processed is: " + sum);
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
                //here is where I try to insert additional lines based on returned value
                //use "Card 1" name to identify the originals and extend??
                sum += 1;
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

        return matchCount;


    }
}

