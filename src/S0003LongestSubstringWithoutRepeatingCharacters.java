import java.util.HashMap;

public class S0003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> pos = new HashMap<>();
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pos.containsKey(c)) {
                left = Math.max(left, pos.get(c));
            }
            res = Math.max(res, i-left);
            pos.put(c, i);
        }
        return res;
    }
}
