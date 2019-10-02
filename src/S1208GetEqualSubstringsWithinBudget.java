import java.util.Arrays;

public class S1208GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] preSum = new int[s.length()];
        int prev = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = Math.abs(s.charAt(i)-t.charAt(i));
            preSum[i] = prev + d;
            prev = preSum[i];
            if (prev <= maxCost) {
                res = Math.max(res, i+1);
            } else {
                int p = Arrays.binarySearch(preSum, 0, i, prev-maxCost);
                if (p < 0) {
                    p = -(p+1);
                }
                res = Math.max(res, i-p);
            }
        }
        return res;
    }
}
