import java.util.Arrays;
import java.util.Comparator;

public class S1048LongestStringChain {
    public int longestStrChain(String[] words) {
        int res = 0;
        int[] dp = new int[words.length];
        Arrays.fill(dp, -1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = words.length-1; i >= 0; i--) {
            dp[i] = 1;
            int len = words[i].length();
            for (int j = i+1; j < words.length && words[j].length() <= len+1; j++) {
                if (words[j].length() != len+1 || !isPredecessor(words[i], words[j])) {
                    continue;
                }
                dp[i] = Math.max(dp[i], 1+dp[j]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private boolean isPredecessor(String parent, String child) {
        assert parent.length()+1 == child.length();
        boolean added = false;
        int[] parentCnt = new int[26];
        for (char c : parent.toCharArray()) {
            parentCnt[c-'a']++;
        }
        for (char c : child.toCharArray()) {
            if (parentCnt[c-'a'] > 0) {
                parentCnt[c-'a']--;
            } else {
                if (added) {
                    return false;
                }
                added = true;
            }
        }
        return true;
    }
}
