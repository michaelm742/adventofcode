import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AdventDay7b {

    public static void main(String[] args) {
        String handData = "C:\\Users\\michaelm\\OneDrive - NominetUK.onmicrosoft.com\\Documents\\adventofcode\\" +
                "testinputday7.txt";
        try {
            List<String> hands = readInputFile(handData);
            Map<String, Integer> rankedHands = rankHands(hands);

            // Print the result
            for (String hand : hands) {
                System.out.println(hand + " " + rankedHands.get(hand));
            }

            System.out.println("Ranking completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> readInputFile(String fileName) throws Exception {
        List<String> hands = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                hands.add(scanner.nextLine());
            }
        }
        return hands;
    }

    public static Map<String, Integer> rankHands(List<String> hands) {
        Map<String, Integer> rankedHands = new HashMap<>();

        // Sort hands based on the specified rules
        hands.sort(Comparator.comparing(AdventDay7b::handType,
                        AdventDay7b::compareHandTypes)
                .thenComparing(AdventDay7b::compareCards));


        // Assign ranks to each hand
        int rank = 1;
        for (String hand : hands) {
            rankedHands.put(hand, rank++);
        }
        return rankedHands;
    }



    private static int compareHandTypes(String handType1, String handType2) {
        Map<String, Integer> typeOrder = new HashMap<>();
        typeOrder.put("Five of a kind", 1);
        typeOrder.put("Four of a kind", 2);
        typeOrder.put("Full house", 3);
        typeOrder.put("Three of a kind", 4);
        typeOrder.put("Two pair", 5);
        typeOrder.put("One pair", 6);
        typeOrder.put("High card", 7);

        return Integer.compare(typeOrder.get(handType1), typeOrder.get(handType2));
    }

    private static int compareCards(String hand1, String hand2) {
        for (int i = 0; i < hand1.length(); i++) {
            char card1 = hand1.charAt(i);
            char card2 = hand2.charAt(i);

            if (card1 != card2) {
                return compareCardValues(card1, card2);
            }
        }
        return 0; // Both hands are equal
    }

    private static int compareCardValues(char card1, char card2) {
        String order = "AKQJT98765432";
        return order.indexOf(card1) - order.indexOf(card2);
    }


    private static String handType(String handData) {
        String[] parts = handData.split("\\s+");
        String hand = parts[0];  // Extract the hand from the first part

        // Patterns for different hand types
        String fiveOfAKind = "([A2-9TJQK])\\1{4}";
        String fourOfAKind = "([A2-9TJQK])\\1{3}[A2-9TJQK]";
        String fullHouse = "(([A2-9TJQK])\\2{2}([A2-9TJQK])\\3)|(([A2-9TJQK])\\2([A2-9TJQK])\\3{2})";
        String threeOfAKind = "([A2-9TJQK])\\1{2}([A2-9TJQK])\\2([A2-9TJQK])";
        String twoPair = "(([A2-9TJQK])\\2([A2-9TJQK])\\3([A2-9TJQK])\\4)|(([A2-9TJQK])\\2([A2-9TJQK])\\3\\3([A2-9TJQK])\\4)|(([A2-9TJQK])\\2\\2([A2-9TJQK])\\3([A2-9TJQK])\\4)";
        String onePair = "([A2-9TJQK])\\1([A2-9TJQK])\\2([A2-9TJQK])\\3([A2-9TJQK])";
        String highCard = "[A2-9TJQK]{5}";

        if (hand.matches(fiveOfAKind)) {
            return "Five of a kind";
        } else if (hand.matches(fourOfAKind)) {
            return "Four of a kind";
        } else if (hand.matches(fullHouse)) {
            return "Full house";
        } else if (hand.matches(threeOfAKind)) {
            return "Three of a kind";
        } else if (hand.matches(twoPair)) {
            return "Two pair";
        } else if (hand.matches(onePair)) {
            return "One pair";
        } else if (hand.matches(highCard)) {
            return "High card";
        } else {
            throw new IllegalArgumentException("Invalid hand format: " + handData);
        }
    }


    }




