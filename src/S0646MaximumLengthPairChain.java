import java.util.*;

public class S0646MaximumLengthPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int max = 1;
        int[] res = new int[pairs.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < pairs.length; i++) {
            int t = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    t = Math.max(t, res[j]+1);
                }
            }
            res[i] = t;
            max = Math.max(max, t);
        }
        return max;
    }
}
