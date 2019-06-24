public class S0915PartitionArrayDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int m = Integer.MAX_VALUE;
        int[] min = new int[A.length];
        for (int j = A.length-1; j >= 0; j--) {
            m = Math.min(m, A[j]);
            min[j] = m;
        }
        m = Integer.MIN_VALUE;
        for (int i = 0; i < A.length-1; i++) {
            m = Math.max(m, A[i]);
            if (m <= min[i+1]) {
                return i+1;
            }
        }
        return -1;
    }
}
