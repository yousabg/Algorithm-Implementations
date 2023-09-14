public class NumberFive {
    public static void main(String[] args) {
        String[] words = {"mile", "distance", "bat", "batman", "" ,"apple", "surtr", "ontology","onigiri","on"};
        radixSort(words);
        for (String word: words) {
            System.out.println(word);
        }

        String[] words2 = {""};
        radixSort(words2);
        for (String word: words2) {
            System.out.println(word);
        }
    }

    public static void radixSort(String[] s) {
        int maxLength = 0;
        int tempLength;
        for (String word: s) {
            tempLength = word.length();
            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < maxLength) {
                while (s[i].length() < maxLength) {
                    s[i] += " ";
                }
            }
        }

        int temp;
        int j;
        for (int i = maxLength-1; i >= 0; i--) {
            for (int p = 1; p < s.length; ++p) {
                String tempString = s[p];
                temp = s[p].charAt(i);
                for (j = p; j > 0 && temp < s[j-1].charAt(i); j--) {
                    s[j] = s[j-1];
                }
                s[j] = tempString;
            }
        }
    }
}
