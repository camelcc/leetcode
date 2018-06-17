public class S0485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;

        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                t++;
            } else {
                if (res < t) {
                    res = t;
                }

                t = 0;
            }
        }
        if (res < t) {
            res = t;
        }
        return res;
    }
}
