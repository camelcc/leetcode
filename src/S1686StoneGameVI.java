import java.util.Comparator;
import java.util.PriorityQueue;

public class S1686StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int N = aliceValues.length;
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            sum[i] = aliceValues[i] + bobValues[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> sum[(int)o]).reversed());
        for (int i = 0; i < N; i++) {
            pq.offer(i);
        }
        int alice = 0, bob = 0;
        boolean a = true;
        while (!pq.isEmpty()) {
            int i = pq.poll();
            if (a) {
                alice += aliceValues[i];
            } else {
                bob += bobValues[i];
            }
            a = !a;
        }
        if (alice > bob) {
            return 1;
        } else if (alice == bob) {
            return 0;
        } else {
            return -1;
        }
    }
}
