public class S2140SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        return points(questions, 0, dp);
    }

    private long points(int[][] questions, int i, long[] dp) {
        if (i >= questions.length) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        long res = points(questions, i+1, dp);
        long point = questions[i][0];
        point += points(questions, i+questions[i][1]+1, dp);
        res = Math.max(res, point);
        dp[i] = res;
        return res;
    }
}
