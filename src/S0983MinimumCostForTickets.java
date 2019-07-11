public class S0983MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];
        dp[days.length-1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = days.length-2; i >= 0; i--) {
            // one day
            int res = costs[0]+dp[i+1];
            // 7 day
            int j = i+1;
            while (j < days.length && days[j]-days[i] < 7) {
                j++;
            }
            res = Math.min(res, costs[1]+dp[j]);
            // 30 day
            j = i+1;
            while (j < days.length && days[j]-days[i] < 30) {
                j++;
            }
            res = Math.min(res, costs[2]+dp[j]);
            dp[i] = res;
        }
        return dp[0];
    }
}
