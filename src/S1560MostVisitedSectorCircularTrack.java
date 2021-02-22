import java.util.ArrayList;
import java.util.List;

public class S1560MostVisitedSectorCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] sectors = new int[n+1];
        sectors[rounds[0]]++;
        for (int i = 1; i < rounds.length; i++) {
            int start = rounds[i-1], end = rounds[i];
            if (end > start) {
                for (int j = start+1; j <= end; j++) {
                    sectors[j]++;
                }
            } else { // end < start
                for (int j = end+1; j <= start; j++) {
                    sectors[j]--;
                }
            }
        }
        int m = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            m = Math.max(m, sectors[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (sectors[i] == m) {
                res.add(i);
            }
        }
        return res;
    }
}
