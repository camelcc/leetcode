public class S1658MinimumOperationsReduceXZero {
    public int minOperations(int[] nums, int x) {
        int[] pre = new int[nums.length+1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = sum;
            sum += nums[i];
        }
        pre[nums.length] = sum;
        if (sum == x) {
            return nums.length;
        }

        int res = -1;
        for (int l = 0; l < nums.length; l++) {
            if (pre[l] > x || (res >= 0 && l >= res)) {
                break;
            }
            int lo = l+1, hi = nums.length;
            while (lo <= hi) {
                int mid = lo + (hi-lo)/2;
                int t = pre[l]+sum-pre[mid];
                if (t > x) {
                    lo = mid+1;
                } else if (t == x) {
                    if (res == -1) {
                        res = l+nums.length-mid;
                    } else {
                        res = Math.min(res, l+nums.length-mid);
                    }
                    break;
                } else {
                    hi = mid-1;
                }
            }
        }
        return res;
    }
}
