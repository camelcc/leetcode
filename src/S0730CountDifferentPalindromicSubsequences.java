public class S0730CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String S) {
        int[][] dp = new int[S.length()][S.length()];
        return count(S, 0, S.length()-1, dp);
    }

    private int count(String s, int left, int right, int[][] dp) {
        assert left <= right;
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = 1;
            return 1;
        }
        int MOD = (int)Math.pow(10, 9)+7;
        long cnt = 0;
        char[] CHARS = new char[]{'a', 'b', 'c', 'd'};
        for (char c : CHARS) {
            int l = left;
            while (l <= right && s.charAt(l) != c) {
                l++;
            }
            if (l <= right) {
                cnt++;
            }
            int r = right;
            while (r >= left && s.charAt(r) != c) {
                r--;
            }
            if (l >= r) {
                continue;
            }
            cnt++;
            if (l+1 < r) {
                cnt += count(s, l+1, r-1, dp);
                cnt = cnt % MOD;
            }
        }
        cnt = cnt%MOD;
        dp[left][right] = (int)cnt;
        return (int)cnt;
    }
}
