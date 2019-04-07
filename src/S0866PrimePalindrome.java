import java.util.Arrays;

public class S0866PrimePalindrome {
    public int primePalindrome(int N) {
        char[] next = nextPalindrome(String.valueOf(N).toCharArray());
        while (!isPrime(Integer.valueOf(String.valueOf(next)))) {
            if (next.length > 1 && (next[0] - '0') % 2 == 0) {
                next[0]++;
                for (int i = 1; i < next.length; i++) {
                    next[i] = '0';
                }
            }
            int t = Integer.valueOf(String.valueOf(next)) + 1;
            next = nextPalindrome(String.valueOf(t).toCharArray());
        }
        return Integer.valueOf(String.valueOf(next));
    }

    private char[] nextPalindrome(char[] digits) {
        int v = Integer.valueOf(String.valueOf(digits));
        int left = 0, right = digits.length - 1;
        while (left < right) {
            digits[right] = digits[left];
            left++;
            right--;
        }
        if (Integer.valueOf(String.valueOf(digits)) >= v) {
            return digits;
        }

        int half = Integer.valueOf(String.valueOf(digits, 0, digits.length%2+digits.length/2)) + 1;
        char[] increment = String.valueOf(half).toCharArray();
        char[] res = new char[increment.length + digits.length / 2];
        int i = 0;
        for (int j = 0; j < increment.length; j++) {
            res[i++] = increment[j];
        }
        for (int j = digits.length%2 + digits.length/2; j < digits.length; j++) {
            res[i++] = '0';
        }
        return nextPalindrome(res);
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
