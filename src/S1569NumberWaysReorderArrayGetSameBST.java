import java.util.Arrays;

public class S1569NumberWaysReorderArrayGetSameBST {
    public int numOfWays(int[] nums) {
        int length = nums.length, MOD = 1000000007;
        long[][] DP = new long[length + 1][length + 1];
        for(int j = 0; j <= length; j++) {
            DP[0][j] = 1;
        }
        for(int i = 0; i <= length; i++) {
            DP[i][0] = 1;
        }
        for(int i = 1; i <= length; i++) {
            for(int j = 1; j <= length; j++) {
                DP[i][j] = ((DP[i][j - 1] + DP[i - 1][j]) % MOD);
            }
        }
        return ((int) getNumberOfWays(nums, DP) - 1);
    }

    private long getNumberOfWays(int[] nums, long[][] DP) {
        int length = nums.length, m = 0, n = 0, MOD = 1000000007;
        if(length == 0) {
            return 1;
        }
        for(int i = 2; i <= length; i++) {
            if(nums[i - 1] < nums[0]) {
                m++;
            } else {
                n++;
            }
        }
        int[] leftNodes = new int[m];
        int[] rightNodes = new int[n];
        m = 0;
        n = 0;
        for(int i = 2; i <= length; i++) {
            if(nums[i - 1] < nums[0]) {
                leftNodes[m++] = nums[i - 1];
            } else {
                rightNodes[n++] = nums[i - 1];
            }
        }
        return (((DP[m][n] * getNumberOfWays(leftNodes, DP) % MOD) * getNumberOfWays(rightNodes, DP)) % MOD);
    }
}
