public class S2110NumberSmoothDescentPeriodsStock {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int pre = Integer.MAX_VALUE, cnt = 0;
        for (int price : prices) {
            if (price == pre-1) {
                res += (cnt+1);
                cnt++;
            } else {
                res += 1;
                cnt = 1;
            }
            pre = price;
        }
        return res;
    }
}
