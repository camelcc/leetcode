public class S2165SmallestValueRearrangedNumber {
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        boolean negative = num < 0;
        if (negative) {
            num = -num;
        }
        int[] cnt = new int[10];
        while (num != 0) {
            int d = (int)(num%10);
            cnt[d]++;
            num = num/10;
        }
        long res = 0;
        if (negative) {
            for (int i = 9; i >= 0; i--) {
                while (cnt[i] > 0) {
                    res = res * 10 + i;
                    cnt[i]--;
                }
            }
            res = -res;
        } else {
            for (int i = 1; i < 10; i++) {
                if (cnt[i] > 0) {
                    res = i;
                    cnt[i]--;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                while (cnt[i] > 0) {
                    cnt[i]--;
                    res = res*10 + i;
                }
            }
        }
        return res;
    }
}
