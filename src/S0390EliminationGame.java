public class S0390EliminationGame {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }

        // left to right
        int lr = n/2;
        if (lr < 2) {
            return 2;
        }
        // lr >= 2
        // right to left
        if (lr%2 == 0) { // even
            return 2*(2 * (lastRemaining(lr/2)) - 1);
        } else { // odd, lr >= 3
            return 4 * (lastRemaining((lr-1)/2));
        }
    }
}
