import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberFive {
    public static void main(String[] args) {
        String DNA = "TTTTTTTTTTGGCGCG";
        String RNA = DNAtoRNA(DNA);
        System.out.println(RNA);
    }
    public static String DNAtoRNA(String DNA) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < DNA.length(); i++) {
            if (DNA.charAt(i) != 'T') {
                queue.add(DNA.charAt(i));
            } else {
                queue.add('U');
            }
        }
        DNA = "";
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            DNA += queue.remove();
        }
        return DNA;

    }
}
