import java.util.Arrays;

public class S2062CountVowelSubstringsString {
    public int countVowelSubstrings(String word) {
        // a', 'e', 'i', 'o', and 'u
        int res = 0;
        int[] cnt = new int[5];
        for (int l = 0; l < word.length(); l++) {
            char cl = word.charAt(l);
            if (cl != 'a' && cl != 'e' && cl != 'i' && cl != 'o' && cl != 'u') {
                continue;
            }
            Arrays.fill(cnt, 0);
            for (int r = l; r < word.length(); r++) {
                char cr = word.charAt(r);
                if (cr == 'a') {
                    cnt[0]++;
                } else if (cr == 'e') {
                    cnt[1]++;
                } else if (cr == 'i') {
                    cnt[2]++;
                } else if (cr == 'o') {
                    cnt[3]++;
                } else if (cr == 'u') {
                    cnt[4]++;
                } else {
                    break;
                }
                if (cnt[0]*cnt[1]*cnt[2]*cnt[3]*cnt[4] > 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
