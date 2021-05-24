public class S1744CanYouEatYourFavoriteCandyYourFavoriteDay {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length+1];
        for (int i = 0; i < candiesCount.length; i++) {
            sum[i+1] = sum[i] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int type = query[0];
            long day = query[1], cap = query[2];
            res[i] = !((day*cap+cap) <= sum[type] || day >= sum[type+1]);
        }
        return res;
    }
}
