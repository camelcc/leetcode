import java.util.Arrays;
import java.util.HashMap;

public class S0826MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[] diff = Arrays.copyOf(difficulty, difficulty.length);
        int[] prof = new int[profit.length];
        Arrays.sort(diff);
        for (int i = 0; i < difficulty.length; i++) {
            int d = difficulty[i];
            int p = profit[i];
            int di = Arrays.binarySearch(diff, d);
            assert di >= 0;
            if (p < prof[di]) {
                continue;
            }
            for (int j = di; j < diff.length && p > prof[j]; j++) {
                prof[j] = p;
            }
        }
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        int res = 0;
        for (int work : worker) {
            if (dp.containsKey(work)) {
                res += dp.get(work);
                continue;
            }

            int p = 0;
            int pi = Arrays.binarySearch(diff, work);
            if (pi < 0) {
                pi = -(pi+1)-1;
            }
            if (pi >= 0) {
                p = prof[pi];
            }
            dp.put(work, p);
            res += p;
        }
        return res;
    }
}
