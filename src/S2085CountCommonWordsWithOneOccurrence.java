import java.util.HashMap;
import java.util.HashSet;

public class S2085CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String w : words1) {
            cnt.put(w, cnt.getOrDefault(w, 0)+1);
        }
        HashMap<String, Integer> cnt2 = new HashMap<>();
        HashSet<String> res = new HashSet<>();
        for (String w : words2) {
            cnt2.put(w, cnt2.getOrDefault(w, 0)+1);
            if (cnt2.get(w) == 1 && cnt.getOrDefault(w, 0) == 1) {
                res.add(w);
            } else { // remove
                res.remove(w);
            }
        }
        return res.size();
    }
}
