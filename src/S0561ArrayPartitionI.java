import java.util.Arrays;

public class S0561ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        int n = nums.length/2;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            sum += nums[2*i];
        }
        return sum;
    }
}
