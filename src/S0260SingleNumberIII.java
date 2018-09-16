public class S0260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        assert nums.length >= 2;
        if (nums.length == 2) {
            return nums;
        }

        int xor = 0;
        for (int n : nums) {
            xor = xor ^ n;
        }

        int set = 0;
        for (; set < 32; set++) {
            if ((xor & (0x1 << set)) != 0) {
                break;
            }
        }
        set = 0x1 << set;

        int x = 0, y = 0;
        for (int n : nums) {
            if ((n & set) == 0) {
                x = x ^ n;
            } else {
                y = y ^ n;
            }
        }

        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        return res;
    }
}
