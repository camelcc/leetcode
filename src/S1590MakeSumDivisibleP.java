import java.util.HashMap;

public class S1590MakeSumDivisibleP {
    public int minSubarray(int[] nums, int p) {
        long s = 0;
        for (int n : nums) {
            s += n;
        }
        int mod = (int)(s % p);
        if (mod == 0) {
            return 0;
        }

        HashMap<Integer, Integer> pre = new HashMap<>();
        pre.put(0, -1);
        int res = nums.length;
        s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            int k = (int)((s-mod+p)%p);
            if (pre.containsKey(k)) {
                res = Math.min(res, i-pre.get(k));
            }
            pre.put((int)(s%p), i);
        }
        return res == nums.length ? -1 : res;
    }
}
