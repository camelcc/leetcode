public class S1884EggDropWith2EggsNFloors {
    Integer[] dp = new Integer[1001];

    public int twoEggDrop(int n) {
        if (dp[n] != null) {
            return dp[n];
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = n;
        for (int i = 1; i <= n; i++) {
            int broken = i;
            int good = 1+twoEggDrop(n-i);
            res = Math.min(res, Math.max(broken, good));
        }
        dp[n] = res;
        return res;
    }
}
