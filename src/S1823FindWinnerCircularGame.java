import java.util.ArrayList;
import java.util.List;

public class S1823FindWinnerCircularGame {
    public int findTheWinner(int n, int k) {
        List<Integer> player = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            player.add(i);
        }
        int pos = 0;
        while (player.size() > 1) {
            int len = player.size();
            int p = (pos+k-1)%len;
            player.remove(p);
            pos = p%player.size();
        }
        return player.get(0);
    }
}
