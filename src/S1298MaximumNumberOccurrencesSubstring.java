import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class S1298MaximumNumberOccurrencesSubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        char[] chars = s.toCharArray();
        HashMap<String, Integer> freq = new HashMap<>();
        for (int i = minSize-1; i < s.length(); i++) {
            int[] cnt = new int[26];
            int letters = 0;
            int j = i;
            while (j >= 0 && i-j+1 <= maxSize && letters <= maxLetters) {
                int c = chars[j]-'a';
                if (cnt[c] == 0) {
                    letters++;
                }
                cnt[c]++;
                if (i-j+1 >= minSize && letters <= maxLetters) {
                    String sub = s.substring(j, i+1);
                    freq.put(sub, freq.getOrDefault(sub, 0)+1);
                    if (freq.get(sub) > res) {
                        res = freq.get(sub);
                    }
                }

                j--;
            }
        }

        return res;
    }
}
