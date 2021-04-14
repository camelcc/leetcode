public class S1646GetMaximumGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] data = new int[101];
        data[1] = 1;
        int i = 1;
        int res = 1;
        while (i <= n) {
            if (2*i <= n) {
                data[2*i] = data[i];
            }
            if (2*i+1 <= n) {
                data[2*i+1] = data[i] + data[i+1];
            }
            if (data[i] > res) {
                res = data[i];
            }
            i++;
        }
        return res;
    }
}
