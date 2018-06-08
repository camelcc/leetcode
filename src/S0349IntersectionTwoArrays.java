import java.util.HashSet;

public class S0349IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> nums = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            nums.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums.contains(nums2[i])) {
                res.add(nums2[i]);
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
