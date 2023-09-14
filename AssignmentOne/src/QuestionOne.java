import java.util.Arrays;

public class QuestionOne {
    public static void main(String[] args) {
        String text1 = "aaaaaa";
        String text2 = "aaasaasaa";
        int a = subsequenceLength(text1, text2);
        System.out.println(a);
    }

    public static int subsequenceLength(String text1, String text2) {
        String[][] graph = new String[text1.length() + 1][text2.length() + 1];
        for (String[] row: graph)
            Arrays.fill(row, "0");

        for (int i = 1; i <= text1.length(); i++) {
            graph[i][0] = text1.charAt(i - 1) + "";
        }
        for (int k = 1; k <= text2.length(); k++) {
            graph[0][k] = text2.charAt(k-1) + "";
        }

        int counter = 0;

        for (int k = 1; k <= text1.length(); k++) {
            for (int i = 1; i <= text2.length(); i++) {
                if (graph[0][i].equals(graph[k][0])) {
                    if (i != 1 && k != 1) {
                        counter = Integer.parseInt(graph[k-1][i-1]) + 1;
                    } else {
                        counter = 1;
                    }
                }
                int val = 0;
                if (k != 1) {
                    val = Integer.parseInt(graph[k-1][i]);
                }
                if (val > counter) {
                    counter = val;
                }
                graph[k][i] = counter + "";
            }
            counter = 0;
        }

        counter = 0;
        for (int i = 1; i <= text2.length(); i++) {
            for (int k = 1; k <= text1.length(); k++) {
                if (graph[0][i].equals(graph[k][0])) {
                    if (i != 1 && k != 1) {
                        counter = Integer.parseInt(graph[k-1][i-1]) + 1;
                    } else {
                        counter = 1;
                    }
                }
                int val = 0;
                if (i != 1) {
                    val = Integer.parseInt(graph[k][i-1]);
                }
                if (val > counter) {
                    counter = val;
                }
                graph[k][i] = counter + "";
            }
            counter = 0;
        }

        return Integer.parseInt(graph[text1.length()][text2.length()]);
    }
}
