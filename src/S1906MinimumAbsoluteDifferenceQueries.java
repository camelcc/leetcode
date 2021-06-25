import java.util.HashMap;
import java.util.HashSet;

public class S1906MinimumAbsoluteDifferenceQueries {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] cnt = new int[nums.length+1][101];
        for (int i = 0; i < nums.length; i++) {
            for (int v = 1; v <= 100; v++) {
                cnt[i+1][v] = cnt[i][v] + (nums[i] == v ? 1 : 0);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1], diff = 101;
            // cnt[r+1]-cnt[l]
            for (int v = 1; v < 100; v++) {
                  if (cnt[r+1][v]-cnt[l][v] <= 0) {
                      continue;
                  }
                  for (int j = v+1; j <= Math.min(100, v+diff); j++) {
                      if (cnt[r+1][j]-cnt[l][j] <= 0) {
                          continue;
                      }
                      diff = Math.min(diff, j-v);
                  }
            }
            res[i] = diff == 101 ? -1 : diff;
        }
        return res;
    }
}
