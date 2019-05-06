import java.util.Comparator;
import java.util.PriorityQueue;

public class S0295FindMedianDataStream {
    class MedianFinder {
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> big;
        private Integer median;

        public MedianFinder() {
            small = new PriorityQueue<>(Comparator.reverseOrder());
            big = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (median == null) { // even
                if (small.isEmpty()) {
                    median = num;
                    return;
                }

                if (small.peek() < num) {
                    big.add(num);
                    median = big.poll();
                } else {
                    small.add(num);
                    median = small.poll();
                }
            } else { // odd
                if (num < median) {
                    small.add(num);
                    big.add(median);
                    median = null;
                } else {
                    big.add(num);
                    small.add(median);
                    median = null;
                }
            }
        }

        public double findMedian() {
            if (median == null) {
                if (small.isEmpty()) {
                    return 0;
                } else {
                    return (small.peek()+big.peek())*0.5;
                }
            } else {
                return median;
            }
        }
    }
}
