import java.util.HashMap;

public class S1128NumberEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            String d = dominoes[i][0]+","+dominoes[i][1];
            String r = dominoes[i][1]+","+dominoes[i][0];
            if (cnt.containsKey(d)) {
                cnt.put(d, cnt.get(d)+1);
            } else if (cnt.containsKey(r)) {
                cnt.put(r, cnt.get(r)+1);
            } else {
                cnt.put(d, 1);
            }
        }
        int res = 0;
        for (String k : cnt.keySet()) {
            int v = cnt.get(k);
            res += v*(v-1)/2;
        }
        return res;
    }
}
