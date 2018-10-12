public class S0581ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = 1;
        while (left < nums.length) {
            if (nums[left] < nums[left-1]) {
                break;
            }
            left++;
        }
        if (left == nums.length) {
            return 0;
        }
        int min = nums[left];
        for (int i = left; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        left--;
        while (left >= 0) {
            if (nums[left] > min) {
                left--;
            } else {
                break;
            }
        }

        int right = nums.length-1;
        while (right > 0) {
            if (nums[right] < nums[right-1]) {
                break;
            }
            right--;
        }
        if (right == -1) {
            return 0;
        }
        int max = nums[right];
        for (int i = right; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        right++;
        while (right < nums.length) {
            if (nums[right] < max) {
                right++;
            } else {
                break;
            }
        }

        return right-left-1;
    }
}
