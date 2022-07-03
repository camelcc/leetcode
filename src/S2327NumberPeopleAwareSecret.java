public class S2327NumberPeopleAwareSecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] cnt = new long[n+1];
        cnt[1] = 1;
        int i = 1;
        int MOD = 1_000_000_007;
        while (i+delay <= n) {
            for (int j = i+delay; j <= Math.min(n, i+forget-1); j++) {
                cnt[j] = (cnt[j]+cnt[i])%MOD;
            }
            i++;
        }
        long res = 0;
        for (int j = n; j > n-forget; j--) {
            res = (res + cnt[j])%MOD;
        }
        return (int)res;
    }
}
