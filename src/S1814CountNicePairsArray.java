import java.util.HashMap;

public class S1814CountNicePairsArray {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int n : nums) {
            int reverse = 0, v = n;
            while (v != 0) {
                reverse = reverse*10 + v%10;
                v = v/10;
            }
            int diff = n-reverse;
            cnt.put(diff, cnt.getOrDefault(diff, 0)+1);
        }
        long res = 0;
        for (int d : cnt.keySet()) {
            int c = cnt.get(d);
            res = res + (long)c*(c-1)/2;
        }
        int MOD = 1_000_000_007;
        return (int)(res%MOD);
    }
}
