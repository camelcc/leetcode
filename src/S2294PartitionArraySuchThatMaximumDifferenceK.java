import java.util.Arrays;

public class S2294PartitionArraySuchThatMaximumDifferenceK {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int cur = -1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= cur) {
                i++;
                continue;
            }

            res++;
            cur = nums[i]+k;
            i++;
        }
        return res;
    }
}
