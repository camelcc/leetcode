import java.util.Arrays;

// https://leetcode.com/problems/make-the-xor-of-all-segments-equal-to-zero/discuss/1100093/Java-DP-or-Explanation-with-code
public class S1787MakeXORAllSegmentsEqualZero {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int[][] freq = new int[k][1024];
        //freq[i][j] : freq of j occuring in indeces : m*k+i, we only bother abt 1st k elements bcz remaining array is determined by this
        for (int i = 0; i < n; i++) {
            freq[i%k][nums[i]]++;
        }
        int[][] dp = new int[k+1][1024];
        //dp[i][j] : min no of changes req to make xor of 1st i elems = j
        for ( int[] d : dp) {
            //by making array to all zeroes we get desired o/p so atmost n changes are req
            Arrays.fill(d,n);
        }
        //base case: min changes to make xor of 0 elems to 0 is 0
        dp[0][0]=0;
        //min changes done till now to obtain any xor value
        int bestUptoLast = 0;
        for (int i = 0; i < k; i++) {
            int bestToi = Integer.MAX_VALUE;

            // no of diff values of 'm' poss in array for i
            int cntOfPos = n/k+(n%k>i?1:0);
            for(int j=0;j<1024;j++){
                //changing ith value to the values tht already present in one of m*k+i indeces
                for(int z=i;z<n;z+=k){
                    dp[i+1][j]=Math.min(dp[i+1][j], dp[i][j^nums[z]]+cntOfPos-freq[i][nums[z]]);
                }
                //changing i to new value other than any value that is present in i+m*k indeces
                /* we used bestUptoLast bcz we can achieve any value from any value by xoring it with
				any-one number, so it becoms : bestUptoLast+cntOfPos*1 (since the new value is not present
				in any index, it costs cntOfPos to change all its indeces) */
                dp[i+1][j]=Math.min(dp[i+1][j],bestUptoLast+cntOfPos);
                bestToi=Math.min(bestToi,dp[i+1][j]);
            }
            bestUptoLast=bestToi;
        }
        //no of min changes req to xor first k elem to 0
        return dp[k][0];
    }
}
