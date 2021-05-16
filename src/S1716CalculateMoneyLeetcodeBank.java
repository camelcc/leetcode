public class S1716CalculateMoneyLeetcodeBank {
    public int totalMoney(int n) {
        int weeks = (n-1)/7;
        int res = 21*weeks + 7*weeks*(weeks+1)/2;
        n = n - 7*weeks;
        int m = weeks+1;
        while (n > 0) {
            res += m;
            m++;
            n--;
        }
        return res;
    }
}
