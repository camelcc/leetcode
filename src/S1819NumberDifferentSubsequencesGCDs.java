// https://leetcode.com/problems/number-of-different-subsequences-gcds/discuss/1229974/Java-faster-than-95-with-explanation
public class S1819NumberDifferentSubsequencesGCDs {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        boolean[] exist = new boolean[200001];
        for (int n : nums) {
            max = Math.max(max, n);
            exist[n] =true;
        }
        int res = 0;
        for (int i = 1; i <= max; i++) {
            if (exist[i]) {
                res++;
                continue;
            }
            int gcd = 0;
            for (int j = i; j <= max; j+= i) {
                if (exist[j]) {
                    gcd = gcd(gcd, j);
                }
                if (gcd == i) {
                    res++;
                    break;
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
