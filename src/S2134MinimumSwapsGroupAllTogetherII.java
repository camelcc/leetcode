public class S2134MinimumSwapsGroupAllTogetherII {
    public int minSwaps(int[] nums) {
        int N = nums.length;

        int len = 0;
        for (int n : nums) {
            if (n == 1) {
                len++;
            }
        }

        int lo = 0, hi = len-1, cnt = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i%N] == 0) {
                cnt++;
            }
        }
        int res = cnt;

        while (lo < nums.length) {
            if (nums[lo] == 0) {
                cnt--;
            }
            lo++;
            hi++;
            if (nums[hi%N] == 0) {
                cnt++;
            }
            res = Math.min(res, cnt);
        }
        return res;
    }
}
