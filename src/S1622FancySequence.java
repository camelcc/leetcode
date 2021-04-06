import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class S1622FancySequence {
    public static class Fancy {
        private static final int MOD = 1000000007;

        // cache inverse values for 0-100
        private static final int[] INV = IntStream.range(0, 101).map(Fancy::modInverse).toArray();

        // Modular multiplicative inverse x => a * x % MOD == 1
        private static int modInverse(int a) {
            int m = MOD, y = 0, x = 1;
            while (a > 1) {
                int q = a / m;
                int t = m;
                m = a % m;
                a = t;
                t = y;

                y = x - q * y;
                x = t;
            }
            return x < 0 ? x + MOD : x;
        }

        private long mul = 1; // cumulative multiplication (%MOD)
        private long add = 0; // cumulative addition (%MOD)

        private long rmul = 1; // reverse cumulative multiplication (%MOD)

        // store base values, i.e. reverse cumulative transform are applied before addition
        private final List<Integer> list = new ArrayList<>();

        public void append(int val) {
            list.add((int) (((MOD - add + val) * rmul) % MOD));
        }

        public void addAll(int inc) {
            add = (add + inc) % MOD;
        }

        public void multAll(int m) {
            mul = (mul * m) % MOD;
            rmul = (rmul * INV[m]) % MOD;
            add = (add * m) % MOD;
        }

        public int getIndex(int idx) {
            if (idx < list.size()) {
                return (int) (((list.get(idx) * mul) + add) % MOD);
            } else {
                return -1;
            }
        }
    }
}
