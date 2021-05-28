public class S1780CheckNumberSumPowersThree {
    public boolean checkPowersOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n%3 == 0) {
            return checkPowersOfThree(n/3);
        }
        if ((n-1)%3 != 0) {
            return false;
        }
        return checkPowersOfThree((n-1)/3);
    }
}
