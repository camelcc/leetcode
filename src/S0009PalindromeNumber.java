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
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }

        int reversed = 0;
        int t = x;
        while (t > 0) {
            reversed = 10 * reversed + t % 10;
            t = t / 10;
        }
        return x == reversed;
    }
}
