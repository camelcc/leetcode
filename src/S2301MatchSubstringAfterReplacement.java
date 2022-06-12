import java.util.HashMap;
import java.util.HashSet;

public class S2301MatchSubstringAfterReplacement {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        for (char[] m : mappings) {
            map.putIfAbsent(m[0], new HashSet<>());
            map.get(m[0]).add(m[1]);
        }

        HashSet<String> candidates = new HashSet<>();
        int i = 0;
        while (i <= s.length()-sub.length()) {
            candidates.add(s.substring(i, i+sub.length()));
            i++;
        }

        i = 0;
        while (i < sub.length() && !candidates.isEmpty()) {
            HashSet<String> next = new HashSet<>();
            char c = sub.charAt(i);
            for (String can : candidates) {
                if (can.charAt(i) == c || (map.containsKey(c) && map.get(c).contains(can.charAt(i)))) {
                    next.add(can);
                }
            }

            candidates = next;
            i++;
        }
        return !candidates.isEmpty();
    }
}
