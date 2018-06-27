import java.util.ArrayList;
import java.util.List;

public class S0078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        res.add(e);

        for (int i = 1; i <= nums.length; i++) {
            res.addAll(sets(nums, i));
        }
        return res;
    }

    private List<List<Integer>> sets(int[] nums, int count) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || count == 0 || nums.length < count) {
            return res;
        }
        if (nums.length == count) {
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                a.add(nums[i]);
            }
            res.add(a);
            return res;
        }
        if (count == 1) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> a = new ArrayList<>();
                a.add(nums[i]);
                res.add(a);
            }
            return res;
        }

        for (int i = 0; i < nums.length-1; i++) {
            int[] remains = new int[nums.length-i-1];
            for (int j = i+1, k = 0; j < nums.length; j++, k++) {
                remains[k] = nums[j];
            }
            List<List<Integer>> p = sets(remains, count-1);
            for (List<Integer> a : p) {
                a.add(nums[i]);
                res.add(a);
            }
        }
        return res;
    }
}
