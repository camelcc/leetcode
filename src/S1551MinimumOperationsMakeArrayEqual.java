public class S1551MinimumOperationsMakeArrayEqual {
    public int minOperations(int n) {
        if (n%2 == 0) {
            return n*n/4;
        } else {
            int res = 0;
            for (int i = n-2; i >= 1; i -= 2) {
                res += n-i;
            }
            return res;
        }
    }
}
