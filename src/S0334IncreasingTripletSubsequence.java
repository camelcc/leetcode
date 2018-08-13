public class S0334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int min = nums[0];
        int median = Integer.MAX_VALUE;
        int possibleMin = min;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < possibleMin) {
                possibleMin = nums[i];
                if (median == Integer.MAX_VALUE) {
                    min = possibleMin;
                }
                continue;
            }

            if (nums[i] == possibleMin) {
                continue;
            }

            // nums[i] > possibleMin
            if (nums[i] < min) {
                min = possibleMin;
                median = nums[i];
                continue;
            }

            if (nums[i] == min) {
                min = possibleMin;
                median = nums[i];
                continue;
            }

            // nums[i] > min
            if (nums[i] < median) {
                min = possibleMin;
                median = nums[i];
                continue;
            }

            if (nums[i] == median) {
                continue;
            }

            return true;
        }

        return false;
    }
}
