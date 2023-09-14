import java.lang.reflect.Field;

public class SLList<T> {
    SLNode head;
    int size = 0;


    public SLList() {
        head = null;
    }

    public void listAdd(T p) {
        size++;
        if (head == null) {
            head = new SLNode(p);
        } else {
            SLNode nextNode = head;
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = new SLNode(p);
        }
    }

    public void listRemove(int pos) {
        if (pos > size || pos < 0) {
            return;
        }
        SLNode index = head;
        for (int i = 0; i < pos-1; i++) {
            index = index.next;
            if (index.next.next == null) {
                index.next.data = null;
                index.next = null;
                return;
            }
        }
        index = index.next;
        while (index.next != null) {
            index.data = index.next.data;
            if (index.next.next == null) {
                index.next.data = null;
                index.next = null;
            } else {
                index = index.next;
            }
        }
    }

    public String toString() {
        SLNode index = head;
        String s = "";
        if (index == null) {
            s = "Empty List";
        }
        while (index != null) {
            s += "{";
            if (index.data != null) {
                for (Field field: index.data.getClass().getDeclaredFields()) {
                    try {
                        Object obj = index.data;
                        s += field.getName() + ":" + field.get(index.data) + ", ";
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                s = s.substring(0, s.length() - 2);
                s += "}\n";
            }
            index = index.next;
        }
        return s;
    }
}
