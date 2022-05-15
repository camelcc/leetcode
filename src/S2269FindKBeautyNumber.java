public class S2269FindKBeautyNumber {
    public int divisorSubstrings(int num, int k) {
        char[] chs = String.valueOf(num).toCharArray();
        if (chs.length <= k) {
            return 1;
        }
        int i = 0, res = 0;
        while (i <= chs.length-k) {
            int v = 0;
            for (int j = i; j < i+k; j++) {
                v = v*10 + (chs[j]-'0');
            }
            if (v != 0 && num%v == 0) {
                res++;
            }
            i++;
        }
        return res;
    }
}
