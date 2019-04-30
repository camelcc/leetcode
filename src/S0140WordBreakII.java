import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0140WordBreakII {
    HashMap<String, List<String>> dp = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        if (s.isEmpty()) {
            dp.put(s, new ArrayList<>());
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (!s.startsWith(word)) {
                continue;
            }
            // no dup, equal find
            if (s.equals(word)) {
                res.add(word);
                continue;
            }

            // s.len > word.len
            String prefix = word + ' ';
            List<String> t = wordBreak(s.substring(word.length()), wordDict);
            for (String sub : t) {
                res.add(prefix + sub);
            }
        }
        dp.put(s, res);
        return res;
    }
}
