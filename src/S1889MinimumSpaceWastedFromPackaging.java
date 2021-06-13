import java.util.Arrays;

// https://leetcode.com/problems/minimum-space-wasted-from-packaging/discuss/1254116/JavaC%2B%2BPython-Binary-Search-should-not-use-prefix-sum
public class S1889MinimumSpaceWastedFromPackaging {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        long sum = 0;
        for (int p : packages) {
            sum += p;
        }
        long res = -1;
        for (int i = 0; i < boxes.length; i++) {
            Arrays.sort(boxes[i]);
            if (boxes[i][boxes[i].length - 1] < packages[packages.length - 1]) {
                continue;
            }

            long space = 0;
            int bi = 0;
            for (int j = 0; j < boxes[i].length; j++) {
                int bs = boxes[i][j];
                if (bs < packages[bi]) {
                    continue;
                }
                int lo = 0, hi = packages.length;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (packages[mid] <= bs) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                // [bi, lo]
                space += ((long) (lo - bi)) * bs;
                bi = lo;
                if (bi >= packages.length) {
                    break;
                }
            }
            if (res == -1) {
                res = space;
            } else {
                res = Math.min(res, space);
            }
        }
        if (res == -1) {
            return -1;
        }
        int MOD = 1_000_000_007;
        return (int) ((res - sum) % MOD);
    }
}
