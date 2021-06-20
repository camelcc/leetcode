import java.util.HashMap;
import java.util.HashSet;

public class S1900TheEarliestLatestRoundsWherePlayersCompete {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        HashMap<Integer, int[]> dp = new HashMap<>();
        return dp(n, firstPlayer, secondPlayer, (0x1<<n)-1, dp);
    }

    public int[] dp(int n, int first, int second, int v, HashMap<Integer, int[]> dp) {
        if (dp.containsKey(v)) {
            return dp.get(v);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        HashSet<Integer> can = new HashSet<>();
        can.add(v);
        int l = 0, r = n-1;
        while (l < r) {
            while ((v&(0x1<<l)) == 0) {
                l++;
            }
            while ((v&(0x1<<r)) == 0) {
                r--;
            }
            if (l >= r) {
                continue;
            }

            HashSet<Integer> next = new HashSet<>();
            if (l == first-1 && r == second-1) {
                dp.put(v, new int[]{1, 1});
                return new int[]{1, 1};
            } else if (l == first-1 || l == second-1) {
                for (int c : can) {
                    next.add(c-(0x1<<r));
                }
            } else if (r == first-1 || r == second-1) {
                for (int c : can) {
                    next.add(c-(0x1<<l));
                }
            } else {
                for (int c : can) {
                    next.add(c-(0x1<<r));
                }
                for (int c : can) {
                    next.add(c-(0x1<<l));
                }
            }
            l++;
            r--;
            can = next;
        }
        for (int nv : can) {
            int[] ndp = dp(n, first, second, nv, dp);
            min = Math.min(min, 1+ndp[0]);
            max = Math.max(max, 1+ndp[1]);
        }
        dp.put(v, new int[]{min, max});
        return new int[]{min, max};
    }
}
