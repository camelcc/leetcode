import java.util.Stack;

public class S0738MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }

        Stack<Integer> digits = new Stack<>();
        digits.push(N%10);
        int t = N/10;
        while (t != 0) {
            int d = t%10;
            if (d <= digits.peek()) {
                digits.push(d);
                t = t/10;
            } else {
                t--;
                while (!digits.isEmpty()) {
                    digits.pop();
                    t = t * 10 + 9;
                }
                return monotoneIncreasingDigits(t);
            }
        }

        return N;
    }
}
