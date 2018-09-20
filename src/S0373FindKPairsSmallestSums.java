import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S0373FindKPairsSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>(k);
        if (k == 0 || nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                minHeap.add(new int[]{ nums1[i], nums2[j] });
            }
        }
        int i = 0;
        while (i < k && !minHeap.isEmpty()) {
            res.add(minHeap.poll());
            i++;
        }
        return res;
    }
}
