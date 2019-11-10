import java.util.Arrays;
import java.util.HashMap;

public class S1255MaximumScoreWordsFormedLetters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] wp = new int[words.length];
        int[][] wf = new int[words.length][26];
        HashMap<String, Integer>[] dp = new HashMap[words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i] = new HashMap<>();
            String w = words[i];
            int p = 0;
            for (char c : w.toCharArray()) {
                p += score[c-'a'];
                wf[i][c-'a']++;
            }
            wp[i] = p;
        }
        int[] lf = new int[26];
        for (char c : letters) {
            lf[c-'a']++;
        }

        return max(wf, wp, lf, 0, dp);
    }

    private int max(int[][] words, int[] score, int[] letters, int i, HashMap<String, Integer>[] dp) {
        String key = lf2str(letters);
        if (dp[i].containsKey(key)) {
            return dp[i].get(key);
        }
        int res = 0;
        if (i == words.length-1) {
            int[] l = sub(letters, words[i]);
            if (l != null) {
                res = score[i];
            }
            dp[i].put(key, res);
            return res;
        }

        res = max(words, score, letters, i+1, dp);
        int[] l = sub(letters, words[i]);
        if (l != null) {
            res = Math.max(res, score[i]+max(words, score, l, i+1, dp));
        }
        dp[i].put(key, res);
        return res;
    }

    private String lf2str(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char c = (char)(i+'a');
            for (int f = 0; f < freq[i]; f++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private int[] sub(int[] freq, int[] word) {
        int[] res = Arrays.copyOf(freq, 26);
        for (int i = 0; i < 26; i++) {
            if (res[i] < word[i]) {
                return null;
            }
            res[i] -= word[i];
        }
        return res;
    }
}
