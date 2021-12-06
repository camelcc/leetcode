import java.util.Arrays;

public class S2094Finding3DigitEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }
        int[] res = new int[451];
        int len = 0;
        for (int v = 100; v < 1000; v += 2) {
            cnt[v%10]--;
            cnt[(v/10)%10]--;
            cnt[v/100]--;

            if (cnt[v/100] >= 0 && cnt[(v/10)%10] >= 0 && cnt[v%10] >= 0) {
                res[len++] = v;
            }

            cnt[v/100]++;
            cnt[(v/10)%10]++;
            cnt[v%10]++;
        }
        return Arrays.copyOf(res, len);
    }
}
