import java.util.Arrays;

public class S1818MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] sorted = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(sorted);
        int reduced = 0;
        long total = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i]-nums2[i]);
            total += diff;
            if (diff == 0) {
                continue;
            }

            int rd = diff;
            int p = Arrays.binarySearch(sorted, nums2[i]);
            if (p < 0) {
                p = -(p+1);
            }
            if (p > 0) {
                rd = Math.min(rd, Math.abs(sorted[p-1]-nums2[i]));
            }
            if (p < nums1.length) {
                rd = Math.min(rd, Math.abs(sorted[p]-nums2[i]));
            }
            reduced = Math.max(reduced, diff-rd);
        }
        int MOD = 1_000_000_007;
        return (int)((total - reduced)%MOD);
    }
}
