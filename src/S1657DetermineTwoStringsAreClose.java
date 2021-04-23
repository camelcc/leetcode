import java.util.Arrays;

public class S1657DetermineTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        int[] cnt1 = new int[26];
        for (char c : word1.toCharArray()) {
            cnt1[c-'a']++;
        }
        int[] cnt2 = new int[26];
        for (char c : word2.toCharArray()) {
            cnt2[c-'a']++;
        }
        return close(cnt1, cnt2, 0);
    }

    private boolean close(int[] c1, int[] c2, int p) {
        if (p >= c1.length) {
            return true;
        }
        if (c1[p] == c2[p]) {
            return close(c1, c2, p+1);
        }
        // c1[p] != c2[p]
        if (c1[p] == 0 || c2[p] == 0) {
            return false;
        }
        for (int i = p+1; i < c1.length; i++) {
            if (c1[i] != c2[p]) {
                continue;
            }
            c1[i] = c1[p];
            if (close(c1, c2, p+1)) {
                return true;
            }
            c1[i] = c2[p];
        }
        return false;
    }
}
