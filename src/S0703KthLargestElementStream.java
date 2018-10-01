import java.util.Arrays;

public class S0703KthLargestElementStream {
    class KthLargest {
        private int[] array = new int[0];

        public KthLargest(int k, int[] nums) {
            array = new int[k];
            Arrays.fill(array, Integer.MIN_VALUE);
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            if (array.length == 0) {
                return Integer.MIN_VALUE;
            }
            if (val < array[0]) {
                return array[0];
            }
            array[0] = val;
            Arrays.sort(array);
            return array[0];
        }
    }
}
