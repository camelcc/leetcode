public class S1685SumAbsoluteDifferencesSortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] sum = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = (i+1)*nums[i] - sum[i];
            int t = s - nums.length*nums[i] + 2*left;
            res[i] = t;
        }
        return res;
    }
}
