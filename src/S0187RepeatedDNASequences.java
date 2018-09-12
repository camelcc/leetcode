import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S0187RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res = new HashSet<>();
        if (s == null || s.isEmpty() || s.length() <= 10) {
            return new ArrayList<>(res);
        }

        HashSet<String> dnas = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String dna = s.substring(i, i + 10);
            if (dnas.contains(dna)) {
                res.add(dna);
            } else {
                dnas.add(dna);
            }
        }

        return new ArrayList<>(res);
    }
}
