public class S0673NumberLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] len = new int[nums.length];
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];

            int l = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < v) {
                    l = Math.max(l, len[j]);
                }
            }
            if (l == 0) {
                len[i] = 1;
                cnt[i] = 1;
                continue;
            }

            int c = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < v && len[j] == l) {
                    c += cnt[j];
                }
            }
            len[i] = l+1;
            cnt[i] = c;
        }

        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            m = Math.max(m, len[i]);
        }
        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (len[i] == m) {
                res += cnt[i];
            }
        }
        return res;
    }
}
