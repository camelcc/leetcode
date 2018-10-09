public class S0374GuessNumberHigherLower {
    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess < 0) {
                hi = mid-1;
            } else { // guess > 0
                lo = mid+1;
            }
        }
        return -1;
    }
}
