import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class S0451SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 1);
            } else {
                counts.put(c, counts.get(c)+1);
            }
        }

        List<Character> sorted = new ArrayList<>(counts.keySet());
        sorted.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts.get(o2) - counts.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (char c : sorted) {
            for (int i = 0; i < counts.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
