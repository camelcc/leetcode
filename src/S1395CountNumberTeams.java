import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1395CountNumberTeams {
    public int numTeams(int[] rating) {
        List<Integer> data = new ArrayList<>();
        int[] minCnt = new int[rating.length];
        int[] maxCnt = new int[rating.length];
        int res = 0;
        for (int last = 0; last < rating.length; last++) {
            int v = rating[last];
            int i = Collections.binarySearch(data, v);
            if (i < 0) {
                i = -(i+1);
            }
            minCnt[last] = i;
            maxCnt[last] = data.size()-i;
            data.add(i, v);
            for (int middle = 0; middle < last; middle++) {
                if (rating[middle] < v) {
                    res += minCnt[middle];
                } else if (rating[middle] > v) {
                    res += maxCnt[middle];
                }
            }
        }
        return res;
    }
}
