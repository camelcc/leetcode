public class S1952ThreeDivisors {
    public boolean isThree(int n) {
        if (n <= 2) {
            return false;
        }
        int root = (int)Math.sqrt(n);
        for (int d = 2; d < root; d++) {
            if (n%d == 0) {
                return false;
            }
        }
        return root*root == n;
    }
}
