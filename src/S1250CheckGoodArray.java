public class S1250CheckGoodArray {
    public boolean isGoodArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 1;
        }
        int gcd = gcd(nums[0], nums[1]);
        int i = 2;
        while (i < nums.length) {
            int v = nums[i];
            if (gcd(gcd, v) == 1) {
                return true;
            } else {
                gcd = gcd(gcd, v);
            }
            i++;
        }
        return gcd == 1;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        int r = x%y;
        return gcd(y, r);
    }
}
