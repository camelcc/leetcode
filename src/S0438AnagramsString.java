import java.util.ArrayList;
import java.util.List;

public class S0438AnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c-'a']--;
            boolean matched = true;
            for (int k = 0; k < freq.length; k++) {
                if (freq[k] != 0) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                res.add(i-(p.length()-1));
            }
            int first = i - (p.length()-1);
            if (first >= 0) {
                freq[s.charAt(first) - 'a']++;
            }
        }

        return res;
    }
}
