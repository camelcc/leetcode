public class S0858MirrorReflection {
    public int mirrorReflection(int p, int q) {
        if (q == 0) {
            return 0;
        }
        int g = gcd(p, q);
        p = p/g;
        q = q/g;
        int x = p;
        int y = q;

        if (x%2 == 0) {
            if (y%2 == 0) {
                throw new IllegalStateException("invalid position");
            } else {
                return 2;
            }
        } else {
            if (y%2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    private int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int m = p%q;
        return gcd(q, m);
    }
}
