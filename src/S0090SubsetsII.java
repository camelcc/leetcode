import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// TODO: not optimal
public class S0090SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        res.add(new ArrayList<>());

        HashMap<Integer, Integer> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            buckets.put(nums[i], buckets.containsKey(nums[i]) ? buckets.get(nums[i])+1 : 1);
        }
        int[] noDupNums = new int[buckets.size()];
        int j = 0;
        for (int k : buckets.keySet()) {
            noDupNums[j++] = k;
        }

        for (int i = 1; i <= nums.length; i++) {
            res.addAll(pick(noDupNums, buckets, i));
        }

        return res;
    }

    private List<List<Integer>> pick(int[] nums, HashMap<Integer, Integer> buckets, int count) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || count <= 0) {
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

        for (int i = 0; i < nums.length; i++) {
            int pickedValue = nums[i];
            int maxPickedTimes = buckets.get(pickedValue);
            if (maxPickedTimes >= count) {
                List<Integer> a = new ArrayList<>();
                for (int j = count; j > 0; j--) {
                    a.add(pickedValue);
                }
                res.add(a);
            }

            for (int picked = maxPickedTimes; picked >= 1; picked--) {
                List<List<Integer>> sets = pick(remains(nums, i), buckets, count-picked);
                for (List<Integer> s : sets) {
                    for (int j = 0; j < picked; j++) {
                        s.add(pickedValue);
                    }
                    res.add(s);
                }
            }
        }

        return res;
    }

    private int[] remains(int[] nums, int k) {
        if (k < 0 || k >= nums.length) {
            return nums;
        }

        int[] r = new int[nums.length-k-1];
        for (int i = k+1, j = 0; i < nums.length && i != k; i++) {
            r[j++] = nums[i];
        }
        return r;
    }
}
