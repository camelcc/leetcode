import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S1177CanMakePalindromeSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        char[] c = s.toCharArray();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            pos[c[i]-'a'].add(i);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int cdp = 0;

            for (int i = 0; i < 26; i++) {
                int left = Collections.binarySearch(pos[i], start);
                if (left < 0) {
                    left = -(left+1);
                }
                if (left >= pos[i].size() || pos[i].get(left) > end) {
                    continue;
                }

                int right = Collections.binarySearch(pos[i], end);
                if (right < 0) {
                    right = -(right+1);
                }
                if (right >= pos[i].size()) {
                    right = pos[i].size()-1;
                }
                if (pos[i].get(right) > end) {
                    right--;
                }
                if (right < left) {
                    continue;
                }
                int cnt = right-left+1;
                if (cnt%2 != 0) {
                    cdp++;
                }
            }

            boolean odd = (end-start+1)%2 == 1;
            if (odd && cdp > 0) {
                cdp--;
            }
            if ((cdp+1)/2 <= query[2]) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
