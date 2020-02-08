public class S0365WaterJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0) {
            return z == 0 || z == y;
        }
        if (y == 0) {
            return z == 0 || z == x;
        }
        if (z > x + y) {
            return false;
        }
        if (z == x + y) {
            return true;
        }
        if (z % x == 0 || z % y == 0) {
            return true;
        }

        int gcd = gcd(x, y);
        return z%gcd == 0;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        int r = x % y;
        return gcd(y, r);
    }
}
