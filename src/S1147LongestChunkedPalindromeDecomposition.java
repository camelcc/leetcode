public class S1147LongestChunkedPalindromeDecomposition {
    public int longestDecomposition(String text) {
        return palindrome(text, 0, text.length()-1, new int[text.length()][text.length()]);
    }

    private int palindrome(String text, int start, int end, int[][] dp) {
        assert start <= end;
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        if (start == end) {
            dp[start][end] = 1;
            return 1;
        }
        StringBuilder left = new StringBuilder(), right = new StringBuilder();
        int lo = start, hi = end;
        int res = 1;
        while (lo < hi) {
            left.append(text.charAt(lo++));
            right.insert(0, text.charAt(hi--));
            if (left.toString().equals(right.toString())) {
                res = Math.max(res, 2 + (lo <= hi ? palindrome(text, lo, hi, dp) : 0));
            }
        }
        dp[start][end] = res;
        return res;
    }
}
