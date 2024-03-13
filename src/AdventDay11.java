import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

public class AdventDay11 {


    public static void main(String[] args) {
        String filePath = "C:\\Users\\michaelm\\OneDrive - NominetUK.onmicrosoft.com\\Documents\\adventofcode\\" +
                "testinputday11.txt";

        try {
            char[][] expandedArray = expandUniverse(filePath);
            int sumOfShortestPaths = calculateSumOfShortestPaths(expandedArray);
            System.out.println("Sum of shortest paths: " + sumOfShortestPaths);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char[][] expandUniverse(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Initialize lists to store rows and columns
        StringBuilder[] rowsList = new StringBuilder[100];  // Assuming a maximum of 100 rows
        StringBuilder[] colsList = new StringBuilder[100];  // Assuming a maximum of 100 columns

        // Populate the lists
        String line;
        int rowIndex = 0;
        while ((line = reader.readLine()) != null) {
            if (containsGalaxy(line)) {
                if (rowsList[rowIndex] == null) {
                    rowsList[rowIndex] = new StringBuilder(line);
                } else {
                    rowsList[rowIndex].append(line);
                }

                // Populate the columns list
                for (int colIndex = 0; colIndex < line.length(); colIndex++) {
                    if (colsList[colIndex] == null) {
                        colsList[colIndex] = new StringBuilder().append(line.charAt(colIndex));
                    } else {
                        colsList[colIndex].append(line.charAt(colIndex));
                    }
                }

                rowIndex++;
            }
        }
        reader.close();

        // Initialize the 2D array
        char[][] array = new char[rowIndex][];
        for (int i = 0; i < rowIndex; i++) {
            array[i] = rowsList[i].toString().toCharArray();
        }

        // Add rows with '...' for missing rows
        for (int i = rowIndex; i < rowsList.length && rowsList[i] != null; i++) {
            array[i] = rowsList[i].toString().toCharArray();
        }

        // Add columns with '...' for missing columns
        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length; j < colsList.length && colsList[j] != null; j++) {
                String columnStr = colsList[j].toString();
                if (columnStr.length() > i) {
                    array[i] = (new StringBuilder(array[i].length > 0 ? new String(array[i]) : "")
                            + columnStr.charAt(i)).toCharArray();
                } else {
                    array[i] = (new StringBuilder(array[i].length > 0 ? new String(array[i]) : "")
                            + '.').toCharArray();
                }
            }
        }

        return array;
    }

    public static int calculateSumOfShortestPaths(char[][] expandedArray) {
        // Implement the calculation of the sum of shortest paths here
        // Use your preferred algorithm to find the shortest paths between galaxies
        // Return the sum
        return 0;
    }

    public static boolean containsGalaxy(String line) {
        return line.contains("#");
    }
}