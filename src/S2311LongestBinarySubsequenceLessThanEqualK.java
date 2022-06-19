import java.util.Arrays;
import java.util.HashMap;

public class S2311LongestBinarySubsequenceLessThanEqualK {
    public int longestSubsequence(String s, int k) {
        int[] smallest = new int[s.length()+1];
        Arrays.fill(smallest, Integer.MAX_VALUE);
        smallest[0] = 0;

        // dp[len] = v smallest value for len
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) == '1' ? 1 : 0;
            int[] next = Arrays.copyOf(smallest, smallest.length);
            for (int len = 1; len < smallest.length && smallest[len-1] != Integer.MAX_VALUE; len++) {
                long nv = smallest[len-1]*2L+v;
                if (nv <= k && nv <= smallest[len]) {
                    next[len] = (int)nv;
                }
            }
            smallest = next;
        }

        for (int i = smallest.length-1; i >= 0; i--) {
            if (smallest[i] <= k) {
                return i;
            }
        }
        return 0;
    }
}
