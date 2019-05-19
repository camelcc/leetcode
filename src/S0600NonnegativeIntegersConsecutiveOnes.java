import java.util.LinkedList;

public class S0600NonnegativeIntegersConsecutiveOnes {
    public int findIntegers(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 2;
        }

        int[] c = new int[32];
        c[0] = 2;
        c[1] = 3;
        for (int i = 2; i < 32; i++) {
            c[i] = c[i - 1] + c[i - 2];
        }

        int bits = 0;
        while ((1 << bits) <= num) {
            bits++;
        }
        bits--;


        int curr = 1 << bits;
        int res = c[bits - 1];
        bits -= 2;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curr, bits});
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            int val = t[0];
            int bit = t[1];
            if (bit < 0) {
                if (val <= num) {
                    res++;
                }
                continue;
            }

            if (val + (1 << (bit + 1)) <= num) {
                res += c[bit];
                continue;
            }

            queue.add(new int[]{val, bit-1});
            queue.add(new int[]{val + (1 << bit), bit - 2});
        }
        return res;
    }
}
