import java.util.Arrays;
import java.util.Random;

public class S0384ShuffleArray {
    public static class Solution {
        private int[] origin;

        public Solution(int[] nums) {
            origin = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] shuffle = Arrays.copyOf(origin, origin.length);
            for (int i = 0; i < origin.length; i++) {
                int t = i + new Random().nextInt(origin.length-i);
                int v = shuffle[t];
                shuffle[t] = shuffle[i];
                shuffle[i] = v;
            }
            return shuffle;
        }
    }
}
