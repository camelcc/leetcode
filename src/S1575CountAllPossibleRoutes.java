public class S1575CountAllPossibleRoutes {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        Integer[][][] dp = new Integer[locations.length][locations.length][fuel+1];
        return routes(locations, start, finish, fuel, dp);
    }

    private int routes(int[] locations, int start, int finish, int fuel, Integer[][][] dp) {
        if (dp[start][finish][fuel] != null) {
            return dp[start][finish][fuel];
        }
        long res = start == finish ? 1 : 0;
        if (fuel == 0) {
            dp[start][finish][fuel] = (int)res;
            return (int)res;
        }
        for (int i = 0; i < locations.length; i++) {
            if (i == start) {
                continue;
            }
            int c = Math.abs(locations[start]-locations[i]);
            if (c > fuel) {
                continue;
            }
            res += routes(locations, i, finish, fuel-c, dp);
        }
        int MOD = (int)(Math.pow(10, 9)+7);
        res = res % MOD;
        dp[start][finish][fuel] = (int)res;
        return (int)res;
    }
}
