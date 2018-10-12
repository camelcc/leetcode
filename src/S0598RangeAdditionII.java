public class S0598RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int ma = m;
        int mb = n;

        for (int[] op : ops) {
            int a = op[0];
            int b = op[1];

            ma = Math.min(ma, a);
            mb = Math.min(mb, b);
        }

        return ma * mb;
    }
}
