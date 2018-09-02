//TODO: Kolakoski sequence
public class S0481MagicalString {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int res = 1;

        int[] num = new int[n];
        num[0] = 1;
        num[1] = 2;
        num[2] = 2;

        int count = 2;
        int data = 2;
        while (count < n) {
            int gen = num[count++];
            if (gen == 1) {
                res++;
            }

            if (data >= n - 1) {
                continue;
            }
            int next = num[data] == 1 ? 2 : 1;
            num[++data] = next;
            if (data >= n - 1) {
                continue;
            }
            if (gen != 1) {
                num[++data] = next;
            }
        }

        return res;
    }
}
