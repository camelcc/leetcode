import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0890FindReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        String p = map(pattern);
        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }
            if (p.equals(map(word))) {
                res.add(word);
            }
        }
        return res;
    }

    private String map(String word) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        char current = 'a';
        for (char c : word.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                map.put(c, current);
                sb.append(current);
                current++;
            }
        }
        return sb.toString();
    }
}

