public class S0645SetMismatch {
    public int[] findErrorNums(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index < 0) {
                index = -index;
            }
            sum += index;
            index--;
            nums[index] = -nums[index];
        }
        sum -= (1+nums.length)*nums.length/2;
        long positive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive += i+1;
            }
        }
        int dup = (int)(sum+positive)/2;
        int miss = dup - (int)sum;
        return new int[] {dup, miss};
    }
}
