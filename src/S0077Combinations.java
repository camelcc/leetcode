import java.util.ArrayList;
import java.util.List;

public class S0077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        return permuate(nums, k);
    }

    private List<List<Integer>> permuate(List<Integer> nums, int count) {
        List<List<Integer>> res = new ArrayList<>();
        if (count == 0 || nums.size() == 0 || nums.size() < count) {
            return res;
        }
        if (count == 1) {
            for (int n : nums) {
                List<Integer> a = new ArrayList<>();
                a.add(n);
                res.add(a);
            }
            return res;
        }

        for (int n : nums) {
            List<Integer> remains = new ArrayList<>();
            for (int j = n+1; j <= nums.get(nums.size()-1); j++) {
                remains.add(j);
            }

            List<List<Integer>> p = permuate(remains, count-1);
            for (List<Integer> a : p) {
                a.add(n);
                res.add(a);
            }
        }
        return res;
    }
}
