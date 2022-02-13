public class S2160MinimumSumFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        int d1 = num%10;
        num = num/10;
        int d2 = num%10;
        num = num/10;
        int d3 = num%10;
        num = num/10;
        int d4 = num%10;
        int res = Math.min(d1*10+d2, d2*10+d1) + Math.min(d3*10+d4, d4*10+d3);
        res = Math.min(res, Math.min(d1*10+d4, d4*10+d1) + Math.min(d2*10+d3, d3*10+d2));
        res = Math.min(res, Math.min(d1*10+d3, d3*10+d1) + Math.min(d2*10+d4, d4*10+d2));
        return res;
    }
}
