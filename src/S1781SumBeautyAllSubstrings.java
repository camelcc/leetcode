public class S1781SumBeautyAllSubstrings {
    public int beautySum(String s) {
        int res = 0;
        int[][] cnt = new int[s.length()][26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int r = 0; r < i; r++) {
                cnt[r][c-'a']++;
                res += sum(cnt[r]);
            }
            cnt[i][c-'a']++;
        }
        return res;
    }

    private int sum(int[] cnt) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int c : cnt) {
            if (c > 0) {
                min = Math.min(min, c);
                max = Math.max(max, c);
            }
        }
        return max-min;
    }
}
