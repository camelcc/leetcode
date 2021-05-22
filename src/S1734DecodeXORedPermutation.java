public class S1734DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int[] ones = new int[32];
        for (int v = 1; v <= encoded.length+1; v++) {
            for (int i = 0; i < 32; i++) {
                if ((v&(0x1<<i)) != 0) {
                    ones[i]++;
                }
            }
        }

        int[] res = new int[encoded.length+1];
        for (int i = 0; i < 32; i++) {
            // guess 0 for position i
            int pre = 0, cnt = 0;
            for (int j = 0; j < encoded.length; j++) {
                int cur = (pre ^ encoded[j]) & (0x1<<i);
                if (cur != 0) {
                    cnt++;
                }
                pre = cur;
            }
            if (cnt == ones[i]) {
                pre = 0;
            } else {
                pre = (0x1<<i);
                res[0] = res[0] | pre;
            }
            for (int j = 0; j < encoded.length; j++) {
                int cur = (pre ^ encoded[j]) & (0x1<<i);
                pre = cur;
                res[j+1] = res[j+1] | cur;
            }
        }
        return res;
    }
}
