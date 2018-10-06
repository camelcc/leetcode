public class S0202HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (slow != 1) {
            slow = squareDigits(slow);
            fast = squareDigits(squareDigits(fast));
            if (slow == fast) {
                break;
            }
        }
        return slow == 1;
    }

    private int squareDigits(int n) {
        int res = 0;
        while (n > 0) {
            int last = n%10;
            res += last * last;
            n = n / 10;
        }
        return res;
    }
}
