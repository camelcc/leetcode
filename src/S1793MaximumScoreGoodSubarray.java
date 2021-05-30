import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class S1793MaximumScoreGoodSubarray {
    public int maximumScore(int[] nums, int k) {
        Integer[] is = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            is[i] = i;
        }
        Arrays.sort(is, Comparator.comparingInt(o -> nums[o]));
        TreeSet<Integer> set = new TreeSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = is[i];
            int left = set.lower(index) == null ? 0 : set.lower(index)+1;
            int right = set.higher(index) == null ? nums.length-1 : set.higher(index)-1;
            set.add(index);
            if (left > k || right < k) {
                continue;
            }
            // left <= k <= right
            int v = nums[index]*(right-left+1);
            res = Math.max(res, v);
        }
        return res;
    }
}
