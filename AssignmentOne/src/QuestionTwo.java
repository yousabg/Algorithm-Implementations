import java.util.ArrayList;
import java.util.Arrays;

public class QuestionTwo {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaaaaa","aaasaasaa"));
    }
    public static String longestSubstring(String text1, String text2) {
        String longerWord = "";
        String shorterWord = "";
        if (text1.length() > text2.length()) {
            longerWord = text1;
            shorterWord = text2;
        } else {
            longerWord = text2;
            shorterWord = text1;
        }

        String[][] lwgraph = new String[longerWord.length() + 1][longerWord.length() + 1];
        String[][] swgraph = new String[shorterWord.length() + 1][shorterWord.length() + 1];

        for (String[] row: lwgraph)
            Arrays.fill(row, "");

        for (String[] row: swgraph)
            Arrays.fill(row, "");

        for (int i = 1; i <= longerWord.length(); i++) {
            lwgraph[i][0] = longerWord.charAt(i - 1) + "";
            lwgraph[0][i] = longerWord.charAt(i-1) + "";
        }

        for (int i = 1; i <= shorterWord.length(); i++) {
            swgraph[i][0] = shorterWord.charAt(i - 1) + "";
            swgraph[0][i] = shorterWord.charAt(i-1) + "";
        }

        ArrayList<String> wordOneSubStrings = new ArrayList<>();
        ArrayList<String> wordTwoSubStrings = new ArrayList<>();

        int row = 1;
        for (int i = 1; i <= longerWord.length(); i++) {
            for (int k = row; k <= longerWord.length(); k++) {
                if (lwgraph[k][0].equals(lwgraph[0][i])) {
                    lwgraph[k][i] = lwgraph[0][i];
                    wordOneSubStrings.add(lwgraph[k][i]);
                } else {
                    lwgraph[k][i] = lwgraph[k-1][i] + lwgraph[k][0];
                    wordOneSubStrings.add(lwgraph[k][i]);
                }
            }
            row++;
        }
        row = 1;
        for (int i = 1; i <= shorterWord.length(); i++) {
            for (int k = row; k <= shorterWord.length(); k++) {
                if (swgraph[k][0].equals(swgraph[0][i])) {
                    swgraph[k][i] = swgraph[0][i];
                    wordTwoSubStrings.add(swgraph[k][i]);
                } else {
                    swgraph[k][i] = swgraph[k-1][i] + swgraph[k][0];
                    wordTwoSubStrings.add(swgraph[k][i]);
                }
            }
            row++;
        }

        String longerWordToReturn = "";
        for (String substring: wordOneSubStrings) {
            for (String substring2: wordTwoSubStrings) {
                if (substring.equals(substring2)) {
                    if (longerWordToReturn.length() < substring.length()) {
                        longerWordToReturn = substring;
                    }
                }
            }
        }

        return longerWordToReturn;

    }
}
