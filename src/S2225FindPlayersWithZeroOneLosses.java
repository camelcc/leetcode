import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class S2225FindPlayersWithZeroOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> winner = new HashSet<>();
        HashSet<Integer> loser = new HashSet<>();
        HashSet<Integer> losers = new HashSet<>();
        for (int[] m : matches) {
            int w = m[0], l = m[1];
            if (!losers.contains(l)) {
                if (loser.contains(l)) {
                    loser.remove(l);
                    losers.add(l);
                } else {
                    if (winner.contains(l)) {
                        winner.remove(l);
                    }
                    loser.add(l);
                }
            }
            if (!losers.contains(w) && !loser.contains(w)) {
                winner.add(w);
            }
        }
        List<Integer> win = new ArrayList<>(winner);
        Collections.sort(win);
        List<Integer> los = new ArrayList<>(loser);
        Collections.sort(los);
        List<List<Integer>> res = new ArrayList<>();
        res.add(win);
        res.add(los);
        return res;
    }
}
