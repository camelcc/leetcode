import java.util.*;

public class S0493ReversePairs {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }

    private int sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int res = 0;
        int mid = (lo+hi)/2;
        res += sort(nums, lo, mid);
        res += sort(nums, mid+1, hi);

        for (int i = lo, j = mid+1; i <= mid; i++) {
            while (j <= hi && (long)nums[i] > (long)nums[j]*2) {
                j++;
            }
            res += j-(mid+1);
        }

        Arrays.sort(nums, lo, hi+1);
        return res;
    }
}
