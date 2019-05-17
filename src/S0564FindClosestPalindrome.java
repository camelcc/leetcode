import java.math.BigInteger;

public class S0564FindClosestPalindrome {
    public String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return String.valueOf(Integer.valueOf(n)-1);
        }
        boolean pa = isPalindromic(n);
        StringBuilder sb = new StringBuilder();
        BigInteger origin = new BigInteger(n);

        // n.len >= 2
        String half;
        if (n.length()%2 == 0) {
            half = n.substring(0, n.length()/2);
        } else {
            half = n.substring(0, n.length()/2+1);
        }

        BigInteger small = new BigInteger(half).subtract(BigInteger.ONE);
        sb = new StringBuilder();
        if (small.compareTo(BigInteger.ZERO) == 0 || small.toString().length() < half.length()) {
            // n.len-1 9
            for (int i = 0; i < n.length()-1; i++) {
                sb.append('9');
            }
        } else {
            sb.append(small.toString()).reverse();
            if (n.length()%2 == 1) {
                sb.deleteCharAt(0);
            }
            sb.insert(0, small.toString());
        }
        small = new BigInteger(sb.toString());

        BigInteger big = new BigInteger(half).add(BigInteger.ONE);
        sb = new StringBuilder();
        if (big.toString().length() > half.length()) {
            sb.append('1');
            for (int i = 0; i < n.length()-1; i++) {
                sb.append('0');
            }
            sb.append('1');
        } else {
            sb.append(big.toString()).reverse();
            if (n.length()%2 == 1) {
                sb.deleteCharAt(0);
            }
            sb.insert(0, big.toString());
        }
        big = new BigInteger(sb.toString());


        BigInteger res;
        int com = big.subtract(origin).compareTo(origin.subtract(small));
        if (com < 0) {
            res = big;
        } else if (com > 0) {
            res = small;
        } else {
            res = small;
        }
        if (pa) {
            return res.toString();
        }

        sb = new StringBuilder();
        sb.append(half).reverse();
        if (n.length()%2 == 1) {
            sb.deleteCharAt(0);
        }
        sb.insert(0, half);
        BigInteger self = new BigInteger(sb.toString());
        com = self.subtract(origin).abs().compareTo(res.subtract(origin).abs());
        if (com < 0) {
            return self.toString();
        } else if (com > 0) {
            return res.toString();
        } else {
            return res.compareTo(self) <= 0 ? res.toString() : self.toString();
        }
    }

    private boolean isPalindromic(String n) {
        int lo = 0, hi = n.length()-1;
        while (lo < hi) {
            if (n.charAt(lo) != n.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
