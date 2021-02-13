import java.util.HashSet;

public class S1540CanConvertStringKMoves {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        int[] shift = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                int diff = ((t.charAt(i)-'a') + 26 - (s.charAt(i)-'a'))%26;
                shift[diff]++;
            }
        }
        int c = k/26;
        int r = k%26;
        for (int i = 0; i < 26; i++) {
            shift[i] -= c;
        }

        int m = -1;
        for (int i = 0; i < 26; i++) {
            if (shift[i] > 1) {
                return false;
            } else if (shift[i] == 1) {
                m = i;
            }
        }
        return r >= m;
    }
}
