public class S2303CalculateAmountPaidTaxes {
    public double calculateTax(int[][] brackets, int income) {
        int i = 0;
        double res = 0;
        int prev = 0;
        while (i < brackets.length) {
            res += 1.0 * (Math.min(income, brackets[i][0])-prev) * brackets[i][1] / 100.0;
            if (brackets[i][0] > income) {
                break;
            }
            prev = brackets[i][0];
            i++;
        }
        return res;
    }
}
