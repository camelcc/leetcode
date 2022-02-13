import java.util.Arrays;

public class S2171RemovingMinimumNumberMagicBeans {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long[] pre = new long[beans.length];
        long sum = 0;
        for (int i = 0; i < beans.length; i++) {
            pre[i] = sum;
            sum += beans[i];
        }

        long res = sum;
        long post = 0;
        for (int i = beans.length-1; i >= 0; i--) {
            long r = post-(beans.length-1-i)*(long)(beans[i])+pre[i];
            res = Math.min(res, r);
            post += beans[i];
        }
        return res;
    }
}
