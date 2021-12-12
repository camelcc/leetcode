import java.util.ArrayList;
import java.util.List;

public class S2100FindGoodDaysRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < security.length; i++) {
                res.add(i);
            }
            return res;
        }
        int start = 0, mid = time;
        while (start+2*time < security.length) {
            boolean good = true;
            for (int i = start; i < mid; i++) {
                if (security[i] < security[i+1]) {
                    start = i+1;
                    mid = start+time;
                    good = false;
                    break;
                }
            }
            if (!good) {
                continue;
            }
            for (int i = mid; i < mid+time; i++) {
                if (security[i] > security[i+1]) {
                    start = i+1-time;
                    mid = i+1;
                    good = false;
                    break;
                }
            }
            if (!good) {
                continue;
            }
            while (good) {
                res.add(mid);
                if (start+2*time+1 >= security.length) {
                    start++;
                    mid++;
                    break;
                }

                if (security[mid] < security[mid+1]) {
                    good = false;
                    start = mid+1;
                    mid = start+time;
                    continue;
                }
                if (security[mid+time] > security[mid+time+1]) {
                    good = false;
                    start = mid+1;
                    mid = mid+time+1;
                    continue;
                }
                start++;
                mid++;
            }
        }
        return res;
    }
}
