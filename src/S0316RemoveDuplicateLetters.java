import java.util.*;

public class S0316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            cnt[s.charAt(i)-'a']--;
            if (cnt[s.charAt(i)-'a'] == 0) {
                break;
            }
        }
        if (s.length() == 0) {
            return "";
        }

        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll(String.valueOf(s.charAt(pos)), ""));
    }
}
