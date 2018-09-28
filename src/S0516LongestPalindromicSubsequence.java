import java.util.HashMap;
import java.util.HashSet;

public class S0516LongestPalindromicSubsequence {
    private HashMap<String, Integer> map = new HashMap<>();

    public int longestPalindromeSubseq(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.length() == 1) {
            return 1;
        }

        int res = 0;
        HashSet<Character> searched = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (searched.contains(c)) {
                continue;
            }

            int j = s.length()-1;
            for (j = s.length()-1; j > i; j--) {
                if (s.charAt(j) == c) {
                    break;
                }
            }
            int len = 0;
            if (j == i) {
                len = 1;
            } else {
                len = 2 + longestPalindromeSubseq(s.substring(i+1, j));
            }
            if (res < len) {
                res = len;
            }
            searched.add(c);
        }
        map.put(s, res);
        return res;
    }
}
