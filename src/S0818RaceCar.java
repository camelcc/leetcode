public class S0818RaceCar {
    public int racecar(int target) {
        int[] dp = new int[target+1];
        return racer(target, dp);
    }

    private int racer(int target, int[] dp) {
        if (dp[target] != 0) {
            return dp[target];
        }
        int v = target;
        int s = 0;
        while (v > 0) {
            s++;
            v = v >> 1;
        }
        // 2^s > t && 2^s-1 <= t
        int pos = 1 << s;
        if (pos-1 == target) {
            dp[target] = s;
            return s;
        }

        int res = racer(pos-1-target, dp)+s+1;
        for (int i = 0; i < s-1; i++) {
            int r = racer(target-((1<<(s-1))-1-((1<<i)-1)), dp);
            res = Math.min(res, r+s+i+1);
        }
        dp[target] = res;
        return res;
    }
}
