import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1942TheNumberSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<int[]> leaves = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        Integer[] indices = new Integer[times.length];
        for (int i = 0; i < times.length; i++) {
            available.offer(i);
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(o -> times[o][0]));

        for (int i = 0; i < times.length; i++) {
            int arrive = times[indices[i]][0];
            while (!leaves.isEmpty() && leaves.peek()[0] <= arrive) {
                int[] t = leaves.poll();
                available.offer(t[1]);
            }
            int chair = available.poll();
            if (indices[i] == targetFriend) {
                return chair;
            }
            int leave = times[indices[i]][1];
            leaves.offer(new int[]{leave, chair});
        }
        return -1;
    }
}
