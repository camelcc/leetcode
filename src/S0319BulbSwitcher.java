public class S0319BulbSwitcher {
    public int bulbSwitch(int n) {
        int count = 0; // 1
        for (int i = 1; i <= n; i++) {
            if (divideCount(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean divideCount(int n) {
        if (n == 1) {
            return true; // on, 0
        }
        if (n == 2) {
            return false; // off, 1
        }

        int root = (int)Math.sqrt(n);
        return root*root == n;
    }
}
