import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class S1593SplitStringIntoMaxNumberUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        HashSet<String> t = new HashSet<>();
        t.add(s);
        return dfs(t, new HashMap<>());
    }

    private int dfs(HashSet<String> set, HashMap<String, Integer> dp) {
        String[] keys = set.toArray(new String[0]);
        String key = key(keys);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = set.size();
        for (String k : set.toArray(new String[0])) {
            if (k.length() == 1) {
                continue;
            }

            for (int i = 1; i < k.length(); i++) {
                String l = k.substring(0, i);
                if (set.contains(l)) {
                    continue;
                }
                String r = k.substring(i);
                if (set.contains(r)) {
                    continue;
                }

                // k split into l & r
                set.remove(k);
                set.add(l);
                set.add(r);
                res = Math.max(res, dfs(set, dp));

                set.remove(l);
                set.remove(r);
                set.add(k);
            }
        }
        dp.put(key, res);
        return res;
    }

    private String key(String[] keys) {
        Arrays.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String k : keys) {
            sb.append(k).append(',');
        }
        return sb.toString();
    }
}
