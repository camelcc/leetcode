import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//TODO: back tracing
public class S0491IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums.length == 1) {
            return res;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int v : nums) {
            set.add(v);
        }

        for (int v : set) {
            List<Integer> path = new ArrayList<>();
            path.add(v);
            dfs(nums, index(nums, 0, v), path, res);
        }

        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        // path.size >= 1
        HashSet<Integer> b = bigger(start, nums);
        if (b.isEmpty()) {
            if (path.size() > 1) {
                res.add(path);
            }
            return;
        }

        for (int v : b) {
            List<Integer> r = new ArrayList<>(b);
            r.add(v);
            res.add(r);

            int s = index(nums, start+1, v);
            dfs(nums, s, r, res);
        }
    }

    private HashSet<Integer> bigger(int position, int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        if (position >= nums.length) {
            return res;
        }

        int v = nums[position];
        for (int i = position + 1; i < nums.length; i++) {
            if (nums[i] >= v) {
                res.add(v);
            }
        }
        return res;
    }

    private int index(int[] nums, int start, int v) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
