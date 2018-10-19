import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0830PositionsLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();

        int start = 0;
        int cnt = 1;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i-1)) {
                cnt++;
            } else {
                if (cnt >= 3) {
                    res.add(Arrays.asList(start, i-1));
                }
                cnt = 1;
                start = i;
            }
        }
        if (cnt >= 3) {
            res.add(Arrays.asList(start, S.length()-1));
        }

        return res;
    }
}
