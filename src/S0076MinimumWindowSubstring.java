import java.util.HashMap;
import java.util.HashSet;

public class S0076MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }
        // s.len >= t.len
        HashSet<Character> tc = new HashSet<>();
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            tc.add(c);
            cnt.put(c, cnt.getOrDefault(c, 0)+1);
        }

        String res = "";
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!tc.contains(c)) {
                end++;
                continue;
            }
            cnt.put(c, cnt.getOrDefault(c, 0)-1);
            boolean match = true;
            for (char key : cnt.keySet()) {
                if (cnt.get(key) > 0) {
                    match = false;
                    break;
                }
            }
            if (!match) {
                end++;
                continue;
            }
            // cnt[c] <= 0
            while (start < end) {
                char l = s.charAt(start);
                if (!tc.contains(l)) {
                    start++;
                } else {
                    if (cnt.get(l) == 0) {
                        break;
                    } else {
                        cnt.put(l, cnt.get(l)+1);
                        start++;
                    }
                }
            }

            String candidate = s.substring(start, end+1);
            if (res.isEmpty()) {
                res = candidate;
            } else if (res.length() > candidate.length()) {
                res = candidate;
            }

            cnt.put(s.charAt(start), 1);
            start++;
            end++;
        }
        return res;
    }
}
