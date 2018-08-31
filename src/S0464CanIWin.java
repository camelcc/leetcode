import java.util.ArrayList;
import java.util.List;

//TODO: DFS and DP solution
public class S0464CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= maxChoosableInteger; i++) {
            pool.add(i);
        }
        return win(pool, desiredTotal);
    }

    private boolean win(List<Integer> pickPool, int total) {
        assert pickPool != null && pickPool.size() > 0 && total >= 0;

        for (int i = pickPool.size()-1; i>= 0; i--) {
            int pick = pickPool.get(i);
            if (pick >= total) {
                return true;
            }

            List<Integer> remains = new ArrayList<>(pickPool);
            remains.remove((Integer)pick);
            if (!win(remains, total-pick)) {
                return true;
            }
        }
        return false;
    }
}
