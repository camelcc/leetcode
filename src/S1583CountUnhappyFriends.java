import java.util.HashMap;

public class S1583CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        HashMap<Integer, Integer> p = new HashMap<>();
        for (int[] t : pairs) {
            p.put(t[0], t[1]);
            p.put(t[1], t[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int y = p.get(i);
            for (int j = 0; j < n-1 && preferences[i][j] != y; j++) {
                int u = preferences[i][j];
                boolean find = false;
                for (int k = 0; k < n-1 && preferences[u][k] != p.get(u); k++) {
                    if (preferences[u][k] == i) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
