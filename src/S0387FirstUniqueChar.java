import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0387FirstUniqueChar {
    public int firstUniqChar(String s) {
        List<Integer> uniQueue = new ArrayList<>();
        HashMap<Character, Integer> chars = new HashMap<>();
        HashSet<Character> dups = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dups.contains(c)) {
                continue;
            }

            if (chars.containsKey(c)) {
                dups.add(c);
                uniQueue.remove(chars.get(c));
                chars.remove(c);
            } else {
                uniQueue.add(i);
                chars.put(c, i);
            }
        }

        if (uniQueue.isEmpty()) {
            return -1;
        }

        return uniQueue.get(0);
    }
}
