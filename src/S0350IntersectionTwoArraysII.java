import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0350IntersectionTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            if (nums.containsKey(n)) {
                nums.put(n, nums.get(n) + 1);
            } else {
                nums.put(n, 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            if (nums.containsKey(n)) {
                res.add(n);
                if (nums.get(n) == 1) {
                    nums.remove(n);
                } else {
                    nums.put(n, nums.get(n) - 1);
                }
            }
        }

        int[] intersection = new int[res.size()];
        int i = 0;
        for (int r : res) {
            intersection[i++] = r;
        }
        return intersection;
    }
}
