import java.util.ArrayList;
import java.util.List;

public class S2273FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList();
        res.add(words[0]);
        String prev = words[0];
        int[] pcnt = cnt(prev);
        for (int i = 1; i < words.length; i++) {
            int[] ccnt = cnt(words[i]);
            if (anagram(pcnt, ccnt)) {
                continue;
            }
            res.add(words[i]);
            prev = words[i];
            pcnt = ccnt;
        }
        return res;
    }

    private int[] cnt(String word) {
        int[] res = new int[26];
        for (char c : word.toCharArray()) {
            res[c-'a']++;
        }
        return res;
    }

    private boolean anagram(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
