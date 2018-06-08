public class S0258AddDigits {
    // TODO: O(1) time without loop or recursion
    // https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
    public int addDigits(int num) {
        int res = num;
        while (res >= 10) {
            res = add(res);
        }

        return res;
    }

    private int add(int num) {
        int res = 0;
        while (num > 0) {
            res += num%10;
            num = num/10;
        }
        return res;
    }
}
