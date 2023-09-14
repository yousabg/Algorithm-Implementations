import java.lang.reflect.Field;
import java.util.ArrayList;

public class AList<T> {
    int size;
    Object[] arr;

    public AList() {
        size = 0;
        arr = new Object[size];
    }

    public void listAdd(T p) {
        size++;
        if (size == 1) {
            arr = new Object[size];
            arr[size - 1] = p;
        } else {
            Object[] temp = new Object[size];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            temp[size - 1] = p;
            arr = temp;
        }
    }

    public void listRemove(int pos) {
        if (pos > 0 && pos < size) {
            size--;
            Object[] temp = new Object[size];
            for (int i = 0; i < size; i++) {
                if (i < pos) {
                    temp[i] = arr[i];
                } else {
                    temp[i] = arr[i + 1];
                }
            }
            arr = temp;
        }
    }

    public String toString() {
        String s = "Empty List";
        for (int i = 0; i < size; i++) {
            s = "{";
            for (Field field : arr[i].getClass().getDeclaredFields()) {
                try {
                    Object obj = arr[i];
                    s += field.getName() + ":" + field.get(arr[i]) + ", ";
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            s = s.substring(0, s.length() - 2);
            s += "}\n";

        }
        return s;
    }
}
