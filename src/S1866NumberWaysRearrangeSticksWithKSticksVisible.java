// https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/discuss/1223192/java-Dp-both-Recursive%2BMemo-and-Table-Dp
public class S1866NumberWaysRearrangeSticksWithKSticksVisible {
    public int rearrangeSticks(int n, int k) {
        int MOD =1000_000_007;
        int dp[][]=new int[n+1][k+1];
        dp[1][1]=1;
        for(int i=2;i<=n;i++){
            for(int p=1;p<i&&p<=k;p++)
                dp[i][p]=(int)((1L*dp[i-1][p-1]+1L*dp[i-1][p]*(i-1))%MOD);
            if(k>=i)
                dp[i][i]=1;
        }
        return dp[n][k];
    }
}
