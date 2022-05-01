import java.util.HashSet;

public class S2255CountPrefixesGivenString {
    public int countPrefixes(String[] words, String s) {
        HashSet<Integer> candidates = new HashSet();
        for (int i = 0; i < words.length; i++) {
            candidates.add(i);
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            HashSet<Integer> next = new HashSet();
            for (int k : candidates) {
                if (words[k].charAt(i) != c) {
                    continue;
                }
                if (i+1 == words[k].length()) {
                    res++;
                    continue;
                }
                next.add(k);
            }
            candidates = next;
        }
        return res;
    }
}
