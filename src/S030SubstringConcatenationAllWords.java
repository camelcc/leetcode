import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S030SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) {
            return res;
        }
        int LEN = words[0].length();
        HashMap<String, Integer> MAP = new HashMap<>();
        for (String w : words) {
            MAP.put(w, MAP.getOrDefault(w, 0) + 1);
        }

        int start = 0;
        while (start < s.length()) {
            HashMap<String, Integer> ws = new HashMap<>(MAP);
            boolean valid = true;
            int i = start;
            while (!ws.isEmpty()) {
                if (i + LEN > s.length()) {
                    valid = false;
                    break;
                }

                String w = s.substring(i, i + LEN);
                if (!ws.containsKey(w)) {
                    valid = false;
                    break;
                } else {
                    ws.put(w, ws.get(w) - 1);
                    if (ws.get(w) == 0) {
                        ws.remove(w);
                    }
                }

                i += LEN;
            }
            if (!valid) {
                start++;
                continue;
            }

            res.add(start);
            start++;
        }

        return res;
    }
}
