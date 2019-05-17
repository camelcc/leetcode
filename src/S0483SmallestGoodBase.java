import java.math.BigInteger;

public class S0483SmallestGoodBase {
    public String smallestGoodBase(String n) {
        BigInteger val = new BigInteger(n);
        for (int k = 60; k >= 2; k--) {
            BigInteger lo = new BigInteger("2");
            BigInteger hi = new BigInteger(n);
            while (lo.compareTo(hi) <= 0) {
                BigInteger mid = lo.add(hi).divide(new BigInteger("2"));
                BigInteger left = val.multiply(mid.subtract(new BigInteger("1")));
                BigInteger right = mid.pow(k).subtract(new BigInteger("1"));
                int com = left.compareTo(right);
                if (com < 0) {
                    hi = mid.subtract(new BigInteger("1"));
                } else if (com == 0) {
                    return mid.toString();
                } else {
                    lo = mid.add(new BigInteger("1"));
                }
            }
        }
        return n;
    }
}
