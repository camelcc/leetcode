import java.util.Arrays;

public class S1652DefuseBomb {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        Arrays.fill(res, 0);
        if (k == 0) {
            return res;
        }
        int sum = 0;
        if (k < 0) {
            for (int i = code.length+k; i < code.length; i++) {
                sum += code[i];
            }
            for (int i = 0; i < code.length; i++) {
                res[i] = sum;
                sum -= code[(i+k+code.length)%code.length];
                sum += code[i];
            }
        } else if (k > 0) {
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }
            for (int i = code.length-1; i >= 0; i--) {
                res[i] = sum;
                sum -= code[(i+k)%code.length];
                sum += code[i];
            }
        }
        return res;
    }
}
