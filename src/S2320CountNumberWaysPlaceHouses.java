import java.util.Arrays;

public class S2320CountNumberWaysPlaceHouses {
    public int countHousePlacements(int n) {
        int MOD = 1_000_000_007;
        long[] cnt = new long[4];
        cnt[0] = 1;
        for (int i = 0; i < n; i++) {
            long[] next = new long[4];
            Arrays.fill(next, cnt[0]);
            next[0] = (next[0] + cnt[1])%MOD;
            next[2] = (next[2] + cnt[1])%MOD;
            next[0] = (next[0] + cnt[2])%MOD;
            next[1] = (next[1] + cnt[2])%MOD;
            next[0] = (next[0] + cnt[3])%MOD;
            cnt = next;
        }
        long res = 0;
        for (long c : cnt) {
            res = (res + c)%MOD;
        }
        return (int)res;
    }
}
