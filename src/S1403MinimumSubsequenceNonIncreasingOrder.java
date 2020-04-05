import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S1403MinimumSubsequenceNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int remains = 0;
        for (int n : nums) {
            queue.offer(n);
            remains += n;
        }
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        while (sum <= remains) {
            int v = queue.poll();
            res.add(v);
            sum += v;
            remains -= v;
        }
        return res;
    }
}
