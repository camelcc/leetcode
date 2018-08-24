import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//TODO: dp solution
public class S0416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        if (nums.length == 1) {
            return false;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }

        Arrays.sort(nums);
        int[] indexs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexs[i] = i;
        }

        for (int picked = 1; picked <= indexs.length/2; picked++) {
            List<List<Integer>> picks = select(picked, indexs, 0);
            for (int i = 0; i < picks.size(); i++) {
                List<Integer> selected = picks.get(i);
                selected.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });

                int[] a = new int[selected.size()];
                int[] b = new int[indexs.length - selected.size()];
                int ai = 0, bi = 0, si = 0;
                for (int j = 0; j < indexs.length; j++) {
                    if (si < selected.size() && indexs[j] == selected.get(si)) {
                        a[ai++] = indexs[j];
                        si++;
                    } else {
                        b[bi++] = indexs[j];
                    }
                }
                if (equal(nums, a, b)) {
                    return true;
                }
            }
        }

        return false;
    }

    private List<List<Integer>> select(int count, int[] nums, int start) {
        assert count > 0 && count <= nums.length - start;
        List<List<Integer>> res = new ArrayList<>();

        if (count == nums.length - start) {
            List<Integer> r = new ArrayList<>();
            for (int i = start; i < nums.length; i++) {
                r.add(nums[i]);
            }
            res.add(r);
            return res;
        }
        if (count == 1) {
            for (int i = start; i < nums.length; i++) {
                List<Integer> r = new ArrayList<>();
                r.add(nums[i]);
                res.add(r);
            }
            return res;
        }

        // nums.length - start > count
        for (int i = start; i < nums.length; i++) {
            if (count > nums.length - i) {
                break;
            }

            List<List<Integer>> list = select(count-1, nums, i+1);
            for (List<Integer> l : list) {
                l.add(nums[i]);
                res.add(l);
            }
        }
        return res;
    }

    private boolean equal(int[] nums, int[] a, int[] b) {
        assert a.length <= b.length;

        if (a[a.length - 1] < b[b.length - a.length]) {
            return false;
        }

        boolean smaller = true;
        int i = a.length;
        while (i > 0) {
            if (b[b.length - 1 - (a.length - i)] < a[i - 1]) {
                smaller = false;
                break;
            }
            i--;
        }
        if (smaller) {
            return false;
        }

        int sum = 0;
        for (i = 0; i < a.length; i++) {
            sum += nums[a[i]] - nums[b[i]];
        }
        if (i == b.length) {
            return sum == 0;
        }
        // i < b.length
        if (sum <= 0) {
            return false;
        }
        for (i = a.length; i < b.length; i++) {
            sum -= nums[b[i]];
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }
}
