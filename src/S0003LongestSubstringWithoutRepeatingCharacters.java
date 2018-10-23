import java.util.HashMap;

public class S0003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;

        HashMap<Character, Integer> pos = new HashMap<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (pos.containsKey(c)) {
                start = Math.max(start, pos.get(c)+1);
            }

            pos.put(c, end);
            len = Math.max(len, end-start+1);
            end++;
        }
        return len;
    }
}
