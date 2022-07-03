import java.util.HashMap;
import java.util.HashSet;

public class S2325DecodeMessage {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        char v = 'a';
        for (char c : key.toCharArray()) {
            if (map.containsKey(c)) {
                continue;
            }
            map.put(c, v);
            v++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}
