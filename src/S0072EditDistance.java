import java.util.HashMap;

public class S0072EditDistance {
    public int minDistance(String word1, String word2) {
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        return distance(word1, word2, map);
    }

    private int distance(String word1, String word2, HashMap<String, HashMap<String, Integer>> map) {
        if (word1.length() > word2.length()) {
            String t = word1;
            word1 = word2;
            word2 = t;
        }
        // word1.len <= word2.len
        if (map.containsKey(word1) && map.get(word1).containsKey(word2)) {
            return map.get(word1).get(word2);
        }

        int res = 0;
        if (word1.isEmpty()) {
            res = word2.length();
        } else {
            int delete = 1 + distance(word1.substring(1), word2, map);
            int insert = 1 + distance(word1, word2.substring(1), map);
            int replace = 0;
            if (word1.charAt(0) == word2.charAt(0)) {
                replace = distance(word1.substring(1), word2.substring(1), map);
            } else {
                replace = 1 + distance(word1.substring(1), word2.substring(1), map);
            }
            res = Math.min(Math.min(delete, insert), replace);
        }
        HashMap<String, Integer> m = map.getOrDefault(word1, new HashMap<>());
        m.put(word2, res);
        map.put(word1, m);
        return res;
    }
}
