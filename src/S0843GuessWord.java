
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0843GuessWord {
    // This is the Master's API interface.
    // You should not implement it, or speculate about its implementation
    public static class Master {
        public int guess(String word) {
            return match(word, "acckzz");
        }

        private int match(String a, String b) {
            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    cnt++;
                }
            }
            return cnt;
        }
    }


    public void findSecretWord(String[] wordlist, Master master) {
        for (int times = 0; times < 10; times++) {
            int[] cnt = new int[wordlist.length];
            for (int i = 0; i < wordlist.length; i++) {
                for (int j = 0; j < wordlist.length; j++) {
                    if (match(wordlist[i], wordlist[j]) == 0) {
                        cnt[i]++;
                    }
                }
            }
            int min = 0;
            for (int i = 0; i < wordlist.length; i++) {
                if (cnt[i] < cnt[min]) {
                    min = i;
                }
            }
            String guess = wordlist[min];
            int matched = master.guess(guess);
            if (matched == 6) {
                return;
            }
            List<String> candidates = new ArrayList<>();
            for (String word : wordlist) {
                if (match(guess, word) == matched) {
                    candidates.add(word);
                }
            }
            wordlist = candidates.toArray(new String[candidates.size()]);
        }
    }

    private int match(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
