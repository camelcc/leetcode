public class S0009PalindromeNumber {
    public boolean isPalindromeString(int x) {
        String val = String.valueOf(x);
        StringBuilder reverse = new StringBuilder();
        for (int i = val.length()-1; i >= 0; i--) {
            reverse.append(val.charAt(i));
        }
        return reverse.toString().equals(val);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = 10 * reversed + x % 10;
            x /= 10;
        }
        return x == reversed || reversed/10 == x;
    }
}
