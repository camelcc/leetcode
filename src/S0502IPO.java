import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S0502IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (k == 0) {
            return W;
        }
        Integer[] indexs = new Integer[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            indexs[i] = i;
        }
        Arrays.sort(indexs, ((o1, o2) -> {
            if (Capital[o1] == Capital[o2]) {
                return Profits[o2]-Profits[o1];
            }
            return Capital[o1]-Capital[o2];
        }));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        int res = W;
        while (k > 0) {
            while (i < indexs.length && Capital[indexs[i]] <= res) {
                queue.offer(Profits[indexs[i]]);
                i++;
            }
            if (queue.isEmpty()) {
                break;
            }
            res += queue.poll();
            k--;
        }

        return res;
    }
}
