import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NumberSix {
    public static void main(String[] args) {
        System.out.println(RNAtoProtein("UGGGCAUAUU"));

    }
    public static String RNAtoProtein(String RNA) {
        Queue<String> queue = new LinkedList<>();
        HashMap<String, String> wheel = new HashMap<>();
        wheel.put("UUU", "F");
        wheel.put("UCU", "S");
        wheel.put("UAU", "Y");
        wheel.put("UGU", "C");
        wheel.put("UUC", "F");
        wheel.put("UCC", "S");
        wheel.put("UAC", "Y");
        wheel.put("UGC", "C");
        wheel.put("UUA", "L");
        wheel.put("UCA", "S");
        wheel.put("UAA", ".");
        wheel.put("UGA", ".");
        wheel.put("UUG", "L");
        wheel.put("UCG", "S");
        wheel.put("UAG", ".");
        wheel.put("UGG", "W");
        wheel.put("CUU", "L");
        wheel.put("CCU", "P");
        wheel.put("CAU", "H");
        wheel.put("CGU", "R");
        wheel.put("CUC", "L");
        wheel.put("CCC", "P");
        wheel.put("CAC", "H");
        wheel.put("CGC", "R");
        wheel.put("CUA", "L");
        wheel.put("CCA", "P");
        wheel.put("CAA", "Q");
        wheel.put("CGA", "R");
        wheel.put("CUG", "L");
        wheel.put("CCG", "P");
        wheel.put("CAG", "Q");
        wheel.put("CGG", "R");
        wheel.put("AUU", "I");
        wheel.put("ACU", "T");
        wheel.put("AAU", "N");
        wheel.put("AGU", "S");
        wheel.put("AUC", "I");
        wheel.put("ACC", "T");
        wheel.put("AAC", "N");
        wheel.put("AGC", "S");
        wheel.put("AUA", "I");
        wheel.put("ACA", "T");
        wheel.put("AAA", "K");
        wheel.put("AGA", "R");
        wheel.put("AUG", "M");
        wheel.put("ACG", "T");
        wheel.put("AAG", "K");
        wheel.put("AGG", "R");
        wheel.put("GUU", "V");
        wheel.put("GCU", "A");
        wheel.put("GAU", "D");
        wheel.put("GGU", "G");
        wheel.put("GUC", "V");
        wheel.put("GCC", "A");
        wheel.put("GAC", "D");
        wheel.put("GGC", "G");
        wheel.put("GUA", "V");
        wheel.put("GCA", "A");
        wheel.put("GAA", "E");
        wheel.put("GGA", "G");
        wheel.put("GUG", "V");
        wheel.put("GCG", "A");
        wheel.put("GAG", "E");
        wheel.put("GGG", "G");

        int count = 0;
        String codon = "";
        for (int i = 0; i < RNA.length(); i++) {
            if (count == 3) {
                queue.add(codon);
                codon = "";
                count = 0;
            }
            codon += RNA.charAt(i);
            count++;
        }
        if (codon != "") {
            queue.add(codon);
        }

        int size = queue.size();
        String protein = "";
        for(String codons: queue) {
            if (wheel.get(codons) != null) {
                protein += wheel.get(codons);
            } else {
                protein += ".";
            }
        }
        return protein;
    }
}
