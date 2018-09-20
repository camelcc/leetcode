import java.util.*;

public class S0347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        maxHeap.addAll(map.keySet());

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(maxHeap.remove());
        }
        return res;
    }
}
