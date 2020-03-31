import java.util.LinkedList;

public class S1392LongestHappyPrefix {
    public String longestPrefix(String s) {
        if (s.length() <= 1) {
            return "";
        }
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < s.length(); i++) {
            while (j != -1 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) j++;
            next[i] = j;
        }
        int max = next[s.length() - 1];
        return max == -1 ? "" : s.substring(0, max + 1);
    }
}
