import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class S1636SortArrayIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            cnt.put(n, cnt.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {
            if (!cnt.get(o1).equals(cnt.get(o2))) {
                return cnt.get(o1) - cnt.get(o2);
            }
            return o2-o1;
        });
        for (Integer k : cnt.keySet()) {
            pq.offer(k);
        }
        int[] res = new int[nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int v = pq.poll();
            for (int j = 0; j < cnt.get(v); j++) {
                res[i++] = v;
            }
        }
        return res;
    }
}
