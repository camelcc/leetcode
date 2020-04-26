public class S1423MaximumPointsYouCanObtainCards {
    public int maxScore(int[] cardPoints, int k) {
        int N = cardPoints.length;
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += cardPoints[N-1-i];
        }

        int sum = res;
        for (int i = N-k+1; i <= N; i++) {
            sum = sum-cardPoints[i-1]+cardPoints[(i+k-1)%N];
            res = Math.max(res, sum);
        }
        return res;
    }
}
