import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashMap<String, Boolean> adjDP = new HashMap<>();

        int res = 1;
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        HashSet<String> current = new HashSet<>();
        current.add(beginWord);
        while (!current.isEmpty()) {
            if (current.contains(endWord)) {
                return res;
            }

            HashSet<String> next = new HashSet<>();
            for (String c : current) {
                for (String w : wordList) {
                    if (!visited.contains(w) && isAdj(c, w, adjDP)) {
                        next.add(w);
                        visited.add(w);
                    }
                }
            }

            res++;
            current = next;
        }
        return 0;
    }

    private boolean isAdj(String a, String b, HashMap<String, Boolean> dp) {
        assert !a.isEmpty();
        assert a.length() == b.length();
        String key = a + ' ' + b;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;

                if (diff >= 2) {
                    return false;
                }
            }
        }
        boolean res = diff == 1;
        dp.put(key, res);
        dp.put(b + ' ' + a, res);
        return res;
    }
}
