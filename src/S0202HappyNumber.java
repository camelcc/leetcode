import java.util.HashSet;
import java.util.Set;

public class S0202HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        nums.add(n);
        int sum = n;
        while (true) {
             sum = squareDigits(n);
             n = sum;

            if (sum == 1) {
                return true;
            }
            if (nums.contains(sum)) {
                return false;
            }
            nums.add(sum);
        }
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
