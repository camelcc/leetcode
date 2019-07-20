import java.util.HashSet;

public class S1049LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        HashSet<Integer> sum = new HashSet<>();
        sum.add(0);
        for (int i = 0; i < stones.length; i++) {
            int v = stones[i];
            HashSet<Integer> next = new HashSet<>();
            for (int s : sum) {
                next.add(s+v);
                next.add(s-v);
            }
            sum = next;
        }
        int res = Integer.MAX_VALUE;
        for (int s : sum) {
            if (s == 0) {
                return 0;
            } else if (s > 0) {
                res = Math.min(res, s);
            }
        }
        return res;
    }
}
