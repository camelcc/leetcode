public class S0724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = s;
            s += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (s-nums[i]-sum[i] == sum[i]) {
                return i;
            }
        }
        return -1;
    }
}
