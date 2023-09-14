import java.lang.reflect.Field;

public class DLList<T> {
    DLNode head;
    int size = 0;

    public DLList() {
        head = null;
    }

    public void listAdd(T p) {
        size++;
        if (head == null) {
            head = new DLNode(p);
        } else {
            DLNode nextNode = head;
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = new DLNode(p);
            nextNode.next.previous = nextNode;
        }
    }

    public void listRemove(int pos) {
        if (pos > size || pos < 0) {
            return;
        }
        DLNode index = head;
        for (int i = 0; i < pos; i++) {
            index = index.next;
            if (index.next == null) {
                index.data = null;
                index.previous.next = null;
                index.previous = null;
                return;
            }
        }
        while (index != null) {
            if (index.next == null) {
                index.data = null;
                index.previous.next = null;
                index.previous = null;
            } else {
                index.data = index.next.data;
            }
            index = index.next;
        }
    }

    public String toString() {
        DLNode index = head;
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
