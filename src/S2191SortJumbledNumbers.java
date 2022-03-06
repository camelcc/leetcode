import java.util.Arrays;
import java.util.Comparator;

public class S2191SortJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> value(mapping, nums[i])));
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[indices[i]];
        }
        return res;
    }

    private int value(int[] mapping, int v) {
        if (v == 0) {
            return mapping[0];
        }
        int res = 0;
        int base = 1;
        while (v != 0) {
            res = res + base * mapping[v%10];
            v = v/10;
            base = base * 10;
        }
        return res;
    }
}
