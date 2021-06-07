public class S1863SumAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int res = 0;
        for (int i = 1; i < (0x1<<nums.length); i++) {
            int v = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i&(0x1<<j)) != 0) {
                    v = v^nums[j];
                }
            }
            res += v;
        }
        return res;
    }
}
