import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class S2183CountArrayPairsDivisibleK {
    public long countPairs(int[] nums, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            int r = num % k;
            int gcd = r == 0 ? 0 : gcd(r, k);
            cnt.put(gcd, cnt.getOrDefault(gcd, 0) + 1);
        }
        long zero = cnt.getOrDefault(0, 0);
        long res = zero*(nums.length-1) - (zero*(zero-1)/2);
        cnt.remove(0);
        cnt.remove(1); // prime

        List<Integer> factors = new ArrayList<>(cnt.keySet());
        Collections.sort(factors);
        for (int i = 0; i < factors.size(); i++) {
            int f = factors.get(i);
            long c = cnt.get(f);
            if ((f*f)%k == 0) {
                res += c*(c-1)/2;
            }
            for (int j = i+1; j < factors.size(); j++) {
                if ((f*factors.get(j))%k == 0) {
                    res += c * cnt.get(factors.get(j));
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
