import java.util.HashMap;

public class S1400ConstructKPalindromeStrings {
    public boolean canConstruct(String s, int k) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0)+1);
        }
        int co = 0;
        for (int c : cnt.values()) {
            if (c%2 == 1) {
                co++;
            }
        }
        if (co > k || s.length() < k) {
            return false;
        }
        return true;
    }
}
