import java.util.Arrays;

public class S1411NumberWaysPaintN3Grid {
    public int numOfWays(int n) {
        if (n == 1) {
            return 12;
        }
        int MOD = (int)(Math.pow(10, 9)+7);
        String[] combines = new String[]{"ryr", "yry", "gry", "ryg", "yrg", "grg", "rgr", "ygr", "gyr", "rgy", "ygy", "gyg"};
        boolean[][] connected = new boolean[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = i+1; j < 12; j++) {
                String c1 = combines[i], c2 = combines[j];
                if (c1.charAt(0) == c2.charAt(0) || c1.charAt(1) == c2.charAt(1) || c1.charAt(2) == c2.charAt(2)) {
                    continue;
                }
                connected[i][j] = true;
                connected[j][i] = true;
            }
        }
        long[] cnt = new long[12];
        Arrays.fill(cnt, 1);
        int r = 1;
        while (r < n) {
            long[] next = new long[12];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (!connected[i][j]) {
                        continue;
                    }
                    next[j] += cnt[i];
                    next[j] = next[j]%MOD;
                }
            }
            cnt = next;
            r++;
        }
        long sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += cnt[i];
            sum = sum%MOD;
        }
        return (int)(sum%MOD);
    }
}
