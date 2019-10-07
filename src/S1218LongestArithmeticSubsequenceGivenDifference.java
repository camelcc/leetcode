import java.util.HashMap;

public class S1218LongestArithmeticSubsequenceGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        HashMap<Integer, Integer> subsequence = new HashMap<>();
        for (int i = arr.length-1; i >= 0; i--) {
            int v = arr[i];
            int len = 1;
            if (subsequence.containsKey(v)) {
                len = subsequence.get(v);
            }
            subsequence.put(v-difference, len+1);
            res = Math.max(res, len);
        }
        return res;
    }
}
