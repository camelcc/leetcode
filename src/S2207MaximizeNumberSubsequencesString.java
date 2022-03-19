// https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/discuss/1863900/JavaC%2B%2BPython-Straight-Forward-Solution
public class S2207MaximizeNumberSubsequencesString {
    public long maximumSubsequenceCount(String text, String pattern) {
        long res = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == pattern.charAt(1)) {
                res += cnt1;
                cnt2++;
            }
            if (text.charAt(i) == pattern.charAt(0)) {
                cnt1++;
            }
        }
        return res + Math.max(cnt1, cnt2);
    }
}
