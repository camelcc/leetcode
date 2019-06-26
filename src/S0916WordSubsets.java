import java.util.ArrayList;
import java.util.List;

public class S0916WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] cnt = new int[26];
        for (String b : B) {
            int[] t = new int[26];
            for (char c : b.toCharArray()) {
                t[c-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                cnt[i] = Math.max(cnt[i], t[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (String a : A) {
            int[] t = new int[26];
            for (char c : a.toCharArray()) {
                t[c-'a']++;
            }
            int i = 0;
            while (i < 26) {
                if (t[i] < cnt[i]) {
                    break;
                }
                i++;
            }
            if (i >= 26) {
                res.add(a);
            }
        }
        return res;
    }
}
