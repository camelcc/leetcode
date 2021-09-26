import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/longest-subsequence-repeated-k-times/discuss/1471911/Java-BFS-O(n-*-2-8)-with-detailed-explanation
public class S2014LongestSubsequenceRepeatedkTimes {
    public String longestSubsequenceRepeatedK(String s, int k) {
        final int N = 26;
        String res = "";
        // q only stores valid subsequences, initialized with a empty string.
        Queue<String> q = new ArrayDeque<>();
        q.offer("");
        while (!q.isEmpty()) {
            int size = q.size();
            // BFS layer by layer, within each layer, the cur string has same length
            while (size-- > 0) {
                String cur = q.poll();
                for (int i = 0; i < N; i++) {
                    String next = cur + (char) ('a' + i);
                    if (isSub(s, next, k)) {
                        // always update res since we are looking for lexicographically largest.
                        res = next;
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }

    // check if sub * k is a subsequence of string s.
    // Time complexity - O(n)
    private boolean isSub(String s, String sub, int k) {
        int j = 0;
        int repeat = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
                if (j == sub.length()) {
                    repeat++;
                    if (repeat == k) {
                        return true;
                    }
                    j = 0;
                }
            }
        }
        return false;
    }
}
