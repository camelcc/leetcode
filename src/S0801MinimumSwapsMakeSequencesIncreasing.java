import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0801MinimumSwapsMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        if (A.length <= 1) {
            return 0;
        }

        List<int[]> bfs = new ArrayList<>();
        bfs.add(new int[] {-1, -1, 0, 0});

        int[][] swaps = new int[2][A.length];
        Arrays.fill(swaps[0], Integer.MAX_VALUE);
        Arrays.fill(swaps[1], Integer.MAX_VALUE);

        int res = Integer.MAX_VALUE;
        while (!bfs.isEmpty()) {
            int[] t = bfs.remove(0);
            int a = t[0];
            int b = t[1];
            int times = t[2];
            int index = t[3];
            if (index >= A.length) {
                res = Math.min(res, times);
                continue;
            }

            // not swap
            if (A[index] > a && B[index] > b) {
                if (times < swaps[0][index]) {
                    swaps[0][index] = times;
                    bfs.add(new int[] {A[index], B[index], times, index+1});
                }
            }
            // swap
            if (A[index] > b && B[index] > a) {
                if (times+1 < swaps[1][index]) {
                    swaps[1][index] = times+1;
                    bfs.add(new int[] {B[index], A[index], times+1, index+1});
                }
            }
        }

        return res;
    }
}
