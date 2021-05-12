import java.util.Arrays;

public class S1707MaximumXORWithElementFromArray {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = max(nums, queries[i][0], queries[i][1]);
        }
        return res;
    }

    private int max(int[] nums, int x, int m) {
        if (nums[0] > m) {
            return -1;
        }

        int l = 0;
        int r = Arrays.binarySearch(nums, m+1);
        if (r < 0) {
            r = -(r + 1);
        }

        int bp = 30, base = 0;
        while (bp >= 0 && (0x1<<bp) > m) {
            bp--;
        }

        while (bp >= 0 && l < r) {
            int bv = base + (0x1 << bp);
            int p = Arrays.binarySearch(nums, l, r, bv);
            if (p < 0) {
                p = -(p+1);
            } else {
                while (p > 0 && nums[p] == nums[p-1]) {
                    p--;
                }
            }
            if (((0x1<<bp) & x) == 0) { // bit 0
                // find bit 1? v >= bv
                if (p < r) {
                    base = base | bv;
                    l = p;
                }
            } else { // bit 1
                // find bit 0? v < bv
                if (p > l) {
                    r = p;
                } else {
                    base = base | bv;
                }
            }
            bp--;
        }
        return nums[l] ^ x;
    }
}
