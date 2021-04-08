import java.util.Arrays;

public class S1626BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        // sort player accoring to ages then accoring to score in increasing order.
        Arrays.sort(arr,(a,b)->(a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        int[] dp = new int[n]; // dp[i] = {max score upto index i}
        int max = 0;
        for(int i=0;i<n;i++){
            dp[i] = arr[i][1];
            for(int j=0;j<i;j++){
                if(arr[j][1] <= arr[i][1]){
                    dp[i] = Math.max(dp[i],arr[i][1] + dp[j]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
