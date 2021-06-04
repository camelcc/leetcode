public class S1835FindXORSumAllPairsBitwiseAND {
    public int getXORSum(int[] arr1, int[] arr2) {
        int[] one = new int[32];
        for (int v : arr2) {
            for (int i = 0; i < 32; i++) {
                if ((v&(0x1<<i)) != 0) {
                    one[i]++;
                }
            }
        }
        int[] res = new int[32];
        for (int v : arr1) {
            for (int i = 0; i < 32; i++) {
                if ((v&(0x1<<i)) != 0 && one[i]%2 == 1) {
                    res[i]++;
                }
            }
        }
        int r = 0;
        for (int i = 0; i < 32; i++) {
            if (res[i]%2 == 1) {
                r = r|(0x1<<i);
            }
        }
        return r;
    }
}
