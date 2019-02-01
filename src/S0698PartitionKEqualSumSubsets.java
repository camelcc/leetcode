import java.util.Arrays;

public class S0698PartitionKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum%k != 0) {
            return false;
        }
        sum = sum/k;
        Arrays.sort(nums);
        int[] collected = new int[k];
        return partition(nums, collected, nums.length-1, sum);
    }

    private boolean partition(int[] nums, int[] collected, int index, int sum) {
        int n = nums[index];
        for (int i = 0; i < collected.length; i++) {
            if (n + collected[i] > sum) {
                continue;
            }
            if (index == 0) {
                return true;
            }

            int[] t = Arrays.copyOf(collected, collected.length);
            t[i] += n;
            if (partition(nums, t, index-1, sum)) {
                return true;
            }
        }

        return false;
    }
}
