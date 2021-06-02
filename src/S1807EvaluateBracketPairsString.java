import java.util.HashMap;
import java.util.List;

public class S1807EvaluateBracketPairsString {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> kv = new HashMap<>();
        for (List<String> k : knowledge) {
            kv.put(k.get(0), k.get(1));
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inside = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                inside = true;
                key = new StringBuilder();
            } else if (c == ')') {
                sb.append(kv.getOrDefault(key.toString(), "?"));
                key = new StringBuilder();
                inside = false;
            } else {
                if (inside) {
                    key.append(c);
                } else {
                    sb.append(c);
                }
            }
        }
        if (key.length() > 0) {
            sb.append(kv.getOrDefault(key.toString(), "?"));
        }
        return sb.toString();
    }
}
