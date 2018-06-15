public class S0476NumberComplement {
    public int findComplement(int num) {
        if (num < 0) {
            return 0-num-1;
        } else {
            int res = 0;
            int bits = 0;
            while (num > 0) {
                res = res | ((1 - num%2) << bits);
                num = num >> 1;
                bits++;
            }
            return res;
        }
    }
}
