import java.util.HashMap;

public class S1641CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        HashMap<Integer, Integer>[] dp = new HashMap[5];
        for (int i = 0; i < 5; i++) {
            dp[i] = new HashMap<>();
        }
        return count(n, 0, dp);
    }

    private int count(int n, int i, HashMap<Integer, Integer>[] dp) {
        if (dp[i].containsKey(n)) {
            return dp[i].get(n);
        }
        if (i == 4) {
            dp[i].put(n, 1);
            return 1;
        }
        if (n <= 1) {
            dp[i].put(n, 5-i);
            return 5-i;
        }

        int res = count(n, i+1, dp);
        // chose i
        res += count(n-1, i, dp);
        dp[i].put(n, res);
        return res;
    }
}
