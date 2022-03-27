import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S2215FindDifferenceTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> r1 = new HashSet<>();
        HashSet<Integer> r2 = new HashSet<>();
        for (int n : nums1) {
            r1.add(n);
        }
        HashSet<Integer> common = new HashSet<>();
        for (int n : nums2) {
            if (common.contains(n) || r1.contains(n)) {
                r1.remove(n);
                common.add(n);
            } else {
                r2.add(n);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(r1));
        res.add(new ArrayList<>(r2));
        return res;
    }
}
