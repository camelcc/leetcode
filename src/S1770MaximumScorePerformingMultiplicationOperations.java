import java.util.LinkedList;

public class S1770MaximumScorePerformingMultiplicationOperations {
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] post = new Integer[multipliers.length][multipliers.length];
        return dfs(nums, multipliers, 0, 0, post);
    }

    private int dfs(int[] nums, int[] multipliers, int l, int m, Integer[][] post) {
        int r = l+nums.length-1-m;

        if (post[l][m] != null) {
            return post[l][m];
        }
        if (m == multipliers.length-1) {
            post[l][m] = Math.max(nums[l]*multipliers[m], nums[r]*multipliers[m]);
            return post[l][m];
        }
        int left = dfs(nums, multipliers, l+1, m+1, post);
        int right = dfs(nums, multipliers, l, m+1, post);
        post[l][m] = Math.max(left+nums[l]*multipliers[m], right+nums[r]*multipliers[m]);
        return post[l][m];
    }
}
