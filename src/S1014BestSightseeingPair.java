public class S1014BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int res = Integer.MIN_VALUE, prev = A[0];
        for (int i = 1; i < A.length; i++) {
            int v = A[i]-i;
            res = Math.max(res, v+prev);
            prev = Math.max(prev, A[i]+i);
        }
        return res;
    }
}
