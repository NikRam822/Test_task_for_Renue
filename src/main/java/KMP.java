import FilesHandlers.FileReader;

import java.util.TreeSet;

/**
 * A class that implements the logic of the Knuth-Morris-Pratt algorithm for finding an image in a given string
 */
public class KMP {

    public KMP(int numberOfColumn) {
        this.numberOfColumn = numberOfColumn;
    }

    /**
     * Number of column of data
     */
    private final int numberOfColumn;


    /**
     * Method for displaying information about the algorithm's work
     */
    public void viewDataOfAlgorithm() {
        TreeSet<String> resultLines = new TreeSet<>();

        FileReader fileReader = new FileReader();
        String userInput = fileReader.readFromConsole();
        long start = System.currentTimeMillis();


        int[] prefixArr = generatePrefix(userInput);

        String line = fileReader.getLine();

        while (line != null) {
            String columnValue = line.split(",")[numberOfColumn - 1];
            if (searchMatch(columnValue, userInput, prefixArr)) {
                String resultLine = line.substring(line.indexOf(",") + 1);
                resultLines.add(resultLine);
            }
            line = fileReader.getLine();
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        viewResultDataAndCountOfStrings(resultLines);
        System.out.println("Время, затраченное на поиск: " + timeElapsed + "мс");
    }

    /**
     * Method for displaying the found strings and their number
     *
     * @param resultLines Found strings
     */
    private void viewResultDataAndCountOfStrings(TreeSet<String> resultLines) {
        StringBuffer resultData = new StringBuffer();

        for (String line : resultLines) {
            resultData.append(line).append("\n");
        }
        System.out.println(resultData);
        System.out.print("Количество найденных строк: " + resultLines.size() + "; ");

    }


    /**
     * Method for finding a match between an Image and a string from a file
     *
     * @param lineFromFile line from file
     * @param image        line of User input
     * @param prefix       array of prefix
     * @return Found a match
     */
    private boolean searchMatch(String lineFromFile, String image, int[] prefix) {
        int linePointer = 0;
        int userPointer = 0;

        while (linePointer != lineFromFile.length()) {
            char lineWord = lineFromFile.charAt(linePointer);
            char userWord = image.charAt(userPointer);

            if (lineWord == userWord) {
                if (userPointer == image.length() - 1) return true;
                linePointer++;
                userPointer++;
            } else {
                if (userPointer == 0) linePointer++;
                else {
                    userPointer = prefix[userPointer - 1];
                }
            }
        }

        return false;
    }

    /**
     * Method for creating an array of prefixes
     *
     * @param image line of User input
     * @return array of prefixes
     */
    private int[] generatePrefix(String image) {
        int[] prefixArr = new int[image.length()];

        int j = 0;
        int i = 1;
        while (i != image.length()) {
            char suffix = image.charAt(i);
            char prefix = image.charAt(j);

            if (prefix != suffix) {
                if (j == 0) {
                    prefixArr[i] = 0;
                    i++;
                } else {
                    j = prefixArr[j - 1];
                }
            } else {
                prefixArr[i] = j + 1;
                j++;
                i++;
            }
        }

        return prefixArr;
    }

}
