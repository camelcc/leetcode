import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1002FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (String a : A) {
            int[] cnt = new int[26];
            for (char c : a.toCharArray()) {
                cnt[c-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                min[i] = Math.min(min[i], cnt[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (min[i] > 0) {
                res.add(String.valueOf((char)('a'+i)));
                min[i]--;
            }
        }
        return res;
    }
}
