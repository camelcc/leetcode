import java.util.HashMap;

public class S1010PairsSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int v = time[i];
            int sum = 1020;
            while (sum >= v) {
                res += cnt.getOrDefault(sum-v, 0);
                sum -= 60;
            }
            cnt.put(v, cnt.getOrDefault(v, 0)+1);
        }
        return res;
    }
}
