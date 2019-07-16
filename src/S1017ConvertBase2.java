public class S1017ConvertBase2 {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        int bit = 0;
        int[] res = new int[32];
        while (N != 0) {
            boolean one = N%2 == 1;
            if (one) {
                increment(res, bit);
            }
            N = N/2;
            bit++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < 32) {
            if (res[i] != 0 || sb.length() > 0) {
                sb.append(res[i] == 0 ? '0' : '1');
            }
            i++;
        }
        return sb.toString();
    }

    private void increment(int[] bits, int pos) {
        int N = bits.length-1;
        boolean even = pos%2 == 0;
        if (even && bits[N-pos] == 0) {
            bits[N-pos] = 1;
        } else if (even && bits[N-pos] == 1) {
            bits[N-pos] = 0;
            increment(bits, pos+1);
        } else if (!even && bits[N-pos] == 0) {
            bits[N-pos] = 1;
            increment(bits, pos+1);
        } else if (!even && bits[N-pos] == 1) {
            bits[N-pos] = 0;
        }
    }
}
