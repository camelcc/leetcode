import java.util.Arrays;

public class S1278PalindromePartitioningIII {
    public int palindromePartition(String s, int k) {
        char[] ch = s.toCharArray();
        int len = s.length();

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int start = 0; start < len; start++) {
            for (int end = start; end < len; end++) {
                dp[start][end] = setup(ch, start, end, dp);
            }
        }

        int[][] prev = new int[len][len];
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                prev[r][c] = dp[r][c];
            }
        }

        for (int d = 2; d <= k; d++) {
            int[][] next = new int[len][len];

            for (int start = 0; start < len; start++) {
                for (int end = start+1; end < len; end++) {
                    int cost = Integer.MAX_VALUE;
                    for (int i = start; i <= end-d+1; i++) {
                        cost = Math.min(cost, dp[start][i] + prev[i+1][end]);
                    }
                    next[start][end] = cost;
                }
            }

            prev = next;
        }

        return prev[0][len-1];
    }

    private int setup(char[] ch, int start, int end, int[][] dp) {
        assert start <= end;
        if (start == end) {
            dp[start][end] = 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int mid = 0;
        if (start+1 < end-1) {
            mid = setup(ch, start+1, end-1, dp);
        }

        dp[start][end] = mid + (ch[start] == ch[end] ? 0 : 1);
        return dp[start][end];
    }
}
