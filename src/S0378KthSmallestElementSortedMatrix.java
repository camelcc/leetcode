import java.util.Comparator;
import java.util.PriorityQueue;

public class S0378KthSmallestElementSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });
        for (int i = 0; i < matrix[0].length; i++) {
            minHeap.add(new int[]{0, i});
        }
        int i = 0;
        int M = matrix.length;
        int[] m = new int[2];
        while (i < k) {
            m = minHeap.poll();
            if (m[0] < M-1) {
                minHeap.add(new int[]{m[0] + 1, m[1]});
            }
            i++;
        }
        return matrix[m[0]][m[1]];
    }
}
