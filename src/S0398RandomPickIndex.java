import java.util.Random;

public class S0398RandomPickIndex {
    class Solution {
        private int[] data;
        private Random random;

        public Solution(int[] nums) {
            data = nums;
            random = new Random();
        }

        public int pick(int target) {
            int res = -1;
            int count = 1;
            for (int i = 0; i < data.length; i++) {
                if (data[i] != target) {
                    continue;
                }

                if (random.nextInt(count++) == 0) {
                    res = i;
                }
            }
            return res;
        }
    }
}
