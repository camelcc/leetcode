import java.util.Arrays;

public class S0016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int v = nums[i];
            int mid = i + 1, end = nums.length - 1;
            while (mid < end) {
                int s = v + nums[mid] + nums[end];
                if (s > target) {
                    end--;
                } else {
                    mid++;
                }
                if (Math.abs(s - target) < Math.abs(res - target)) {
                    res = s;
                }
            }
        }
        return res;
    }
}
