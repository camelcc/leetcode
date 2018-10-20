public class S0868BinaryGap {
    public int binaryGap(int N) {
        int dis = 0;
        int pre = -1;

        int i = 0;
        while (N > 0) {
            if (N%2 == 1) {
                if (pre >= 0 && (i-pre) > dis) {
                    dis = i-pre;
                }
                pre = i;
            }

            N = N >> 1;
            i++;
        }
        return dis;
    }
}
