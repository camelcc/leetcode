public class S0338CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i>>1] + (i&0x1);
        }
        return res;
    }
}
