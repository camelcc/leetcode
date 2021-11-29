import java.util.Arrays;

public class S2090KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (nums.length <= 2*k) {
            return res;
        }
        int len = 2*k+1;
        int l = 0, mid = k, r = 0;
        long s = 0;
        while (r <= 2*k) {
            s += nums[r];
            r++;
        }
        while (r <= nums.length) {
            res[mid] = (int)(s/len);
            if (r == nums.length) {
                break;
            }
            s += nums[r];
            s -= nums[l];
            l++;
            mid++;
            r++;
        }
        return res;
    }
}
