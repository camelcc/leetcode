import java.util.HashMap;

public class S1531StringCompressionII {
    public int getLengthOfOptimalCompression(String s, int k) {
        Integer[][] dp = new Integer[s.length()][k+1];
        return dp(s, 0, k, dp);
    }

    private int dp(String s, int p, int k, Integer[][] dp) {
        if (p >= s.length()) {
            return 0;
        }
        if (dp[p][k] != null) {
            return dp[p][k];
        }
        int res = Integer.MAX_VALUE;
        if (k == 0) {
            dp[p][k] = len(s, p);
            return dp[p][k];
        }
        // delete
        res = Math.min(res, dp(s, p+1, k-1, dp));
        // keep
        char c = s.charAt(p);
        int r = p+1;
        int cnt = 1;
        int diff = 0;
        while (r < s.length() && diff < k) {
            char t = s.charAt(r);
            if (t == c) {
                cnt++;
            } else {
                int tl = 1 + len(cnt);
                res = Math.min(res, tl + dp(s, r, k-diff, dp));
                diff++;
            }
            r++;
        }
        if (r >= s.length()) {
            res = Math.min(res, 1 + len(cnt));
        } else {
            // k == 0
            while (r < s.length() && s.charAt(r) == c) {
                r++;
                cnt++;
            }
            res = Math.min(res, 1 + len(cnt) + dp(s, r, 0, dp));
        }
        dp[p][k] = res;
        return res;
    }

    private int len(int c) {
        if (c <= 1) {
            return 0;
        } else if (c < 10) {
            return 1;
        } else if (c < 100) {
            return 2;
        } else {
            return 3;
        }
    }

    private int len(String s, int p) {
        if (p >= s.length()) {
            return 0;
        }
        int res = 0;
        char c = s.charAt(p);
        int l = 1;
        for (int i = p+1; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == c) {
                l++;
            } else {
                res = res + 1 + len(l);
                c = t;
                l = 1;
            }
        }
        res = res + 1 + len(l);
        return res;
    }
}
