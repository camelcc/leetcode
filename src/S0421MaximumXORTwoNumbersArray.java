public class S0421MaximumXORTwoNumbersArray {
    private class BitsTree {
        int val;
        public BitsTree zero;
        public BitsTree one;

        public BitsTree(int val) {
            this.val = val;
        }
    }

    public int findMaximumXOR(int[] nums) {
        BitsTree tree = new BitsTree(0);
        for (int n : nums) {
            BitsTree c = tree;
            for (int i = 1; i < 32; i++) {
                int v = n & (0x1 << (31 - i));
                if (v == 0) { // 0
                    if (c.zero == null) {
                        c.zero = new BitsTree(0);
                    }
                    c = c.zero;
                } else { // 1
                    if (c.one == null) {
                        c.one = new BitsTree(1);
                    }
                    c = c.one;
                }
            }
        }
        return maxXor(tree.zero, tree.one, 30);
    }

    private int maxXor(BitsTree zero, BitsTree one, int shift) {
        if (zero == null && one == null) {
            return 0;
        }
        if (zero == null) {
            return maxXor(one.zero, one.one, shift-1);
        }
        if (one == null) {
            return maxXor(zero.zero, zero.one, shift-1);
        }

        int res = (zero.val != one.val ? 0x1 : 0x0) << shift;
        int val = ((zero.zero == null ? 0x0 : 0x1) << 3) +
                ((zero.one == null ? 0x0 : 0x1) << 2) +
                ((one.zero == null ? 0x0 : 0x1) << 1) +
                ((one.one == null ? 0x0 : 0x1) << 0);
        switch (val){
            case 0:
                return res;
            case 5:
                return res + maxXor(zero.one, one.one, shift-1);
            case 6:
                return res + maxXor(zero.one, one.zero, shift-1);
            case 7:
                return res + maxXor(zero.one, one.zero, shift-1);
            case 9:
                return res + maxXor(zero.zero, one.one, shift-1);
            case 10:
                return res + maxXor(zero.zero, one.zero, shift-1);
            case 11:
                return res + maxXor(zero.zero, one.one, shift-1);
            case 13:
                return res + maxXor(zero.zero, one.one, shift-1);
            case 14:
                return res + maxXor(zero.one, one.zero, shift-1);
            case 15:
                return res + Math.max(maxXor(zero.zero, one.one, shift-1),
                        maxXor(zero.one, one.zero, shift-1));
            default:
                throw new IllegalArgumentException("invalid input");
        }
    }
}
