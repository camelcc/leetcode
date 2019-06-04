import java.util.TreeMap;

public class S0862ShortestSubarraySumLeastK {
    public int shortestSubarray(int[] A, int K) {
        if (A.length == 0) {
            return -1;
        }
        int N = A.length;
        int res = Integer.MAX_VALUE;
        TreeMap<Long, Integer> presum = new TreeMap<>();
        long total = 0;
        for (int i = 0; i < N; i++) {
            total += A[i];
            if (total >= K) {
                res = Math.min(res, i+1);
            }
            Long floor = presum.floorKey(total-K);
            while (floor != null) {
                int j = presum.get(floor);
                res = Math.min(res, i-j);
                presum.remove(floor);
                floor = presum.lowerKey(floor);
            }
            presum.put(total, i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
