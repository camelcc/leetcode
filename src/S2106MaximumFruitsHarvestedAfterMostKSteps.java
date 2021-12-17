import java.util.TreeMap;

public class S2106MaximumFruitsHarvestedAfterMostKSteps {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        long sum = 0;
        long[] preSum = new long[fruits.length+1];
        TreeMap<Integer, Integer> pos = new TreeMap<>();
        for (int i = 0; i < fruits.length; i++) {
            preSum[i] = sum;
            sum += fruits[i][1];
            pos.put(fruits[i][0], i);
        }
        preSum[fruits.length] = sum;
        int M = fruits[fruits.length-1][0];

        int res = 0;
        for (int l = 0; l <= startPos; l++) {
            if (startPos-l > k) {
                continue;
            }
            if (startPos-l == k) {
                res = Math.max(res, sum(preSum, pos, l, startPos));
                continue;
            }
            // single left, k > [l]
            int sr = Math.min(M, startPos+(k-(startPos-l))/2);
            res = Math.max(res, sum(preSum, pos, l, sr));
            // double left
            if (k > 2*(startPos-l)) {
                int dr = Math.min(startPos+(k-2*(startPos-l)), M);
                res = Math.max(res, sum(preSum, pos, l, dr));
            }
        }
        return res;
    }

    private int sum(long[] preSum, TreeMap<Integer, Integer> pos, int l, int r) {
        if (pos.ceilingKey(l) == null || pos.floorKey(r) == null) {
            return 0;
        }
        int il = pos.ceilingEntry(l).getValue();
        int ir = pos.floorEntry(r).getValue();
        if (il > ir) {
            return 0;
        }
        return (int)(preSum[ir+1]-preSum[il]);
    }
}
