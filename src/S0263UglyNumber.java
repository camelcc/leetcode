public class S0263UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int n = num;
        while (n > 1) {
            if (n%2==0) {
                n = n/2;
                continue;
            }
            if (n%3==0) {
                n = n/3;
                continue;
            }
            if (n%5==0) {
                n = n/5;
                continue;
            }
            return false;
        }
        return true;
    }
}
