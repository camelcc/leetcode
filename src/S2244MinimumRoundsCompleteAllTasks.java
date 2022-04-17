import java.util.HashMap;

public class S2244MinimumRoundsCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> cnt = new HashMap();
        int res = 0;
        for (int t : tasks) {
            cnt.put(t, cnt.getOrDefault(t, 0)+1);
        }
        for (int t : cnt.keySet()) {
            int r = rounds(cnt.get(t));
            if (r == -1) {
                return -1;
            }
            res += r;
        }
        return res;
    }

    private int rounds(int cnt) {
        if (cnt <= 1) {
            return -1;
        }
        return (int)Math.ceil(1.0*cnt/3);
    }
}
