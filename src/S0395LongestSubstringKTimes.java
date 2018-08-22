import java.util.ArrayList;
import java.util.List;

public class S0395LongestSubstringKTimes {
    public int longestSubstring(String s, int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }

        return candidates(s, k).length();
    }

    private String candidates(String s, int k) {
        assert k > 1;

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] >= k) {
                chars.add((char) ('a' + i));
            }
            counts[i] = 0;
        }
        if (chars.isEmpty()) {
            return "";
        }

        String candidate = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : '\n';
            if (chars.contains(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    String candi = sb.toString();
                    if (!isValid(candi, k)) {
                        candi = candidates(candi, k);
                    }

                    if (candi.length() > candidate.length()) {
                        candidate = candi;
                    }
                }

                sb = new StringBuilder();
            }
        }
        return candidate;
    }

    private boolean isValid(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                return false;
            }
        }
        return true;
    }
}
