public class S1009ComplementBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int i = 0, res = 0;
        while ((0x1<<i) <= N) {
            if ((N&(0x1<<i)) == 0) {
                res += (0x1<<i);
            }
            i++;
        }
        return res;
    }
}
