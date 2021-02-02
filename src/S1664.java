public class S1664 {
    public int waysToMakeFair(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        pre[1] = nums[1];
        int se = nums[0], so = nums[1], s = nums[0] + nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i%2 == 0) { // e
                se += nums[i];
            } else { // o
                so += nums[i];
            }
            pre[i] += pre[i-2] + nums[i];
            s += nums[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int st = 0;
            if (i%2 == 0) { // e
                st = pre[i]-nums[i] + (so - (i > 0 ? pre[i-1] : 0));
            } else { // o
                st = pre[i]-nums[i] + (se - (i > 0 ? pre[i-1] : 0));
            }
            if (s - nums[i] - st == st) {
                res++;
            }
        }
        return res;
    }
}
