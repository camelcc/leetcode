public class S1639NumberWaysFormTargetStringGivenDictionary {
    public int numWays(String[] words, String target) {
        int len = words[0].length();
        Integer[][] dp = new Integer[len][target.length()];

        return ways(words, target, 0, 0, dp);
    }

    private int ways(String[] words, String target, int wi, int ti, Integer[][] dp) {
        if (wi >= words[0].length() || ti >= target.length()) {
            return 0;
        }
        if (words[0].length()-wi < target.length()-ti) {
            return 0;
        }
        if (dp[wi][ti] != null) {
            return dp[wi][ti];
        }

        int res = ways(words, target, wi+1, ti, dp);

        char c = target.charAt(ti);
        int cnt = 0;
        for (String w : words) {
            if (w.charAt(wi) == c) {
                cnt++;
            }
        }
        if (ti == target.length()-1) {
            res += cnt;
            dp[wi][ti] = res;
            return res;
        }
        int MOD = 1_000_000_007;
        if (cnt != 0) {
            long t = (long)cnt * ways(words, target, wi+1, ti+1, dp);
            res = (int)((t + res)%MOD);
        }
        dp[wi][ti] = res;
        return res;
    }
}
