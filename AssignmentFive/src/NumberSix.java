import java.util.HashMap;

public class NumberSix {
    public static void main(String[] args) {
        System.out.println(isSubInteger(new int[]{32, 2}, new int[]{1, 2, 3, 52, 32, 54}));
        System.out.println(isSubInteger(new int[]{89,32,54,	32,	3}, new int[]{54, 32, 99}));
        System.out.println(isSubInteger(new int[]{0, 67}, new int[]{100,5,66,2,32, 90}));
        System.out.println(isSubInteger(new int[]{}, new int[]{54,32,99}));


    }

    public static String isSubInteger(int[] S, int[] T) {
        if (T.length == 0 || S.length > T.length) {
            return "NO";
        } else if (S.length == 0) {
            return "YES";
        }
        HashMap<Integer, Integer> table = new HashMap<>();
        int key;
        int i;
        int oldKey;
        for (int value : T) {
            key = value % T.length;
            if (table.get(key) == null) {
                table.put(key, value);
            } else {
                i = 1;
                oldKey = key;
                while (table.get(key) != null) {
                    key = (oldKey + i * (7 - (value % 7))) % T.length;
                    i++;
                }
                table.put(key, value);
            }
        }

        for (int value : S) {
            if (!table.containsValue(value)) {
                return "NO";
            }
        }
        return "YES";
    }
}
