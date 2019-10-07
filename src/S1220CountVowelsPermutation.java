import java.util.Arrays;

public class S1220CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int MOD = (int)Math.pow(10, 9)+7;

        int step = 1;
        long[] count = new long[5];
        Arrays.fill(count, 1);
        while (step < n) {
            long[] next = new long[5];
            // a -> e
            next[1] += count[0];
            // e -> a, i
            next[0] += count[1];
            next[2] += count[1];
            // i -> a, e, o, u
            next[0] += count[2];
            next[1] += count[2];
            next[3] += count[2];
            next[4] += count[2];
            // o -> i, u
            next[2] += count[3];
            next[4] += count[3];
            // u -> a
            next[0] += count[4];

            for (int i = 0; i < next.length; i++) {
                next[i] = next[i]%MOD;
            }
            count = next;
            step++;
        }
        long res = 0;
        for (int i = 0; i < count.length; i++) {
            res += count[i];
            res = res%MOD;
        }
        return (int)res;
    }
}
