public class S1979FindGreatestCommonDivisorArray {
    public int findGCD(int[] nums) {
        int s = nums[0], b = nums[0];
        for (int n : nums) {
            s = Math.min(s, n);
            b = Math.max(b, n);
        }
        return gcd(b, s);
    }

    private int gcd(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
