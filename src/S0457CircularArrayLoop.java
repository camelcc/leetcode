public class S0457CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int N = nums.length;
        for (int start = 0; start < N; start++) {
            int lastPosition = start;
            int steps = nums.length;
            int nextPosition = (N + lastPosition + nums[lastPosition])%N;
            while (steps > 0 && nums[lastPosition] * nums[nextPosition] > 0 && nextPosition != lastPosition) {
                lastPosition = nextPosition;
                steps--;
                nextPosition = (N + lastPosition + nums[lastPosition])%N;
            }

            if (steps == 0) {
                return true;
            }
        }
        return false;
    }
}
