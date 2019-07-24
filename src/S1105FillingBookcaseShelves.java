public class S1105FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length+1];
        dp[books.length] = 0;
        for (int i = books.length-1; i >= 0; i--) {
            int min = books[i][1] + dp[i+1];
            int width = books[i][0], height = books[i][1];
            int j = i+1;
            while (j < books.length && width + books[j][0] <= shelf_width) {
                height = Math.max(height, books[j][1]);
                min = Math.min(min, height+dp[j+1]);
                width += books[j][0];
                j++;
            }
            min = Math.min(min, dp[j] + height);
            dp[i] = min;
        }
        return dp[0];
    }
}
