import java.util.Arrays;

public class S1887ReductionOperationsMakeArrayElementsEqual {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0, i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            res += nums.length-j;
            i = j;
        }
        return res;
    }
}
