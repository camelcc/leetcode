import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0893GroupsSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        List<int[][]> res = new ArrayList<>();
        for (String s : A) {
            int[][] cnt = new int[2][26];
            for (int i = 0; i < s.length(); i++) {
                cnt[i%2][s.charAt(i)-'a']++;
            }
            boolean same = false;
            for (int i = 0; i < res.size(); i++) {
                int[][] r = res.get(i);
                if (Arrays.equals(cnt[0], r[0]) && Arrays.equals(cnt[1], r[1])) {
                    same = true;
                    break;
                }
            }
            if (!same) {
                res.add(cnt);
            }
        }
        return res.size();
    }
}
