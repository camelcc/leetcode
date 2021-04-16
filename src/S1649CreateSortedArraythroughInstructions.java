import java.util.TreeMap;

public class S1649CreateSortedArraythroughInstructions {
    static int[] BIT;

    private static int sum(int i) {
        int res = 0;
        for (int j = i; j > 0; j -= j & (-j))
            res += BIT[j];
        return res;
    }

    private static void update(int i) {
        for (int j = i; j < BIT.length; j += j & (-j))
            BIT[j]++;
    }

    public static int createSortedArray(int[] instructions) {
        int max = Integer.MIN_VALUE;
        for (int ins : instructions)
            max = Math.max(max, ins);

        BIT = new int[max + 2];

        int res = 0;

        for (int i = 0; i < instructions.length; i++) {
            int ins = instructions[i];
            int lo = sum(ins - 1);
            int hi = i - sum(ins);
            res += Math.min(lo, hi);
            res %= 1000000007;
            update(ins);
        }

        return res;
    }
}
