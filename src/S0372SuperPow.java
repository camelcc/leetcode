import java.util.ArrayList;
import java.util.List;

//TODO: https://en.wikipedia.org/wiki/Euler%27s_theorem
public class S0372SuperPow {
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        int p = 0;
        for (int i : b) p = (p * 10 + i) % 1140;
        if (p == 0) p += 1440;
        return power(a, p, 1337);
    }

    public int power(int a, int n, int mod) {
        a %= mod;
        int ret = 1;
        while (n != 0) {
            if ((n & 1) != 0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }

    public int _superPow(int a, int[] b) {
        assert b.length > 0;
        int M = 1337;

        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        if (b.length == 1 && b[0] == 0) {
            return 1;
        }
        if (b.length == 1 && b[0] == 1) {
            return a % M;
        }
        if (a == M) {
            return 0;
        }
        if (a > M) {
            return superPow(a%1337, b);
        }

        // a > 1, a < 1337, b > 1
        // a^m >= 1337, a^m = r + M*K
        int m = (int)(Math.ceil(Math.log(M)/Math.log(a))); // m > 1, m <= 11
        int r = (int)Math.pow(a, m) % M;
        assert m > 1;
        assert m <= 11;

        // b <= m
        int digits = (int)(Math.log10(m) + 1);
        if (b.length <= digits) {
            int xx = convert(b);
            if (xx <= m) {
                return (int)Math.pow(a, xx) % M;
            }
        }

        // b > m
        // a^b % M = a^(b%m) * r^(b/m) % M
        List<Integer> divided = new ArrayList<>();
        int remains = remains(b, m, divided);
        assert !divided.isEmpty();
        int[] d = new int[divided.size()];
        for (int i = 0; i < divided.size(); i++) {
            d[i] = divided.get(i);
        }

        int multi = (int)(Math.pow(a, remains)) * superPow(r, d);
        return multi % M;
    }

    // return num%n, divided = num/n
    private int remains(int[] num, int n, List<Integer> divided) {
        assert num.length > 0;
        assert n > 1;
        assert n <= 11;

        int val = 0;
        for (int v : num) {
            val = val * 10 + v;
            if (val >= n) {
                divided.add(val/n);
                val = val % n;
            } else {
                if (!divided.isEmpty()) {
                    divided.add(0);
                }
            }
        }

        return val;
    }

    private int convert(int[] num) {
        int res = 0;
        for (int n : num) {
            res = res * 10 + n;
        }
        return res;
    }
}
