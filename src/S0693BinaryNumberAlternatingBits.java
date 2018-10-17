public class S0693BinaryNumberAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int lastbit = n%2;
        while (n > 0) {
            n = n >> 1;
            if (n%2 == lastbit) {
                return false;
            }
            lastbit = n%2;
        }
        return true;
    }
}
