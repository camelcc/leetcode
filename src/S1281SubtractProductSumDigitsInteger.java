public class S1281SubtractProductSumDigitsInteger {
    public int subtractProductAndSum(int n) {
        if (n == 0) {
            return 0;
        }
        int prod = 1, sum = 0;
        while (n != 0) {
            int d = n%10;
            n = n/10;
            prod *= d;
            sum += d;
        }
        return prod-sum;
    }
}
