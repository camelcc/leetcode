public class S1558MinimumNumbersFunctionCallsMakeTargetArray {
    public int minOperations(int[] nums) {
        int res = 0;
        int maxOp1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int t = 0;
            while (v > 1) {
                res += v%2;
                v = v >> 1;
                t++;
            }
            if (v != 0) {
                res++;
            }
            maxOp1 = Math.max(maxOp1, t);
        }
        res += maxOp1;
        return res;
    }
}
