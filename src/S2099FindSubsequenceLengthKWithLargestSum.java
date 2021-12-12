import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S2099FindSubsequenceLengthKWithLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(o -> nums[o]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = index[nums.length-k+i];
        }
        Arrays.sort(res);
        int[] r = new int[k];
        for (int i = 0; i < k; i++) {
            r[i] = nums[res[i]];
        }
        return r;
    }
}
