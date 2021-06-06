import java.util.Arrays;

public class S1850MinimumAdjacentSwapsReachKthSmallestNumber {
    public int getMinSwaps(String num, int k) {
        String min = num;
        while (k > 0) {
            min = next(min);
            k--;
        }
        char[] mc = min.toCharArray(), nc = num.toCharArray();
        int res = 0;
        for (int i = 0; i < mc.length; i++) {
            if (mc[i] == nc[i]) {
                continue;
            }
            int j = i+1;
            while (j < nc.length && nc[j] != mc[i]) {
                j++;
            }
            res += j-i;
            char t = nc[j];
            while (j > i) {
                nc[j] = nc[j-1];
                j--;
            }
            nc[i] = t;
        }
        return res;
    }

    private String next(String num) {
        char[] c = num.toCharArray();
        char max = c[c.length-1];
        int i = num.length()-1;
        while (i >= 0 && c[i] >= max) {
            max = (char) Math.max(max, c[i]);
            i--;
        }
        // num[i] < max
        int p = -1;
        for (int j = i+1; j < c.length; j++) {
            if (c[j] > c[i] && (p == -1 || c[j] < c[p])) {
                p = j;
            }
        }
        char t = c[i];
        c[i] = c[p];
        c[p] = t;
        // sort [i+1
        Arrays.sort(c, i+1, c.length);
        return new String(c);
    }
}
