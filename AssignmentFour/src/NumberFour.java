import java.util.HashMap;
import java.util.LinkedList;

public class NumberFour {
    public static void main(String[] args) {
        String s = "(])";
        System.out.println(isBalanced(s));
    }

    public static String isBalanced(String s) {
        char letter;
        LinkedList<Character> table = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);
            if (letter == '{' || letter == '[' || letter == '(') {
                table.add(0, letter); //add to start of list
            } else if (table.peek() == null) { //if table is empty, first char is not opening bracket, already an error
                return "NO";
            } else if (table.peek() == '{' && letter == '}') { //start removing char from the table when we find the corresponding bracket
                table.remove();
            } else if (table.peek() == '[' && letter == ']') {
                table.remove();
            } else if (table.peek() == '(' && letter == ')') {
                table.remove();
            } else { //if a random bracket appears, we return "NO"
                return "NO";
            }
        }
        if (table.peek() == null) { //when code is done, if table is empty, all brackets have found a partner. Otherwise, one didn't and we return no.
            return "YES";
        } else {
            return "NO";
        }
    }
}
