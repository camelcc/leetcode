import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1268SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> candidates = new ArrayList<>();
        for (String p : products) {
            candidates.add(p);
        }
        Collections.sort(candidates);

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            List<String> next = new ArrayList<>();
            for (String candidate : candidates) {
                if (candidate.length() > i && candidate.charAt(i) == c) {
                    next.add(candidate);
                }
            }

            if (next.size() <= 3) {
                res.add(next);
            } else {
                List<String> rt = new ArrayList<>();
                for (int t = 0; t < 3; t++) {
                    rt.add(next.get(t));
                }
                res.add(rt);
            }

            candidates = next;
        }

        return res;
    }
}
