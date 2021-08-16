import java.util.Arrays;

public class S1968ArrayWithElementsNotEqualAverageNeighbors {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int l = 0, r = nums.length-1, i = 0;
        while (i < nums.length) {
            res[i++] = nums[l++];
            if (i < nums.length) {
                res[i++] = nums[r--];
            }
        }
        return res;
    }
}
