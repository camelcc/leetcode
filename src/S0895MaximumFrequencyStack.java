import java.util.HashMap;
import java.util.PriorityQueue;

public class S0895MaximumFrequencyStack {
    public static class FreqStack {
        private PriorityQueue<int[]> pq;
        private HashMap<Integer, Integer> freq;
        int seq;

        public FreqStack() {
            pq = new PriorityQueue<>((int[] o1, int[] o2) -> {
                if (o1[0] != o2[0]) {
                    return o2[0]-o1[0];
                }
                if (o1[1] != o2[1]) {
                    return o2[1]-o1[1];
                }
                return 0;
            });
            freq=  new HashMap<>();
            seq = 1;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0)+1;
            int s = seq++;
            int[] v = new int[]{f, s, x};
            pq.offer(v);
            freq.put(x, f);
        }

        public int pop() {
            int[] res = pq.poll();
            int f = freq.remove(res[2])-1;
            if (f > 0) {
                freq.put(res[2], f);
            }
            return res[2];
        }
    }
}
