import java.util.LinkedList;
import java.util.List;

public class S2197ReplaceNonCoprimeNumbersArray {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        res.offer(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            while (!res.isEmpty()) {
                int prev = res.getLast();
                int gcd = gcd(current, prev);
                if (gcd == 1) {
                    break;
                }
                res.pollLast();
                current = (int)(((long)current)*prev/gcd);
            }
            res.offer(current);
        }
        return res;
    }

    int gcd(int a, int b) {
        return (a%b == 0) ? b : gcd(b, a%b);
    }
}
