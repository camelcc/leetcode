import java.util.Arrays;

public class S1073AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            int[] t = arr1;
            arr1 = arr2;
            arr2 = t;
        }
        int[] res = new int[arr1.length + 2];
        for (int i = 0; i < arr1.length; i++) {
            res[i + 2] = arr1[i];
        }
        int pos = 0;
        while (pos < arr2.length) {
            if (arr2[arr2.length-1-pos] != 0) {
                increment(res, pos);
            }
            pos++;
        }
        int p = 0;
        while (p < res.length && res[p] == 0) {
            p++;
        }
        if (p == res.length) {
            p--;
        }
        return Arrays.copyOfRange(res, p, res.length);
    }

    private void increment(int[] res, int pos) {
        int N = res.length;
        if (res[N - 1 - pos] == 0) {
            res[N - 1 - pos] = 1;
            return;
        }
        res[N-1-pos] = 0;
        if (res[N-1-pos-1] == 1) {
            res[N-1-pos-1] = 0;
        } else {
            res[N-1-pos-1] = 1;
            increment(res, pos+2);
        }
    }
}
