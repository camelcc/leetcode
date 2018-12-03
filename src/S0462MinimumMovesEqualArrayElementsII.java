import java.util.Arrays;

public class S0462MinimumMovesEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int v = nums[nums.length/2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(v-nums[i]);
        }
        return res;
    }
}
