import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AdventDay7 {

    public static void main(String[] args) {
        String handData = "C:\\Users\\michaelm\\OneDrive - NominetUK.onmicrosoft.com\\Documents\\adventofcode\\" +
                "testinputday7.txt";
        try {
            List<String> hands = readInputFile(handData);
            Map<String, Integer> rankedHands = rankHands(hands);


     //       int sum = findTotalWinnings(handData);
       //     System.out.println("The total earnings are: " + sum);
       // } catch (IOException e) {
       //     System.err.println("Error reading the document: " + e.getMessage());
       // }

        // Print the result
        for (String hand : hands) {
            System.out.println(hand + " " + rankedHands.get(hand));
        }

        System.out.println("Ranking completed successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }

    }

    private static List<String> readInputFile(String fileName) throws IOException {
        List<String> hands = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                hands.add(line);
            }
        }
        return hands;
    }

    private static Map<String, Integer> rankHands(List<String> hands) {
        Map<String, Integer> rankedHands = new HashMap<>();

        // Sort hands based on the specified rules
        hands.sort(Comparator.comparing(AdventDay7::handType)
                .thenComparing(Comparator.naturalOrder())
                .thenComparing(AdventDay7::compareCards));


        // Assign ranks to each hand
        int rank = 1;
        for (String hand : hands) {
            rankedHands.put(hand, rank++);
        }
        return rankedHands;
    }


    static int compareCards(String hand1, String hand2) {
        String handType1 = handType(hand1);
        String handType2 = handType(hand2);

        // Compare hands based on hand type
        int handTypeComparison = handType1.compareTo(handType2);
        if (handTypeComparison != 0) {
            return handTypeComparison;
        }

        // Compare cards within the same hand type
        for (int i = 0; i < hand1.length(); i++) {
            char card1 = hand1.charAt(i);
            char card2 = hand2.charAt(i);

            if (card1 != card2) {
                return Character.compare(card1, card2); // Compare in ascending order
            }
        }

        return 0; // Both hands are equal
    }




    static String handType(String hand) {
        if (hand.matches("A{5}")) {
            return "Five of a kind";
        } else if (hand.matches("A{2}8A{2}")) {
            return "Four of a kind";
        } else if (hand.matches("(\\d)\\1\\1(\\d)\\2|(\\d)\\1(\\d)\\2\\2")) {
            return "Full house";
        } else if (hand.matches("(\\d)\\1\\1(\\d)(\\d)\\4|(\\d)\\1(\\d)\\2(\\d)\\4|(\\d)\\1(\\d)\\4(\\d)\\6")) {
            return "Three of a kind";
        } else if (hand.matches("(\\d)\\1(\\d)\\2(\\d)(\\d)\\4|(\\d)\\1(\\d)(\\d)\\3(\\d)\\5|(\\d)(\\d)\\2(\\d)\\3(\\d)\\5")) {
            return "Two pair";
        } else if (hand.matches("(\\d)\\1(\\d)(\\d)\\3(\\d)(\\d)\\5")) {
            return "One pair";
        } else {
            return "High card";
        }
    }


    private static int findTotalWinnings(String handData) throws IOException {
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(handData))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double value = calculateWinnings(line);
                sum += value;
            }
        }
        return sum;
    }




    private static double calculateWinnings(String line) {


        return 0;
    }

}

