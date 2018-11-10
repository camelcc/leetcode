public class S0220ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int i = 0;
        while (i < nums.length) {
            int v = nums[i];
            for (int j = i - k; j <= i + k; j++) {
                if (j < 0 || j >= nums.length || j == i) {
                    continue;
                }
                if (Math.abs((long)v - (long)nums[j]) <= (long)t) {
                    return true;
                }
            }

            i++;
        }
        return false;
    }
}
