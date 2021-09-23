public class S2012SumBeautyArray {
    public int sumOfBeauties(int[] nums) {
        int[] min = new int[nums.length];
        min[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            min[i] = Math.min(min[i+1], nums[i]);
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i-1], nums[i]);
        }
        int res = 0;
        for (int i = 1; i < nums.length-1; i++) {
            if (max[i-1] < nums[i] && nums[i] < min[i+1]) {
                res += 2;
            } else if (nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                res += 1;
            }
        }
        return res;
    }
}
