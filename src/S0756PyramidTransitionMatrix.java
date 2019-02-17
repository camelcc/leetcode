import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class S0756PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String a : allowed) {
            String key = a.substring(0, 2);
            List<String> v = map.getOrDefault(key, new ArrayList<>());
            v.add(a.substring(2));
            map.put(key, v);
        }

        Stack<String> candidates = new Stack<>();
        candidates.push(bottom);
        while (!candidates.isEmpty()) {
            String can = candidates.pop();
            if (can.length() == 1) {
                return true;
            }

            boolean valid = true;
            List<String> sb = new ArrayList<>();
            sb.add("");
            for (int i = 0; i < can.length()-1; i++) {
                String key = can.substring(i, i+2);
                if (!map.containsKey(key)) {
                    valid = false;
                    break;
                }
                List<String> vals = map.get(key);
                List<String> next = new ArrayList<>();
                for (String v : vals) {
                    List<String> last = new ArrayList<>(sb);
                    for (String t : last) {
                        next.add(t+v);
                    }
                }
                sb = next;
            }
            if (valid) {
                candidates.addAll(sb);
            }
        }

        return false;
    }
}
