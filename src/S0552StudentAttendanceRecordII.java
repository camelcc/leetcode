public class S0552StudentAttendanceRecordII {
    public int checkRecord(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 3;
        } else if (n == 2) {
            return 8;
        }

        // Sum(S(i)*S(n-1-i))[0..n-1]+S(n)
        // S(n) = S(n-1)+S(n-2)+S(n-3)
        // n >= 3
        int MOD = (int)Math.pow(10, 9)+7;
        int[] sn = new int[n+1];
        sn[0] = 1;
        sn[1] = 2;
        sn[2] = 4;
        for (int i = 3; i <= n; i++) {
            sn[i] = (int)(((long)sn[i-1]+sn[i-2]+sn[i-3])%MOD);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + (long)sn[i]*sn[n-1-i])%MOD;
        }
        sum = (sum + sn[n])%MOD;
        return (int)sum;
    }
}
