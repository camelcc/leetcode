public class S0747LargestNumberAtLeastTwiceOthers {
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length <= 1) {
            return 0;
        }

        int max = nums[0];
        int maxIndex = 0;
        int second = max;
        int secondIndex = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                secondIndex = maxIndex;
                maxIndex = i;
            } else {
                if (nums[i] < max && (secondIndex == -1 || nums[i] > second)) {
                    second = nums[i];
                    secondIndex = i;
                }
            }
        }
        return (max-second) >= second ? maxIndex : -1;
    }
}
