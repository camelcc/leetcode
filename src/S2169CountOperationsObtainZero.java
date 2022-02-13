public class S2169CountOperationsObtainZero {
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        int res = 0;
        if (num1 >= num2) {
            res += (num1-num2)/num2 + 1;
            num1 -= num2*res;
        } else {
            res += (num2-num1)/num1 + 1;
            num2 -= num1*res;
        }
        return res + countOperations(num1, num2);
    }
}
