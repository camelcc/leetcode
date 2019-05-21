import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S0632SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        Comparator<int[]> com = Comparator.comparingInt((int[] o) -> nums.get(o[0]).get(o[1]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(com);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(com.reversed());
        for (int i = 0; i < nums.size(); i++) {
            int[] t = new int[]{i, 0};
            minHeap.add(t);
            maxHeap.add(t);
        }

        int[] min = minHeap.peek();
        int[] max = maxHeap.peek();
        res[0] = nums.get(min[0]).get(min[1]);
        res[1] = nums.get(max[0]).get(max[1]);
        if (res[0] == res[1]) {
            return res;
        }

        while (min[1] < nums.get(min[0]).size()-1) {
            int[] t = minHeap.poll();
            boolean exist = maxHeap.remove(t);
            assert exist;
            min[1]++;

            exist = minHeap.offer(min);
            assert exist;
            exist = maxHeap.offer(min);
            assert exist;

            min = minHeap.peek();
            max = maxHeap.peek();
            int vmax = nums.get(max[0]).get(max[1]);
            int vmin = nums.get(min[0]).get(min[1]);
            if (vmax == vmin) {
                return new int[]{vmin, vmax};
            }
            if (vmax-vmin < res[1]-res[0] || (vmax-vmin == res[1]-res[0] && vmin < res[0])) {
                res[0] = vmin;
                res[1] = vmax;
            }
        }
        return res;
    }
}
