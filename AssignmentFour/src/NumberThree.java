import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class NumberThree {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(5);
        deque.add(6);
        deque.add(1);
        deque.add(2);
        deque.add(1);
        System.out.println(findIndex(deque,1));
    }
    public static int findIndex(Deque<Integer> q, int y) {
        int first = q.getFirst();
        int last = q.getLast();
        int iterations = q.size()/2;
        int count = 0;
        int countStart = 0;
        int countEnd = q.size()-1;
        while (count<iterations) {
            if (first == y) {
                return countStart;
            } else if (last == y) {
                return countEnd;
            }
            q.removeFirst();
            q.removeLast();
            first = q.getFirst();
            last = q.getLast();
            countStart++;
            countEnd--;
            count++;
        }
        return -1;
    }
}
