import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class S1239MaximumLengthConcatenatedStringUniqueCharacters {
    public int maxLength(List<String> arr) {
        List<String> filtered = new ArrayList<>();
        for (String a : arr) {
            char[] ac = a.toCharArray();
            HashSet<Character> hashSet = new HashSet<>();
            for (char c : ac) {
                hashSet.add(c);
            }
            if (hashSet.size() == ac.length) {
                filtered.add(a);
            }
        }

        List<List<Character>> data = new ArrayList<>(filtered.size());
        for (int i = 0; i < filtered.size(); i++) {
            char[] arrC = filtered.get(i).toCharArray();
            List<Character> t = new ArrayList<>();
            for (char c : arrC) {
                t.add(c);
            }
            data.add(t);
        }

        int max = 0;
        for (int i = 0; i < filtered.size(); i++) {
            int len = dfs(data, data.get(i), i, data.get(i).size());
            max = Math.max(max, len);
        }
        return max;
    }

    private int dfs(List<List<Character>> data, List<Character> cur, int start, int len) {
        int res = len;
        for (int i = start+1; i < data.size(); i++) {
            if (Collections.disjoint(cur, data.get(i))) {
                List<Character> con = new ArrayList<>(cur);
                con.addAll(data.get(i));
                int d = dfs(data, con, i, len+data.get(i).size());
                res = Math.max(res, d);
            }
        }
        return res;
    }
}
